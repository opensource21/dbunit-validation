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


/**
 * Utility class for compact code.
 * @author niels (<sf-user-name> AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 03.01.2014
 * @since 2.4.10
 *
 */
public class Validators {

    private Validators() {
        //Hide constructor.
    }

    /**
     * Create a validator which checks that the number is greater than the
     * given value.
     * @author niels
     * @since 2.4.10
     * @param value the limit.
     * @return the validator.
     */
    public static GreaterThan gt(long value) {
        return new GreaterThan(Long.valueOf(value));
    }

    /**
     * Create a validator which checks that the number is greater than the
     * given value.
     * @author niels
     * @since 2.4.10
     * @param value the limit.
     * @return the validator.
     */
    public static GreaterThan gt(double value) {
        return new GreaterThan(Double.valueOf(value));
    }

    /**
     * Create a validator which checks that the text match the regular expression.
     * @author niels
     * @since 2.4.10
     * @param regexp the regular expression.
     * @return the validator.
     */
    public static RegExpValidator re(String regexp) {
        return new RegExpValidator(regexp);
    }

}
