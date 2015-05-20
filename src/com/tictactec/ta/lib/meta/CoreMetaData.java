/* TA-LIB Copyright (c) 1999-2007, Mario Fortier
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 *
 * - Neither name of author nor the names of its contributors
 *   may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/* List of contributors:
 *
 *  Initial  Name/description
 *  -------------------------------------------------------------------
 *  RG       Richard Gomes
 *
 * Change history:
 *
 *  YYYYMMDD BY     Description
 *  -------------------------------------------------------------------
 *  20070311 RG     First Version
 */

package com.tictactec.ta.lib.meta;

import java.lang.annotation.Annotation;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.tictactec.ta.lib.CoreAnnotated;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;
import com.tictactec.ta.lib.meta.annotation.FuncInfo;
import com.tictactec.ta.lib.meta.annotation.InputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.InputParameterType;
import com.tictactec.ta.lib.meta.annotation.IntegerList;
import com.tictactec.ta.lib.meta.annotation.IntegerRange;
import com.tictactec.ta.lib.meta.annotation.OptInputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OptInputParameterType;
import com.tictactec.ta.lib.meta.annotation.OutputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OutputParameterType;
import com.tictactec.ta.lib.meta.annotation.RealList;
import com.tictactec.ta.lib.meta.annotation.RealRange;


/**
 * CoreMetaData dostarcza nieskopoziomowego RTTI (Run Time Type Information) dla funkcji. Również dostarcza metod dla tych, którzy chcą wywołac funkcję używając Late Binding Techniques.
 * Te dwie funkcjonalności pozwalają na wywoływanie funkcji dynamicznie. Nawet jeźli zostaną dodane nowe funkcje do bibliooteki TA-LIB, twój kod aplikacji będzie mógł wywołac wszystkie dodane funkcje, pytając pakiet TA-Lib o:
 * <ul>
 * <li>dostępne funkcje
 * <li>dostępne grupy funkcji
 * <li>argumenty wejściowe funkcji oraz RTTI
 * <li>argumenty wyjściowa funkcji oraz RTTI
 * <li>opcjonalne argumentu wejsciowe funkcji oraz RTTI
 *</ul>
 * @author Artur Ratajczak
 *
 */
public class CoreMetaData implements Comparable<CoreMetaData> {
    
    private static transient final String CONTACT_DEVELOPERS = "Contact developers";
    private static transient final String INDEX_OUT_OF_BOUNDS = "Index out of bounds";
    private static transient final String ILLEGAL_NUMBER_OF_ARGUMENTS = "Illegal number of arguments";

    private static transient final String ARRAY_IS_NULL = "Array is null";
    private static transient final String INT_ARRAY_EXPECTED = "int[] expected";
    private static transient final String DOUBLE_ARRAY_EXPECTED = "double[] expected";
    private static transient final String PRICE_EXPECTED = "PriceInputParameter object expected";
    
    private static transient final Class<CoreAnnotated> coreClass = CoreAnnotated.class;
    private static transient final String LOOKBACK_SUFFIX = "Lookback";

    private static transient CoreAnnotated taCore = null;

    private String name = null;
    private Method function = null;
    private Method lookback = null;
    
    private static transient Map<String, CoreMetaData> taFuncMap = null;
    private static transient Map<String, Set<CoreMetaData> > taGrpMap = null;

    private transient Object callInputParams[] = null;
    private transient Object callOutputParams[] = null;
    private transient Object callOptInputParams[] = null;
    
    
    protected CoreMetaData() {
        synchronized (coreClass) {
            if (taCore==null) {
                taCore = new CoreAnnotated();
            }
        }
    }
    /**
     * Metoda porównująca CireMetaData między sobą
     * @param arg Obiekt CoreMetaData do porównania
     * @return liczba oznaczająca porównianie.
     */
    public int compareTo(CoreMetaData arg) {
        return this.name.compareTo(arg.name);
    }
    /**
     * Metoda pobiera wszystkie funkcjie i zwraca je w postaci obiektu Map<String, CoreMetaData>
     * @return spis wszystkich funkcji
     * @throws Throwable
     */
    static private Map<String, CoreMetaData> getAllFuncs() {
        synchronized (coreClass) {
            if (taFuncMap == null) {
                taFuncMap = getTaFuncMetaInfoMap();
            }
        }
        return taFuncMap;
    }
    /**
     * Metoda pobiera wszystkie grupy funkcji i zwraca je w postaci obiektu Map<String, Set<CoreMetaData>>
     * @return spis wszystkich grup funkcji
     * @throws Throwable
     */
    static private Map<String, Set<CoreMetaData> > getAllGrps() {
        synchronized (coreClass) {
            if (taGrpMap == null) {
                taGrpMap = getTaGrpMetaInfoMap();
            }
        }
        return taGrpMap;
    }
    /**
     * Metoda pobiera wszystkie metody Lookback i zwraca je w postaci obiektu Map<String, Method>
     * @return listę metod Lookback
     */
    static private Map<String, Method> getLookbackMethodMap() {
        Map<String, Method> map = new HashMap<String, Method>();
        Method[] ms = coreClass.getDeclaredMethods();
        for (Method m : ms) {
            if (m.getName().endsWith(LOOKBACK_SUFFIX)) {
                map.put(m.getName(), m);
                // System.out.println("lookback="+m.getName());
            }
        }
        return map;
    }
    /**
     * Metoda pobiere Informacje na temat funkcji w blibliotece TA i zwraca je w postaci obiektu Map<String, CoreMetaData>
     * @return liste informacji na temat funkcji w bibliotece TA
     */
    static private Map<String, CoreMetaData> getTaFuncMetaInfoMap() {
        Map<String, CoreMetaData> result = new TreeMap<String, CoreMetaData>();
        Method[] ms = coreClass.getDeclaredMethods();
        Map<String, Method> lookbackMap = getLookbackMethodMap();
        for (Method funcMethod : ms) {
            String fn = funcMethod.getName();
            if (funcMethod.getReturnType().equals(RetCode.class))
            // && !fn.startsWith(INT_PREFIX))
            {
                String lookbackName = fn + LOOKBACK_SUFFIX;
                Method lookbackMethod = lookbackMap.get(lookbackName);
                if (lookbackMethod != null) {
                    FuncInfo info = getFuncInfo(funcMethod);
                    String funcName = info.name();
                    CoreMetaData mi = new CoreMetaData();
                    mi.name = funcName;
                    mi.function = funcMethod;
                    mi.lookback = lookbackMethod;
                    result.put(funcName, mi);
                }
            }
        }
        return result;
    }
    /**
     * Metoda pobiera Informacje na temat grup w bibliotece TA i zwraca je w postaci obiektu Map<String, Set<CoreMetaData>>
     * @return listę informacji na temat grup w bibliotece TA
     */
    static private Map<String, Set<CoreMetaData> > getTaGrpMetaInfoMap() {
        if (taFuncMap==null) getAllFuncs();
        Map<String, Set<CoreMetaData> > result = new TreeMap<String, Set<CoreMetaData> >();
        for (String func : taFuncMap.keySet()) {
            CoreMetaData mi = taFuncMap.get(func);
            String group = mi.getFuncInfo().group();
            Set<CoreMetaData> set = result.get(group);
            if (set==null) {
                set = new TreeSet<CoreMetaData>();
                result.put(group, set);
            }
            set.add(mi);
        }
        return result;
    }
    /**
     * Metoda pobiera informacje na temat Metody TA.
     * @param method Metoda z biblioteki TA
     * @return Opic funkcji
     * @throws IncompleteAnnotationException
     */
    static private FuncInfo getFuncInfo(Method method) throws IncompleteAnnotationException {
        FuncInfo annotation = method.getAnnotation(FuncInfo.class);
        if (annotation != null) return annotation;
        throw new IncompleteAnnotationException(FuncInfo.class, "Method " + method.getName());
    }
    /**
     * Metoda zwraca uchwyt do funkcji
     * @param name Nazwa funkcji.
     * @return Obiekt CoreMetaData jako urchwyt do funkcji
     * @throws NoSuchMethodException jeśli nazwa funkcji nie zostanie znaleziona w zbiorze wszystkich funkcji.
     */
    static CoreMetaData getFuncHandle(final String name) throws NoSuchMethodException {
        CoreMetaData mi = getAllFuncs().get(name.toUpperCase());
        if (mi == null) throw new NoSuchMethodException(name.toUpperCase());
        mi.callInputParams = null;
        mi.callOutputParams = null;
        mi.callOptInputParams = null;
        if (mi != null) return mi;
        throw new NoSuchMethodException("Function " + name);
    }

    /**
     * Zwraca instancję, która opisuje metoda TA (uchwyt do metody).
     * @param name Nazwa funkcji
     * @return instancję obiektu CoreMetaData
     * @throws NoSuchMethodException jeśli nazwa funkcji nie zostanie znaleziona w zbiorze wszystkich funkcji.
     */
    static public CoreMetaData getInstance(final String name) throws NoSuchMethodException {
        return getFuncHandle(name);
    }

    /**
     * Zwraca adnotację, która opisuje funkcję TA.
     * @return Interfej FuncInfo
     * @throws IncompleteAnnotationException 
     */
    public FuncInfo getFuncInfo() throws IncompleteAnnotationException {
        return getFuncInfo(function);
    }
    /**
     * Metoda pobiera informacje na temat parametru
     * @param paramIndex Indeks parametru
     * @param paramAnnotation Typ parametru
     * @return informacje na temat parametru w postaci obiektu Annotation
     */
    private Annotation getParameterInfo(final int paramIndex, Class<? extends Object> paramAnnotation) {
        if (paramIndex < 0)
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        int i = 0;
        for (Annotation[] annArray : function.getParameterAnnotations()) {
            for (Annotation ann : annArray) {
                if ((ann.annotationType() == paramAnnotation) && (paramIndex == i++)) {
                    return ann;
                }
            }
        }
        return null;
    }

    private Annotation getParameterInfo(final int paramIndex, Class<? extends Object> paramAnnotation, Class<? extends Object> paramExtraAnnotation) {
        if (paramIndex < 0)
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS);
        int i = 0;
        for (Annotation[] annArray : function.getParameterAnnotations()) {
            for (Annotation ann : annArray) {
                if ((ann.annotationType() == paramAnnotation) && (paramIndex == i++)) {
                    for (Annotation annExt : annArray) {
                        if (annExt.annotationType() == paramExtraAnnotation) {
                            return annExt;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty parametr wejsciowy.
     * @param paramIndex Indeks parametru
     * @return adnotacje opisujaca n-ty parametr wejsciowy
     * @throws IllegalArgumentException
     */
    public InputParameterInfo getInputParameterInfo(final int paramIndex) throws IllegalArgumentException {
        return (InputParameterInfo) getParameterInfo(paramIndex, InputParameterInfo.class);
    }

    /**
     * Metoda zwraca adnotację, która opisuje n-ty parametr wyjściowy.
     * @param paramIndex Indeks parametru.
     * @return adnotacje opisująca n-ty parametr wyjściowy.
     * @throws IllegalArgumentException
     */
    public OutputParameterInfo getOutputParameterInfo(final int paramIndex) throws IllegalArgumentException {
        return (OutputParameterInfo) getParameterInfo(paramIndex, OutputParameterInfo.class);
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty opcjonalny parametr wejsciowy.
     * @param paramIndex Indeks parametru.
     * @return adnotacje opisująca n-ty opcjonalny parametr wejściowy.
     * @throws IllegalArgumentException
     */
    public OptInputParameterInfo getOptInputParameterInfo(final int paramIndex) throws IllegalArgumentException {
        return (OptInputParameterInfo) getParameterInfo(paramIndex, OptInputParameterInfo.class);
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty opcjonalny parametr wejściowy i oczekuje się typu IntererList
     * @param paramIndex Indeks parametru
     * @return interfejs IntegerList
     * @throws IllegalArgumentException
     */
    public IntegerList getOptInputIntegerList(final int paramIndex) throws IllegalArgumentException {
        return (IntegerList) getParameterInfo(paramIndex, OptInputParameterInfo.class, IntegerList.class);
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty opcjonalny parametr wejściowy i i oczekuje się typu IntegerRange
     * @param paramIndex Indeks parametru
     * @return Interfejs IntegerRange
     * @throws IllegalArgumentException
     */
    public IntegerRange getOptInputIntegerRange(final int paramIndex) throws IllegalArgumentException {
        return (IntegerRange) getParameterInfo(paramIndex, OptInputParameterInfo.class, IntegerRange.class);
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty opcjonalny parametr wejściowy i oczekuje się typu RealList
     * @param paramIndex Indeks parametru.
     * @return Interfejs RealList
     * @throws IllegalArgumentException
     */
    public RealList getOptInputRealList(final int paramIndex) throws IllegalArgumentException {
        return (RealList) getParameterInfo(paramIndex, OptInputParameterInfo.class, RealList.class);
    }

    /**
     * Metoda zwraca adnotacje, która opisuje n-ty opcjonalny parametr wejściowy i oczekuje się typu RealRange
     * @param paramIndex Indeks parametru.
     * @return Interfejs RealRange
     * @throws IllegalArgumentException
     */
    public RealRange getOptInputRealRange(final int paramIndex) throws IllegalArgumentException {
        return (RealRange) getParameterInfo(paramIndex, OptInputParameterInfo.class, RealRange.class);
    }

    /**
     * Metoda ustawia nową wartośc typu int dla n-tego opcjonalny parametr wejściowy. Oczekuje się kompatybilności n-tego parametru z int.
     * @param paramIndex Indeks parametru
     * @param value Wartośc do ustawienia
     * @throws IllegalArgumentException
     * @throws InternalError
     */
    public void setOptInputParamInteger(final int paramIndex, final int value) throws IllegalArgumentException {
        OptInputParameterInfo param = getOptInputParameterInfo(paramIndex);
        if (param==null) throw new InternalError(CONTACT_DEVELOPERS);
        if (param.type()==OptInputParameterType.TA_OptInput_IntegerList) {
            IntegerList list = getOptInputIntegerList(paramIndex);
            for (int entry : list.value()) {
                if (value==entry) {
                    if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                    callOptInputParams[paramIndex] = value;
                    return;
                }
            }
        } else if (param.type()==OptInputParameterType.TA_OptInput_IntegerRange) {
            IntegerRange range = getOptInputIntegerRange(paramIndex);
            if ((value >= range.min())&&(value <= range.max())) {
                if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                callOptInputParams[paramIndex] = value;
                return;
            }
        } 
        throw new InternalError(CONTACT_DEVELOPERS);
    }

    /**
     * Metoda ustawia nową wartośc typu int, pobraną z obiektu typu String dla n-tego opcjonalnego parametru wejściowego. Oczekuje się kompatybilności n-tego parametru z int.
     * @param paramIndex indeks parametru
     * @param string wartośc która zostanie zmieniona na int.
     * @throws IllegalArgumentException
     * @throws InternalError
     */
    public void setOptInputParamInteger(final int paramIndex, final String string) throws IllegalArgumentException {
        try {
            Integer v = new Integer(string);
            setOptInputParamInteger(paramIndex, v.intValue());
        } catch (NumberFormatException e) {
            OptInputParameterInfo param = getOptInputParameterInfo(paramIndex);
            if (param==null) throw new InternalError(CONTACT_DEVELOPERS);
            if (param.type()!=OptInputParameterType.TA_OptInput_IntegerList) throw new InternalError(CONTACT_DEVELOPERS);

            // FIXME: The correct implementation should ...
            // expose a field in @IntegerList informing
            // which Class should be taken for introspection.
            // Currently, all IntegerList instances implicitly depend on MAType class
            // but it may change some day.
            
            MAType[] fields = MAType.values();
            for (MAType value : fields) {
                if (value.name().toUpperCase().equals(string.toUpperCase())) {
                    if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                    callOptInputParams[paramIndex] = value;
                    return;
                }
            }
            throw new InternalError(CONTACT_DEVELOPERS);
        }
    }

    /**
     * Metoda ustawia nową wartośc typu double dla n-tego opcjonalnego paarametru wejściowego. Oczekuje się kompatybliności n-tego parametru z double.
     * @param paramIndex Indeks parametru
     * @param value Nowa wartośc
     * @throws IllegalArgumentException
     * @throws InternalError
     */
    public void setOptInputParamReal(final int paramIndex, final double value) throws IllegalArgumentException {
        OptInputParameterInfo param = getOptInputParameterInfo(paramIndex);
        if (param.type()==OptInputParameterType.TA_OptInput_RealList) {
            RealList list = getOptInputRealList(paramIndex);
            for (double entry : list.value()) {
                if (value==entry) {
                    if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                    callOptInputParams[paramIndex] = value;
                    return;
                }
            }
        } else if (param.type()==OptInputParameterType.TA_OptInput_RealRange) {
            RealRange range = getOptInputRealRange(paramIndex);
            if ((value >= range.min())&&(value <= range.max())) {
                if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                callOptInputParams[paramIndex] = value;
                return;
            }
        }
        throw new InternalError(CONTACT_DEVELOPERS);
    }

    /**
     * Metoda ustawia nową wartośc typu double pobraną z obiektu typu String dla n-tego opcjonalnego paarametru wejściowego. Oczekuje się kompatybliności n-tego parametru z double.
     * @param paramIndex Indeks parametru
     * @param string Nowa wartośc double pobrana z obiektu typu String
     * @throws IllegalArgumentException
     * @throws InternalError
     */
    public void setOptInputParamReal(final int paramIndex, final String string) throws IllegalArgumentException {
        try {
            Double v = new Double(string);
            setOptInputParamReal(paramIndex, v.doubleValue());
        } catch (NumberFormatException e) {
            OptInputParameterInfo param = getOptInputParameterInfo(paramIndex);
            if (param==null) throw new InternalError(CONTACT_DEVELOPERS);
            if (param.type()==OptInputParameterType.TA_OptInput_RealList) {
                RealList list = getOptInputRealList(paramIndex);
                for (int i=0; i<list.string().length; i++) {
                    if (string.toUpperCase().equals(list.string()[i])) {
                        if (callOptInputParams==null) callOptInputParams = new Object[getFuncInfo().nbOptInput()];
                        double value = list.value()[i];
                        callOptInputParams[paramIndex] = value;
                        return;
                    }
                }
            }
            throw new InternalError(CONTACT_DEVELOPERS);
        }
    }

    /**
     * Metoda ustawia nową tablice double[] dla n-tego parametru wejściowego. Oczekuje się kompatybilności n-tego parametru wejściowego z typem double[].
     * @param paramIndex indeks parametru
     * @param array lista nowych wartosci postaci double[]
     * @throws IllegalArgumentException jeśli tablica nie jest typu double[]
     * @throws NullPointerException jesli lista jest pusta.
     * @throws InternalError jeśli n-ty parametr nie jest typu Real
     */
    public void setInputParamReal(final int paramIndex, final Object array) throws IllegalArgumentException, NullPointerException {
        if (array==null) throw new NullPointerException(ARRAY_IS_NULL);
        InputParameterInfo param = getInputParameterInfo(paramIndex);
        if ((param==null) || (param.type()!=InputParameterType.TA_Input_Real)) throw new InternalError(CONTACT_DEVELOPERS);
        if (! (array instanceof double[]) ) throw new IllegalArgumentException(DOUBLE_ARRAY_EXPECTED);
        if (callInputParams==null) callInputParams = new Object[getFuncInfo().nbInput()];
        callInputParams[paramIndex] = array;
    }

    /**
     * 
     * Metoda ustawia nową tablice int[] dla n-tego parametru wejściowego. Oczekuje się kompatybilności n-tego parametru wejściowego z typem int[].
     * @param paramIndex indeks parametru
     * @param array lista nowych wartosci postaci int[]
     * @throws IllegalArgumentException jeśli tablica nie jest typu int[]
     * @throws NullPointerException jesli lista jest pusta.
     * @throws InternalError jeśli n-ty parametr nie jest typu Integer.
     */
    public void setInputParamInteger(final int paramIndex, final Object array) throws IllegalArgumentException, NullPointerException {
        if (array==null) throw new NullPointerException(ARRAY_IS_NULL);
        InputParameterInfo param = getInputParameterInfo(paramIndex);
        if ((param==null) || (param.type()!=InputParameterType.TA_Input_Integer)) throw new InternalError(CONTACT_DEVELOPERS);
        if (! (array instanceof int[]) ) throw new IllegalArgumentException(INT_ARRAY_EXPECTED);
        if (callInputParams==null) callInputParams = new Object[getFuncInfo().nbInput()];
        callInputParams[paramIndex] = array;
    }

    /**
     * Metoda ustawia nową tablice double[] na n-ty parametr wejściowy. Oczekuje się kompatybilności n-tego parametru wejściowego z typem PriceInputParameter.
     * @param paramIndex indeks n-tego parametru
     * @param open reprezentacja Open Prices w postaci double[]
     * @param high reprezentacja High Prices w postaci double[]
     * @param low reprezentacja Low Prices w postaci double[]
     * @param close reprezentacja Close Prices w postaci double[]
     * @param volume reprezentacje volume w postaci double[]
     * @param openInterest reprezentacja OpenInterest w postaci double[]
     * @throws IllegalArgumentException 
     * @throws NullPointerException
     * @throws InternalError jeśli n-ty parametr nie jest typu InputPrice
     */
    public void setInputParamPrice(final int paramIndex,
                final double[] open, final double[] high, final double[] low, final double[] close,
                final double[] volume, final double[] openInterest)
            throws IllegalArgumentException, NullPointerException {
        InputParameterInfo param = getInputParameterInfo(paramIndex);
        if ((param==null) || (param.type()!=InputParameterType.TA_Input_Price)) throw new InternalError(CONTACT_DEVELOPERS);
        if (callInputParams==null) callInputParams = new Object[getFuncInfo().nbInput()];
        callInputParams[paramIndex] = new PriceInputParameter(param.flags(), open, high, low, close, volume, openInterest);
    }

    /**
     * Metoda ustawi nowy PriceInputParameter na n-ty parametr wejściowy. Wymaga się by n-ty parametr wejściowy był typu PriceInputParameter.
     * @param paramIndex indekst n-tego parametru wejsciowego
     * @param array jest Obiektem od którego wymaga się kompatybilności z PriceInputParameter.
     * @throws IllegalArgumentException tablica nie jest obiektem PriceInputParameter
     * @throws NullPointerException jeśli tablica jest pusta
     * @throws InternalError parametr ma niezgodny typ z InputPrice
     */
    public void setInputParamPrice(final int paramIndex, final Object array) throws IllegalArgumentException, NullPointerException {
        if (array==null) throw new NullPointerException(ARRAY_IS_NULL);
        InputParameterInfo param = getInputParameterInfo(paramIndex);
        if ((param==null) || (param.type()!=InputParameterType.TA_Input_Price)) throw new InternalError(CONTACT_DEVELOPERS);
        if (! (array instanceof PriceInputParameter) ) throw new IllegalArgumentException(PRICE_EXPECTED);
        if (callInputParams==null) callInputParams = new Object[getFuncInfo().nbInput()];
        callInputParams[paramIndex] = array;
    }

    /**
     * Metoda przypisuje tablice double[] do n-tego parametru wyjsciowego. N-ty parametr wyjściowy powinien zachowac kompatybilnośc z double[]
     * @param paramIndex indeks n-tego parametru
     * @param array Tablica double[]
     * @throws IllegalArgumentException
     * @throws NullPointerException jeśli tablica jest pusta.
     * @throws ClassCastException 
     * @throws IllegalArgumentException jeśli tablica nie jest typem double[]
     * @throws InternalError jeśli n-ty parametr wyjściowy nie jest typu OutputReal
     */
    public void setOutputParamReal(final int paramIndex, Object array) throws IllegalArgumentException, NullPointerException, ClassCastException {
        if (array==null) throw new NullPointerException(ARRAY_IS_NULL);
        OutputParameterInfo param = getOutputParameterInfo(paramIndex);
        if ((param==null)||(param.type()!=OutputParameterType.TA_Output_Real)) throw new InternalError(CONTACT_DEVELOPERS);
        if (! (array instanceof double[]) ) throw new IllegalArgumentException(DOUBLE_ARRAY_EXPECTED);
        if (callOutputParams==null) callOutputParams = new Object[getFuncInfo().nbOutput()];
        callOutputParams[paramIndex] = array;
    }

    /**
     * 
     * Metoda przypisuje tablice int[] do n-tego parametru wyjsciowego. N-ty parametr wyjściowy powinien zachowac kompatybilnośc z int[]
     * @param paramIndex indeks n-tego parametru
     * @param array Tablica int[]
     * @throws IllegalArgumentException
     * @throws NullPointerException jeśli tablica jest pusta.
     * @throws ClassCastException 
     * @throws IllegalArgumentException jeśli tablica nie jest typem int[]
     * @throws InternalError jeśli n-ty parametr wyjściowy nie jest typu OutputInteger
     */
    public void setOutputParamInteger(final int paramIndex, Object array) throws IllegalArgumentException, NullPointerException, ClassCastException {
        if (array==null) throw new NullPointerException(ARRAY_IS_NULL);
        OutputParameterInfo param = getOutputParameterInfo(paramIndex);
        if ((param==null)||(param.type()!=OutputParameterType.TA_Output_Integer)) throw new InternalError(CONTACT_DEVELOPERS);
        if (! (array instanceof int[]) ) throw new IllegalArgumentException(INT_ARRAY_EXPECTED);
        if (callOutputParams==null) callOutputParams = new Object[getFuncInfo().nbOutput()];
        callOutputParams[paramIndex] = array;
    }

    /**
     * Pętla typu forEach po funkcjach TA wykonuje to co zostanie zaimplementowane w agrumencie który jest Interfejsem. 
     * @param service klasa implementująca interfejs TaFuncService
     * @throws Exception
     */
    static public void forEachFunc(TaFuncService service) throws Exception {
        for (CoreMetaData mi : getAllFuncs().values()) {
            service.execute(mi);
        }
    }

    /**
     * Pęta typu ForEach po grupach funkcji TA wykonuje to co zostanie zaimplementowane w argumencie który jest Interfejsem.
     * @param service klasa implementująca interfejs TaGrpService
     * @throws Exception
     */
    static public void forEachGrp(TaGrpService service) throws Exception {
        for (String group : getAllGrps().keySet()) {
            service.execute(group, taGrpMap.get(group));
        }
    }
    /**
     * Metoda pobiera tablicę opcjonalnych parametrów wejściowych.
     * @return tablica opcjonalnych parametrów wejściowych
     */
    private Object[] getOptInputParameters() {
        int size = getFuncInfo().nbOptInput();
        if (callOptInputParams==null) callOptInputParams = new Object[size];
        for (int i=0; i<size; i++) {
            if (callOptInputParams[i]==null) {
                OptInputParameterInfo param = getOptInputParameterInfo(i);
                if (param==null) throw new InternalError(CONTACT_DEVELOPERS);
                if (param.type()==OptInputParameterType.TA_OptInput_IntegerList) {
                    IntegerList list = getOptInputIntegerList(i);
                    callOptInputParams[i] = list.defaultValue();
                } else if (param.type()==OptInputParameterType.TA_OptInput_IntegerRange) {
                    IntegerRange range = getOptInputIntegerRange(i);
                    callOptInputParams[i] = range.defaultValue();
                } else if (param.type()==OptInputParameterType.TA_OptInput_RealList) {
                    RealList list = getOptInputRealList(i);
                    callOptInputParams[i] = list.defaultValue();
                } else if (param.type()==OptInputParameterType.TA_OptInput_RealRange) {
                    RealRange range = getOptInputRealRange(i);
                    callOptInputParams[i] = range.defaultValue();
                } else {
                    throw new InternalError(CONTACT_DEVELOPERS);
                }
            }
        }
        return callOptInputParams;
    }
    

    /**
     * Metoda zwraca LookBack.
     * 
     * Lookback jest liczbą punktów danych wejściowych, może by użyty w celu wyliczenia pierszego punktu danych wyjściowych.
     * Wartośc ta zależy od wejściowych argumentów opcjonalnych przekazanych do funkcji.
     * @return lockback
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public int getLookback() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object[] params = getOptInputParameters();
        return (Integer) lookback.invoke(taCore, params);
    }
    
    
    /**
     * Wykonanie obliczeń zdefiniowanych przez funkcję TA.
     * Należy podac argumenty wejściowe z których funkcja będzie pobierała dane oraz argumenty wyjściowe do których zostaną zapisane obliczenia.
     * 
     * @param startIndex to początkowe położenie danych wejściowych, które należy uwzględnic w obliczeniach funkcji TA.
     * @param endIndex to końcowe położenie danych wejściowych które należy uwzględnic w obliczeniach funkcji TA.
     * @param outBegIdx indeks wyjsciowy jest zeracany przez metode i reprezentuje początkową pozycję danych wyjściowych zwracaną przez funkcję.
     * @param outNbElement jest zwracany przez metode i reprezentuje ilośc danych wyjściowych zwróconych przez funkcję.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void callFunc(final int startIndex, final int endIndex, MInteger outBegIdx, MInteger outNbElement) 
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        int count = 0;
        for (Object item : callInputParams) {
            if (PriceInputParameter.class.isAssignableFrom(item.getClass())) {
                count += ((PriceInputParameter)item).getCount();
            } else {
                count++;
            }
        }
        count += callOutputParams.length;
        count += callOptInputParams.length;
        
        Object[] params = new Object[count+4];
        count = 0;
        params[count++] = startIndex;
        params[count++] = endIndex;

        for (Object item : callInputParams) {
            if (PriceInputParameter.class.isAssignableFrom(item.getClass())) {
                Object objs[] = ((PriceInputParameter)item).toArrays();
                for (int i=0; i<objs.length; i++) {
                    params[count++] = objs[i];
                }
            } else {
                params[count++] = item;
            }
        }

        for (Object item : callOptInputParams) {
            params[count++] = item;
        }

        params[count++] = outBegIdx;
        params[count++] = outNbElement;

        for (Object item : callOutputParams) {
            params[count++] = item;
        }
        
        Type[] types = function.getGenericParameterTypes();
        if (types.length != params.length) throw new IllegalArgumentException(ILLEGAL_NUMBER_OF_ARGUMENTS);
        //for (int i=0; i<types.length; i++) {
        //    if (! (params[i].getClass().isAssignableFrom(types[i])) ) {
        //        throw new IllegalArgumentException("Type mismatch on argument "+i+": "+types[i]);
        //    }
        //}
        
        function.invoke(taCore, params);
    }

}
