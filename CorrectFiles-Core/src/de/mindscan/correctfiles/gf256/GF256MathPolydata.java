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
public enum GF256MathPolydata {

    GF_256_0x11D( 0x11d, 2 ), //
    GF_256_0x12B( 0x12b, 2 ), //
    GF_256_0x12D( 0x12d, 2 ), //
    GF_256_0x14D( 0x14d, 2 ), //

    GF_256_0x15F( 0x15f, 2 ), //
    GF_256_0x163( 0x163, 2 ), //
    GF_256_0x165( 0x165, 2 ), //
    GF_256_0x169( 0x169, 2 ), //

    GF_256_0x171( 0x171, 2 ), //
    GF_256_0x187( 0x187, 2 ), //
    GF_256_0x18D( 0x18d, 2 ), //
    GF_256_0x1A9( 0x1A9, 2 ), //

    GF_256_0x1C3( 0x1c3, 2 ), //
    GF_256_0x1CF( 0x1cf, 2 ), //
    GF_256_0x1E7( 0x1e7, 2 ), //
    GF_256_0x1F5( 0x1f5, 2 ), //

    ;

    private int minPrimitiveElement;
    private int poly;

    GF256MathPolydata( int genPoly, int minPrimitiveElement ) {
        this.poly = genPoly;
        this.minPrimitiveElement = minPrimitiveElement;
    }

    /**
     * @return the poly
     */
    public int getPoly() {
        return poly;
    }

    /**
     * @return the minPrimitiveElement
     */
    public int getMinPrimitiveElement() {
        return minPrimitiveElement;
    }
}
