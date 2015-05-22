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

package com.tictactec.ta.lib.meta.helpers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.meta.CoreMetaData;
import com.tictactec.ta.lib.meta.annotation.FuncInfo;
import com.tictactec.ta.lib.meta.annotation.InputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.InputParameterType;
import com.tictactec.ta.lib.meta.annotation.IntegerList;
import com.tictactec.ta.lib.meta.annotation.IntegerRange;
import com.tictactec.ta.lib.meta.annotation.OptInputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OutputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OutputParameterType;
import com.tictactec.ta.lib.meta.annotation.RealList;
import com.tictactec.ta.lib.meta.annotation.RealRange;


/**
 * SimpleHelper jest prostą klasą (API level) pomocniczą bazującą na CoreMetaData
 * 
 * Klasa ta zapewnia bardzo prostą funkcjonalnoś wywoływania dynamicznego metod gdy znasz wcześniej:
 * <ul>
 * <li> nazwę funkcji
 * <li> typy argumentów wejściowych
 * <li> typy argumentów wyjściowych
 * <li> typy opcjonalnych argumentów wejściowych i wartości.
 * </ul>
 * Klasa stosowana jest głównie do celów testowych.
 *
 * @author Komentarz - Artur Ratajczak
 *
 */
public class SimpleHelper {
    
    private String   func = null;
    private String[] args = null;
    private CoreMetaData calc = null;
    
    /**
     * Konstruktor klasy SimpleHelper, przyjmuje nazwę funkcji oraz listę parametrów opcjonalnych.
     * @param func nazwa funkcji
     * @param args lista opcjonalnych argumentów wejsciowych.
     * @throws NullPointerException jeśli nie podamy nazwy funkcji
     */
    public SimpleHelper(final String func, final List<String> args) {
        if (func==null || func.length()==0) throw new NullPointerException(); //TODO: message
        this.func = func;
        if (args!=null && args.size()>0) {
            this.args = (String[]) args.toArray(new String[0]);
            for (int i=0; i<this.args.length; i++) { this.args[i] = this.args[i].toUpperCase(); }
        }
    }

    /**
     * Metoda zwraca bazową klasę CoreMetaData
     * @return bazową klasę CoreMetaData
     * @throws NoSuchMethodException 
     * @throws IllegalArgumentException Jeśli lista argumentów opcjonalnych jest dłuższa niż pozwala na to funkcja
     */
    public CoreMetaData getMetaData() throws NoSuchMethodException, IllegalArgumentException {
        if (this.calc!=null) return this.calc;
        this.calc = CoreMetaData.getInstance(func);
        FuncInfo finfo = calc.getFuncInfo();
        if (args.length>finfo.nbOptInput()) throw new IllegalArgumentException(); //TODO: message
        for (int i=0; i<args.length; i++) {
            OptInputParameterInfo ppinfo = calc.getOptInputParameterInfo(i);
            if (ppinfo.dataSet().isAssignableFrom(IntegerList.class) || ppinfo.dataSet().isAssignableFrom(IntegerRange.class)) {
                calc.setOptInputParamInteger(i, args[i]);
            } else if (ppinfo.dataSet().isAssignableFrom(RealList.class) || ppinfo.dataSet().isAssignableFrom(RealRange.class)) {
                calc.setOptInputParamReal(i, args[i]);
            } else {
                throw new ClassCastException(); //TODO: message
            }
        }
        return this.calc;
    }

    /**
     * Metoda zwraca LookBack.
     * 
     * Lookback jest liczbą punktów danych wejściowych, może by użyty w celu wyliczenia pierszego punktu danych wyjściowych.
     * Wartośc ta zależy od wejściowych argumentów opcjonalnych przekazanych do funkcji.
     * @return lockback
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public int getLookback() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return getMetaData().getLookback();
    }
    
    /**
     * Metoda wykonuje obliczenia zdefiniowane przez funkcje.
     * 
     * Należy podac argumenty wejściowe z których funkcja będzie pobierała dane oraz argumenty wyjściowe do których zostaną zapisane obliczenia.
     * Opcjonalnie można zmienic podstawowe parametry funkcji w celu wykonania obliczeń.
     * 
     * Przykład użycia:
     * <pre>
     *       func = "MAMA";
     *       params.clear();
     *       params.add("0.2");
     *       params.add("0.02");
     *       calc = new SimpleHelper(func, params);
     *       calc.calculate(0, 59, new Object[] { close }, new Object[] { output1, output2 }, lOutIdx, lOutSize);
     *       System.out.println("lookback="+calc.getLookback());
     *       System.out.println("outBegIdx    = "+lOutIdx.value+ "    outNbElement = "+lOutSize.value);
     *       for (int i=0; i<lOutSize.value; i++) {
     *           System.out.println("output1["+i+"]="+output1[i]+"     "+"output2["+i+"]="+output2[i]);
     *       }
     * </pre>
     * 
     * 
     * @param startIndex to położenie początkowe danych wejściowych, które należy uwzględnic w obliczeniach funkcji.
     * @param endIndex to położenie ostatnich danych wejściowych, które należy uwzględnic w obliczeniach funkcji.
     * @param inputs tablica argumentow wejsciowych
     * @param outputs tablica argumentow wyjsciowych
     * @param outBegIdx indeks wyjsciowy jest zeracany przez metode i reprezentuje początkową pozycję danych wyjściowych zwracaną przez funkcję.
     * @param outNbElement  jest zwracany przez metode i reprezentuje ilośc danych wyjściowych zwróconych przez funkcję.
     * @throws IllegalArgumentException jeśli nie podamy danych wejsciowych lub dane nie zgadzają się z liczba wejśc w danej funkcji lub dane wejsciowe nie sa liczba.
     * @throws NoSuchMethodException 
     * @throws IllegalAccessException 
     * @throws InvocationTargetException
     */
    public void calculate(final int startIndex, final int endIndex,
            final Object[] inputs, Object[] outputs,
            MInteger outBegIdx, MInteger outNbElement)
                throws IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        //for (int i=startIndex; i<startIndex+endIndex; i++) {
        //    System.err.println("input["+i+"]="+((double[])(inputs[0]))[i]);
        //}
        
        // parse function name and optional arguments
        FuncInfo finfo = getMetaData().getFuncInfo();
        // set input parameters
        if (inputs==null  || inputs.length!=finfo.nbInput()) throw new IllegalArgumentException(); //TODO: message
        for (int i=0; i<inputs.length; i++) {
            InputParameterInfo ipinfo = calc.getInputParameterInfo(i);
            if (ipinfo.type()==InputParameterType.TA_Input_Price) {
                calc.setInputParamPrice(i, inputs[i]);
            } else if (ipinfo.type()==InputParameterType.TA_Input_Real) {
                calc.setInputParamReal(i, inputs[i]);
            } else if (ipinfo.type()==InputParameterType.TA_Input_Integer) {
                calc.setInputParamInteger(i, inputs[i]);
            } else {
                throw new IllegalArgumentException(); //TODO: message
            }
        }
        // set output parameters
        if (outputs==null || outputs.length!=finfo.nbOutput()) throw new IllegalArgumentException(); //TODO: message
        for (int i=0; i<outputs.length; i++) {
            OutputParameterInfo opinfo = calc.getOutputParameterInfo(i);
            if (opinfo.type()==OutputParameterType.TA_Output_Real) {
                calc.setOutputParamReal(i, outputs[i]);
            } else if (opinfo.type()==OutputParameterType.TA_Output_Integer) {
                calc.setOutputParamInteger(i, outputs[i]);
            } else {
                throw new IllegalArgumentException(); //TODO: message
            }
        }
        // call function
        calc.callFunc(startIndex, endIndex, outBegIdx, outNbElement); 
    }
    
}
