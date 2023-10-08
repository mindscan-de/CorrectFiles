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
 *  x**8 + x**4 + x**3 + x**2 + 1  == 1 0001 1101 == 285 | 2
 *  x**8 + x**5 + x**3 + x**1 + 1  == 1 0010 1011 == 299 | 2
 */
public class GF256MathFactory {

    public static GF256Math createGF256Math() {
        return createGF256Math( GF256MathPolydata.GF_256_0x11D );
    }

    public static GF256Math createGF256Math( GF256MathPolydata polydata ) {
        GF256Math gf256Math = new GF256Math( polydata.getPoly(), polydata.getMinPrimitiveElement() );
        // initializes the log and anti-log tables.
        gf256Math.init();

        return gf256Math;
    }

}
