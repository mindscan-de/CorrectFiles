package de.mindscan.correctfiles.gf256;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GF256MathTest {

    @Test
    public void testGF256Math_Ctor() throws Exception {
        // arrange

        // act
        GF256Math result = new GF256Math( 0x11d, 2 );

        // assert
        assertThat( result, not( nullValue() ) );
    }

    @Test
    public void testOpAdd_Add137And42_expect163() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opAdd( 137, 42 );

        // assert
        assertThat( result, equalTo( 163 ) );
    }

    @Test
    public void testMulClNolutNoreduce_137And42_expct5242() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.mulClNolutNoreduce( 137, 42 );

        // assert
        assertThat( result, equalTo( 5242 ) );
    }

    @Test
    public void testMulClNolutNoreduce_42And137_expct5242() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.mulClNolutNoreduce( 42, 137 );

        // assert
        assertThat( result, equalTo( 5242 ) );
    }

    @Test
    public void testOpMsb_0_0() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMsb( 0 );

        // assert
        assertThat( result, equalTo( 0 ) );
    }

    @Test
    public void testOpMsb_1_1() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMsb( 1 << 0 );

        // assert
        assertThat( result, equalTo( 1 ) );
    }

    @Test
    public void testOpMsb_2_2() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMsb( 1 << 1 );

        // assert
        assertThat( result, equalTo( 2 ) );
    }

    @Test
    public void testOpMsb_128_8() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMsb( 1 << 7 );

        // assert
        assertThat( result, equalTo( 8 ) );
    }

    @Test
    public void testOpMsb_256_9() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMsb( 1 << 8 );

        // assert
        assertThat( result, equalTo( 9 ) );
    }

    @Test
    public void testGetPrimitivePoly_ctor11d_expect11d() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.getPrimitivePoly();

        // assert
        assertThat( result, equalTo( 0x11d ) );
    }

    @Test
    public void testReduce_1_1() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.reduce( 1 );

        // assert
        assertThat( result, equalTo( 1 ) );
    }

    @Test
    public void testReduce_5242_195() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.reduce( 5242 );

        // assert
        assertThat( result, equalTo( 195 ) );
    }

    @Test
    public void testMulClNoLut_137And42_195() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.mulClNoLut( 137, 42 );

        // assert
        assertThat( result, equalTo( 195 ) );
    }

    @Test
    public void testOpMul_137And42_195() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( 137, 42 );

        // assert
        assertThat( result, equalTo( 195 ) );
    }

    @Test
    public void testOpMul_35And36_152() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( 35, 36 );

        // assert
        assertThat( result, equalTo( 152 ) );
    }

    @Test
    public void testOpMul_ZeroAndZero_Zero() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( 0, 0 );

        // assert
        assertThat( result, equalTo( 0 ) );
    }

    @Test
    public void testOpMul_ZeroAnd123_Zero() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( 0, 123 );

        // assert
        assertThat( result, equalTo( 0 ) );
    }

    @Test
    public void testOpMul_123AndZero_Zero() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( 123, 0 );

        // assert
        assertThat( result, equalTo( 0 ) );
    }

    @Test
    public void testOpDiv_dividendIsZero_expectZero() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opDiv( 0, 1 );

        // assert
        assertThat( result, equalTo( 0 ) );
    }

    @Test
    public void testOpDiv_divisorIsZero_throwsArithmeticException() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        // assert
        assertThrows( ArithmeticException.class, () -> {
            gf256m.opDiv( 1, 0 );
        } );
    }

    @Test
    public void testOpDiv_152DividedBy36_expect35() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opDiv( 152, 36 );

        // assert
        assertThat( result, equalTo( 35 ) );
    }

    @Test
    public void testOpDiv_152DividedBy35_expect36() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opDiv( 152, 35 );

        // assert
        assertThat( result, equalTo( 36 ) );
    }

    @Test
    public void testOpInverse_InverseOf152_expect11() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opInverse( 152 );

        // assert
        assertThat( result, equalTo( 11 ) );
    }

    @Test
    public void testOpInverse_InverseOf152MultipliedBy152_expectOne() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( gf256m.opInverse( 152 ), 152 );

        // assert
        assertThat( result, equalTo( 1 ) );
    }

    @Test
    public void testOpInverse_InverseOf211MultipliedBy211_expectOne() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        int result = gf256m.opMul( gf256m.opInverse( 211 ), 211 );

        // assert
        assertThat( result, equalTo( 1 ) );
    }

    @Test
    public void testOpInverse_calculateInverseOfZero_throwsArithmeticException() throws Exception {
        // arrange
        GF256Math gf256m = GF256MathFactory.createGF256Math();

        // act
        // assert
        assertThrows( ArithmeticException.class, () -> {
            gf256m.opInverse( 0 );
        } );
    }

}
