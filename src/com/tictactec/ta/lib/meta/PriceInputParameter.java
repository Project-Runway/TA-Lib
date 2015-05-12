package com.tictactec.ta.lib.meta;

import com.tictactec.ta.lib.meta.annotation.InputFlags;

/**
 * Według autora biblioteki TA-Lib klasa jest przestarzała i nie należy jej stosowac.
 * Rozszerze ona funkcjonalnośc klasy PriceHolder i wzbogaca ją o możliwośc odczytania flagi.
 * 
 * @deprecated
 * @author Artur Ratajczak
 *
 */
public class PriceInputParameter extends PriceHolder {

    private int flags;
    private int count;
    /**
     * Konstruktos klasy.
     * @param flags wartosc flagi
     * @param o tablica punktów open
     * @param h tablica puntków high
     * @param l tablica punktów low
     * @param c tablica punktów close
     * @param v tablica punktów volume
     * @param i tablica punktów open interest
     * @throws NullPointerException jeśli jakaś tablica ma wartośc null.
     * @throws IllegalArgumentException jeśli długości tablic są różne.
     */
    public PriceInputParameter(final int flags, double[] o, double[] h, double[] l, double[] c, double[] v, double[] i) 
            throws NullPointerException, IllegalArgumentException {
        super(o, h, l, c, v, i);
        initialize(flags);
    }
    /**
     * Konsktuktor kopiujący z obiektu PriceHolder
     * @param p Wcześniej utworzony obiekt PriceHolder.
     */
    public PriceInputParameter(final PriceHolder p) {
        super(p.getO(), p.getH(), p.getL(), p.getC(), p.getV(), p.getI());
        initialize(flags);
    }
    /**
     * Metoda ustawia flagę i zlicza je.
     * @param flags
     */
    private void initialize(final int flags) {
        this.flags = flags;
        count = 0;
        count += ((flags&InputFlags.TA_IN_PRICE_OPEN)!=0) ? 1 : 0;
        count += ((flags&InputFlags.TA_IN_PRICE_HIGH)!=0) ? 1 : 0;
        count += ((flags&InputFlags.TA_IN_PRICE_LOW)!=0) ? 1 : 0;
        count += ((flags&InputFlags.TA_IN_PRICE_CLOSE)!=0) ? 1 : 0;
        count += ((flags&InputFlags.TA_IN_PRICE_VOLUME)!=0) ? 1 : 0;
        count += ((flags&InputFlags.TA_IN_PRICE_OPENINTEREST)!=0) ? 1 : 0;
    }
    
    /**
    * Metoda zwraca flagę przekazaną poprzez konstruktor klasy.
    * @return numer flagi
    */
    public int getFlags() {
        return flags;
    }
    
    /**
     * Metoda zwraca ilośc tablic oczekiwanych do zwrocenia przez metodę toArrays().
     * Ilośc ta bazuje na podstawie przekazanej flagi przez konstruktor.
     * @return ilośc tablic oczekiwanych do zwrocenia przez metodę toArrays().
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Metoda zwraca tablicę z flagami.
     * @return object[] z odpowiadającymi flagami
     */
    public Object[] toArrays() {
        Object objs[] = new Object[count];
        int n = 0;
        
        if ((flags&InputFlags.TA_IN_PRICE_OPEN)!=0) {
            objs[n++] = getO();
        }
        if ((flags&InputFlags.TA_IN_PRICE_HIGH)!=0) {
            objs[n++] = getH();
        }
        if ((flags&InputFlags.TA_IN_PRICE_LOW)!=0) {
            objs[n++] = getL();
        }
        if ((flags&InputFlags.TA_IN_PRICE_CLOSE)!=0) {
            objs[n++] = getC();
        }
        if ((flags&InputFlags.TA_IN_PRICE_VOLUME)!=0) {
            objs[n++] = getV();
        }
        if ((flags&InputFlags.TA_IN_PRICE_OPENINTEREST)!=0) {
            objs[n++] = getI();
        }

        return objs;
    }

}
