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


/**
 * PriceHolder jest opdowiedzialny za trzymanie cen(notowań cenowych) które składują się w OHLCVI.
 * open, high, low, close, volume and open interest.
 * 
 * Wskaźniki matematyczne korzystające z cen na wejściu, biorą tylko podzbiór komponentu OHLCVI.
 * Mogłoby się wydawa, że ta klasa może by wykorzystana w tym celu. <i>Jednak nie jest ona przeznaczona do trzymania cen dla wskaźników.<i>
 * By to wytłumaczyc: Tablice zawarte w PriceHolder nie mogą byc inicjalizowane wartością null. Oraz wszystkie tablice muszą miec tą samą długośc.
 * 
 * @author Artur Ratajczak
 *
 */
public class PriceHolder {

    private double[] o;
    private double[] h;
    private double[] l;
    private double[] c;
    private double[] v;
    private double[] i;
    public final int length;
    
    /**
     * Konstruktor klasy. Przechowyje wszystkie dane punktów w tablicach.
     * @param o reprezentuje tzw. open data points.
     * @param h reprezentuje tzw. high data points.
     * @param l reprezentuje tzw. low data points.
     * @param c reprezentuje tzw. close data points.
     * @param v reprezentuje tzw. volume data points.
     * @param i reprezentuje tzw. open interest data points.
     * @throws NullPointerException jeśli jakaś tablica jest null.
     * @throws IllegalArgumentException jeśli tablice nie mają tej samej długości.
     */
    public PriceHolder(double[] o, double[] h, double[] l, double[] c, double[] v, double[] i) 
            throws NullPointerException, IllegalArgumentException {

        if (o==null) throw new NullPointerException(); // TODO: message
        if (h==null) throw new NullPointerException(); // TODO: message
        if (l==null) throw new NullPointerException(); // TODO: message
        if (c==null) throw new NullPointerException(); // TODO: message
        if (v==null) throw new NullPointerException(); // TODO: message
        if (i==null) throw new NullPointerException(); // TODO: message
        
        length = o.length;
        if (h.length != length) throw new IllegalArgumentException(); // TODO: message
        if (l.length != length) throw new IllegalArgumentException(); // TODO: message
        if (c.length != length) throw new IllegalArgumentException(); // TODO: message
        if (v.length != length) throw new IllegalArgumentException(); // TODO: message
        if (i.length != length) throw new IllegalArgumentException(); // TODO: message
        
        this.o = o;
        this.h = h;
        this.l = l;
        this.c = c;
        this.v = v;
        this.i = i;
    }
    
    /**
     * Metoda jest przestarzała. Użyj publicznej zmiennej "length".
     * @deprecated
     * @return length
     */
    public int getSize() {
        return length;
    }
    
    /**
     * Metoda przekształca OHLCVI w tablicę ze wszystkimi punktami.
     * @return Object[] zawierający wszystkie punktu OHLCVI.
     */
    public Object[] toArrays() {
        Object objs[] = new Object[6];
        int n = 0;
        objs[n++] = o;
        objs[n++] = h;
        objs[n++] = l;
        objs[n++] = c;
        objs[n++] = v;
        objs[n++] = i;
        return objs;
    }

    /**
     *  Metoda zwraca tablece open
     * @return double[] z punktami Open
     */
    public double[] getO() { return o; }
    
    /**
     * Metoda zwraca tablece high
     * @return double[] z punktami High
     */
    public double[] getH() { return h; }
    
    /**
     * Metoda zwraca tablece low
     * @return double[] z punktami Low
     */
    public double[] getL() { return l; }
    /**
     * Metoda zwraca tablece close
     * @return double[] z punktami Close
     */
    public double[] getC() { return c; }
    
    /**
     * Metoda zwraca tablece volume
     * @return double[] z punktami Volume
     */
    public double[] getV() { return v; }
    
    /**
     * Metoda zwraca tablece open interest
     * @return double[] z punktami Open Interest
     */
    public double[] getI() { return i; }
    
}

