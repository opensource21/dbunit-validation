package org.dbunit.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link GreaterThan}.
 * @author niels (linux-java AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 01.01.2014
 * @since 2.4.10
 *
 */
public class GreaterThanTest {

   private final GreaterThan testee = new GreaterThan(Double.valueOf(2.1d));

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testIntValue() {
        assertThat(testee.intValue()).isEqualTo(2);
    }

    @Test
    public void testLongValue() {
        assertThat(testee.longValue()).isEqualTo(2L);
    }

    @Test
    public void testFloatValue() {
        assertThat(testee.floatValue()).isEqualTo(2.1f);
    }

    @Test
    public void testDoubleValue() {
        assertThat(testee.doubleValue()).isEqualTo(2.1d);
    }

    @Test
    public void testIsValid_double() {
        assertThat(testee.isValid(Double.valueOf(2.100000000000001d))).isTrue();
    }

    @Test
    public void testIsValid_float() {
        assertThat(testee.isValid(Float.valueOf(2.1000000000000001f))).isFalse();
        assertThat(testee.isValid(Float.valueOf(2.1001f))).isTrue();
    }

    @Test
    public void testIsValid_int() {
        assertThat(testee.isValid(3)).isTrue();
    }

    @Test
    public void testIsValid_long() {
        assertThat(testee.isValid(3L)).isTrue();
    }


    @Test
    public void testIsValid_doubleNegative() {
        assertThat(testee.isValid(Double.valueOf(2.1d))).isFalse();
    }

    @Test
    public void testIsValid_floatNegative() {
        assertThat(testee.isValid(Float.valueOf(2.1f))).isFalse();
    }

    @Test
    public void testIsValid_intNegative() {
        assertThat(testee.isValid(2)).isFalse();
    }

    @Test
    public void testIsValid_longNegative() {
        assertThat(testee.isValid(2L)).isFalse();
    }

    @Test
    public void testIsValid_null() {
        assertThat(testee.isValid(null)).isFalse();
        assertThat((new GreaterThan(null).isValid(1L))).isFalse();
    }

    @Test
    public void testToString() {
        assertThat(testee.toString()).isEqualTo("GreaterThan 2.1");
    }

}
