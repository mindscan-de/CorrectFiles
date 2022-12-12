package de.mindscan.correctfiles.gf256;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

public class GF256MathTest {

    @Test
    public void testGF256Math_Ctor() throws Exception {
        // arrange

        // act
        GF256Math result = new GF256Math( 0x11d );

        // assert
        assertThat( result, not( nullValue() ) );
    }

    @Test
    public void testOpAdd_Add137And42_expect163() throws Exception {
        // arrange
        GF256Math gf256m = new GF256Math( 0x11d );

        // act
        int result = gf256m.opAdd( 137, 42 );

        // assert
        assertThat( result, equalTo( 163 ) );
    }

    @Test
    public void testMulClNolutNoreduce_137And42_expct5242() throws Exception {
        // arrange
        GF256Math gf256m = new GF256Math( 0x11d );

        // act
        int result = gf256m.mulClNolutNoreduce( 137, 42 );

        // assert
        assertThat( result, equalTo( 5242 ) );
    }

    @Test
    public void testMulClNolutNoreduce_42And137_expct5242() throws Exception {
        // arrange
        GF256Math gf256m = new GF256Math( 0x11d );

        // act
        int result = gf256m.mulClNolutNoreduce( 42, 137 );

        // assert
        assertThat( result, equalTo( 5242 ) );
    }

}
