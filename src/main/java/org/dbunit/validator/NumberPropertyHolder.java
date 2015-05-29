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
 * Holder of number which is access via a propertyname.
 * @author niels (<sf-user-name> AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 29.05.2015
 * @since 2.4.10
 *
 */
public class NumberPropertyHolder extends Number implements PropertyHolder {
    
    /**
     * 
     */
    private static final long serialVersionUID = 265538172935110114L;
    
    private final  String variableName;
    
    
    /**
     * Store a number in the variable-name.
     * @param variableName
     */
    public NumberPropertyHolder(String variableName) {
        this.variableName = variableName;
    }

    /**
     * @return the expectedValue
     */
    private Number getExpectedValue() {
        final Number expectedNumber = (Number) STORAGE.get(variableName);
        if (expectedNumber == null) {
            return Long.MAX_VALUE;
        }
        
        return expectedNumber;
    }


    /**
     * @return
     * @see java.lang.Number#intValue()
     */
    public int intValue() {
        return getExpectedValue().intValue();
    }

    /**
     * @return
     * @see java.lang.Number#longValue()
     */
    public long longValue() {
        return getExpectedValue().longValue();
    }

    /**
     * @return
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return getExpectedValue().hashCode();
    }

    /**
     * @return
     * @see java.lang.Number#floatValue()
     */
    public float floatValue() {
        return getExpectedValue().floatValue();
    }

    /**
     * @return
     * @see java.lang.Number#doubleValue()
     */
    public double doubleValue() {
        return getExpectedValue().doubleValue();
    }

    /**
     * @return
     * @see java.lang.Number#byteValue()
     */
    public byte byteValue() {
        return getExpectedValue().byteValue();
    }

    /**
     * @return
     * @see java.lang.Number#shortValue()
     */
    public short shortValue() {
        return getExpectedValue().shortValue();
    }

    /**
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (STORAGE.get(variableName) == null) {
            return obj == null;
        }
        return getExpectedValue().equals(obj);
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        if (STORAGE.get(variableName) == null) {
            return "No value for " + variableName;
        }
        return getExpectedValue().toString();
    }

    
    
    

}
