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
 * @author niels (linux-java AT users.sourceforge.net)
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
     * Creates new {@link PropertyHolder}.
     * @author niels
     * @since 2.4.0
     * @param variableName
     */
    public static NumberPropertyHolder nprop(String variableName) {
        return new NumberPropertyHolder(variableName);
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
    
    /**
     * Create a validator which checks that the number is greater than the
     * given value.
     * @author niels
     * @since 2.4.10
     * @param value the limit.
     * @param variableName the name where the actualvalue should be hold.
     * @return the validator.
     */
    public static GreaterThan gt(long value, String variableName) {
        return new GreaterThan(Long.valueOf(value), variableName);
    }

    /**
     * Create a validator which checks that the number is greater than the
     * given value.
     * @author niels
     * @since 2.4.10
     * @param value the limit.
     * @param variableName the name where the actualvalue should be hold.
     * @return the validator.
     */
    public static GreaterThan gt(double value, String variableName) {
        return new GreaterThan(Double.valueOf(value), variableName);
    }

    /**
     * Create a validator which checks that the text match the regular expression.
     * @author niels
     * @since 2.4.10
     * @param regexp the regular expression.
     * @param variableName the name where the actualvalue should be hold.
     * @return the validator.
     */
    public static RegExpValidator re(String regexp, String variableName) {
        return new RegExpValidator(regexp, variableName);
    }

}
