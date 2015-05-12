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

import java.lang.annotation.IncompleteAnnotationException;

import com.tictactec.ta.lib.RetCode;
import com.tictactec.ta.lib.meta.annotation.FuncInfo;
import com.tictactec.ta.lib.meta.annotation.InputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OptInputParameterInfo;
import com.tictactec.ta.lib.meta.annotation.OutputParameterInfo;

/**
 * Ta klasa jest przeznaczona dla programistów, którzy chcą przetłumaczyc kod aplikacji z "C" oraz korzystali z <i>ta_abstract.h</i>.
 * 
 * W aplikacjach Javy mamy do wykożystanie wiele klas zgłaszających wyjątki w "C" natomiast musimy posługiwac się kodami statusów by ustalic jakiś błąd.
 * Klasa ta tworzy dodatkową warstwę opakowującą CoreMetaData i zamiast zgłaszania możliwych wystąpień wyjątków zgłasza ona kod statusu jak w języku "C".
 * 
 * Klasa ta nie została przetestowana przez autora biblioteki. Używasz jej na własne ryzyko.
 * 
 * Klasa ta w całości nie implementuje metod z <i>ta_abstract.h</i>
 * 
 * @author Artur Ratajczak
 *
 */
public class CoreMetaDataCompatibility extends CoreMetaData {
	/**
	 * Metoda zwraca uchwyt do funkcji
	 * @param name Nazwa funkcji
	 * @param retHandle Obiekt CoreMetaData do którego zostanie utworzony uchwyt.
	 * @return Kod statusu (RetCode)
	 */
    static RetCode taGetFuncHandle(final String name, CoreMetaData retHandle) {
        try {
            retHandle = getFuncHandle(name);
            return RetCode.Success;
        } catch (NoSuchMethodException e) {
            return RetCode.BadParam;
        }
    }
    
    /**
     * Metoda zwraca informacje na temat funkcji.
     * @param retFuncInfo Intefejs do którego zostaną zapisane informacje o funkcjach.
     * @return Kod statusu (RetCode)
     */
    RetCode taGetFuncInfo(FuncInfo retFuncInfo) {
        try {
            retFuncInfo = super.getFuncInfo();
            return RetCode.Success;
        } catch (IncompleteAnnotationException e) {
            return RetCode.InternalError;
        }
    }
    
    /**
     * Metoda zwraca informacje na temat n-tego parametru wejściowego.
     * @param paramIndex Indeks parametru n-tego
     * @param retInputParameterInfo Interfejs do którego zostanie zapisana informacja o n-tym parametrze.
     * @return Kod statusu (RetCode)
     */
    RetCode taGetInputParameterInfo(final int paramIndex, InputParameterInfo retInputParameterInfo) {
        try {
            retInputParameterInfo = super.getInputParameterInfo(paramIndex);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda zwraca informacje na temat n-tego opcjonalnego parametru wejściowego.
     * @param paramIndex Indeks parametru n-tego
     * @param retOptInputParameterInfo Interfejs do którego zostanie zapisana informacja o n-tym parametrze.
     * @return KodStatusu (RetCode)
     */
    RetCode taGetInputParameterInfo(final int paramIndex, OptInputParameterInfo retOptInputParameterInfo) {
        try {
            retOptInputParameterInfo = super.getOptInputParameterInfo(paramIndex);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda zwraca informacje na temat n-tego parametru wyjściowego.
     * @param paramIndex Indeks parametru n-tego.
     * @param retOutputParameterInfo Interfejs do którego zostanie zapisana informacja o n-tym parametrze.
     * @return
     */
    RetCode taGetOutputParameterInfo(final int paramIndex, OutputParameterInfo retOutputParameterInfo) {
        try {
            retOutputParameterInfo = super.getOutputParameterInfo(paramIndex);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda ustawia n-ty parametr wejściowy typu Integer.
     * @param paramIndex Indeks n-tego parametru.
     * @param value tablica z wartościami typu Integer.
     * @return Kod statusu.
     */
    RetCode taSetInputParamIntegerPtr(final int paramIndex, final int[] value ) {
        try {
            super.setInputParamInteger(paramIndex, value);
            return RetCode.Success;
        } catch (NullPointerException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda ustawia n-ty parametr wejściowy typu Real.
     * @param paramIndex Indeks n-tego parametru.
     * @param value tablica z wartościami typu Real.
     * @return Kod statusu.
     */
    RetCode taSetInputParamRealPtr(final int paramIndex, final double[] value ) {
        try {
            super.setInputParamReal(paramIndex, value);
            return RetCode.Success;
        } catch (NullPointerException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda ustawia n-ty parametr typu Price.
     * @param paramIndex Indeks n-tego parametru.
     * @param open reprezentacja Open Prices w postaci double[]
     * @param high reprezentacja High Prices w postaci double[]
     * @param low reprezentacja Low Prices w postaci double[]
     * @param close reprezentacja Close Prices w postaci double[]
     * @param volume reprezentacje volume w postaci double[]
     * @param openInterest reprezentacja OpenInterest w postaci double[]
     * @return Kod statusu.
     */
    RetCode taSetInputParamPricePtr(final int paramIndex,
            final double[] open,
            final double[] high,
            final double[] low,
            final double[] close,
            final double[] volume,
            final double[] openInterest) {
        try {
            super.setInputParamPrice(paramIndex, open, high, low, close, volume, openInterest);
            return RetCode.Success;
        } catch (NullPointerException e) {
            return RetCode.BadParam;
        }
    }
    
    /**
     * Metoda ustawia n-ty opcjonalny parametr typu Integer.
     * @param paramIndex Indeks parametru n-tego
     * @param optInValue Nowa wartośc n-tego parametru.
     * @return Kod Statusu.
     */
    RetCode taSetOptInputParamInteger(final int paramIndex, final int optInValue) {
        try {
            setOptInputParamInteger(paramIndex, optInValue);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }
        
    /**
     * Metoda ustawia n-ty opcjonalny parametr typu Real.
     * @param paramIndex Indeks parametru n-tego.
     * @param optInValue Nowa wartośc n-tego parametru.
     * @return Kod statusu.
     */
    RetCode taSetOptInputParamReal(final int paramIndex, final double optInValue) {
        try {
            setOptInputParamReal(paramIndex, optInValue);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }
    
    /**
     * Metoda ustawia n-ty parametr wyjściowy typu Integer.
     * @param paramIndex Indeks n-tego parametru.
     * @param outArray Tablica wartości int[]
     * @return Kod statusu.
     */
    RetCode taSetOutputParamIntegerPtr(final int paramIndex, int[] outArray) {
        if (outArray == null) return RetCode.BadParam;
        try {
            setOutputParamInteger(paramIndex, outArray);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }

    /**
     * Metoda ustawia n-ty parametr wyjściowy typu Real.
     * @param paramIndex Indekst n-tego parametru.
     * @param outArray Tablica wartości double[]
     * @return Kod statusu.
     */
    RetCode taSetOutputParamRealPtr(final int paramIndex, double[] outArray) {
        if (outArray == null) return RetCode.BadParam;
        try {
            setOutputParamReal(paramIndex, outArray);
            return RetCode.Success;
        } catch (IllegalArgumentException e) {
            return RetCode.BadParam;
        }
    }


}
