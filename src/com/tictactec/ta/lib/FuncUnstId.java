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
 *  MF       Mario Fortier
 *
 * Change history:
 *
 *  MMDDYY BY     Description
 *  -------------------------------------------------------------------
 *  121005 MF     First Version
 */

package com.tictactec.ta.lib;
/**
 * Typ wyliczeniowy zawierający numery ID funkcji.
 * @author Artur Ratajczak
 *
 */
public enum FuncUnstId {
	
	/**
	 * ADX - Average Directional Movement Index
	 */
    Adx,
    /**
     * ADXR - Average Directional Movement Index Rating
     */
    Adxr,
    /**
     * ATR - Average True Range
     */
    Atr,
    /**
     * CMO - Chande Momentum Oscillator
     */
    Cmo,
    /**
     * DX - Directional Movement Index
     */
    Dx,
    /**
     * EMA - Exponential Moving Average
     */
    Ema,
    /**
     * HT_DCPERIOD - Hilbert Transform - Dominant Cycle Period
     */
    HtDcPeriod,
    /**
     * HT_DCPHASE - Hilbert Transform - Dominant Cycle Phase
     */
    HtDcPhase,
    /**
     * HT_PHASOR - Hilbert Transform - Phasor Components
     */
    HtPhasor,
    /**
     * HT_SINE - Hilbert Transform - SineWave
     */
    HtSine,
    /**
     * HT_TRENDLINE - Hilbert Transform - Instantaneous Trendline
     */
    HtTrendline,
    /**
     * HT_TRENDMODE - Hilbert Transform - Trend vs Cycle Mode
     */
    HtTrendMode,
    /**
     * KAMA - Kaufman Adaptive Moving Average
     */
    Kama,
    /**
     * MAMA - MESA Adaptive Moving Average
     */
    Mama,
    /**
     * MFI - Money Flow Index
     */
    Mfi,
    /**
     * MINUSDI - Minus Directional Indicator
     */
    MinusDI,
    /**
     * MINUSDM - Minus Directional Movement
     */
    MinusDM,
    /**
     * NATR - Normalized Average True Range
     */
    Natr,
    /**
     * PLUSDI - Plus Directional Indicator
     */
    PlusDI,
    /**
     * PLUSDM - Plus Directional Movement
     */
    PlusDM,
    /**
     * RSI - Relative Strength Index
     */
    Rsi,
    /**
     * STOCHRSI - Stochastic Relative Strength Index
     */
    StochRsi,
    /**
     * T3 - Triple Exponential Moving Average (T3)
     */
    T3,
    All,
    None;
};
