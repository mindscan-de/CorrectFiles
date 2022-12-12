/**
 * 
 * MIT License
 *
 * Copyright (c) 2022 Maxim Gansert, Mindscan
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package de.mindscan.correctfiles.gf256;

/**
 * 
 */
public class GF256Math {

    private int primGenPoly = 0;

    private int[] logTable = new int[256];
    private int[] antilogTable = new int[256];

    /**
     * @param pimitiveGenerator
     */
    public GF256Math( int primitiveGenerator ) {
        this.primGenPoly = primitiveGenerator;
    }

    /**
     * Add, x and y according to the rules of GF 2**8 Math (exclusive or)
     * @param x value
     * @param y value
     * @return result of x and y added.
     */
    public int opAdd( int x, int y ) {
        return x ^ y;
    }

    /**
     * Subtract, x and y according to the rules of GF 2**8 Math (exclusive or)
     * @param x value
     * @param y value
     * @return result of x and y subtracted.
     */
    public int opSub( int x, int y ) {
        return x ^ y;
    }

    /**
     * Calculate the number of bits to fully represent the given value.
     * @param value
     * @return
     */
    public int opMsb( int value ) {
        int msb = 0;
        while ((value >> msb) > 0) {
            msb++;
        }
        return msb;
    }

    public int opMul( int x, int y ) {
        if (x == 0 || y == 0) {
            return 0;
        }

        return this.antilogTable[(this.logTable[x] + this.logTable[y]) % 255];
    }

    /**
     * Get the primitive Generator Polynomial set in constructor.
     * @return the primitive generator polynomial
     */
    public int getPrimitivePoly() {
        return this.primGenPoly;
    }

    /**
     * Multiplicaton, carryless, no nookup tables, and no reduction, according to primitive generator polynom
     * 
     * @param x 
     * @param y
     * @return
     */
    int mulClNolutNoreduce( int x, int y ) {
        int result = 0;
        int i = 0;
        while ((y >> i) > 0) {
            if ((y & (1 << i)) != 0) {
                result = this.opAdd( result, x << i );
            }
            i++;
        }
        return result;
    }

    int mulClNoLut( int x, int y ) {
        return reduce( mulClNolutNoreduce( x, y ) );
    }

    int reduce( int dividend ) {
        int dividendMsb = this.opMsb( dividend );
        int divisorMsb = this.opMsb( this.primGenPoly );

        if (dividend < divisorMsb) {
            return dividend;
        }

        for (int i = dividendMsb - divisorMsb; i >= 0; i--) {
            if ((dividend & (1 << (divisorMsb + i - 1))) > 0) {
                dividend = opSub( dividend, primGenPoly << i );
            }
        }

        return dividend;
    }

    /**
     * Initializes the mathematical operation of the galoisfield 2^8 arithmetics, 
     * such they can use pre-computed tables.
     */
    public void init() {
        init_gf_log_antilog_tables();
    }

    private void init_gf_log_antilog_tables() {
        this.logTable = new int[256];
        this.antilogTable = new int[256];

        int x = 1;
        for (int i = 0; i < 256; i++) {
            this.antilogTable[i] = x;
            this.logTable[x] = i;

            // update to next generated value
            // the Value 2 must actually be the primitive element used for the particular irreducible polynomial
            x = this.mulClNoLut( x, 2 );
        }
    }

}
