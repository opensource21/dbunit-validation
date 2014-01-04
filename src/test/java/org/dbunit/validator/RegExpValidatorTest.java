/*
 *
 * The DbUnit Database Testing Framework
 * Copyright (C)2002-2008, DbUnit.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.dbunit.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

/**
 * @author niels (linux-java AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 01.01.2014
 * @since 2.4.10
 *
 */
public class RegExpValidatorTest {

    private final RegExpValidator testee = new RegExpValidator(".*");

    /**
     * Test method for {@link org.dbunit.validator.RegExpValidator#RegExpValidator(java.lang.String)}.
     */
    @Test(expected=PatternSyntaxException.class)
    public void testRegExpValidator() {
        new RegExpValidator("A(B");
    }

    /**
     * Test method for {@link org.dbunit.validator.RegExpValidator#RegExpValidator(java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testRegExpValidatorNull() {
        new RegExpValidator(null);
    }

    /**
     * Test method for {@link org.dbunit.validator.RegExpValidator#isValid(java.lang.String)}.
     */
    @Test
    public void testIsValid() {
        assertTrue(testee.isValid("Not yet implemented"));
    }

    /**
     * Test method for {@link org.dbunit.validator.RegExpValidator#toString()}.
     */
    @Test
    public void testToString() {
        assertThat(testee.toString()).isEqualTo("RegExpValidator .*" );
    }

}
