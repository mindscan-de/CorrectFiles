package de.mindscan.correctfiles.gf256;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class GF4096MathTest {

    @Test
    public void testGF4096Math_Mul() throws Exception {
        // arrange
        GF4096Math gf4096Math = new GF4096Math( 4179, 2 );
        gf4096Math.init();

        // act
        int result = gf4096Math.opMul( 211, 2111 );

        // assert
        assertThat( result, equalTo( 1946 ) );
    }

    @Test
    public void testGF4096Math_Div1() throws Exception {
        // arrange
        GF4096Math gf4096Math = new GF4096Math( 4179, 2 );
        gf4096Math.init();

        // act
        int result = gf4096Math.opDiv( 1946, 211 );

        // assert
        assertThat( result, equalTo( 2111 ) );
    }

    @Test
    public void testGF4096Math_Div2() throws Exception {
        // arrange
        GF4096Math gf4096Math = new GF4096Math( 4179, 2 );
        gf4096Math.init();

        // act
        int result = gf4096Math.opDiv( 1946, 2111 );

        // assert
        assertThat( result, equalTo( 211 ) );
    }

}
