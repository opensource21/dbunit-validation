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
 * Holder of a propertyname.
 * @author niels (<sf-user-name> AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 29.05.2015
 * @since 2.4.10
 *
 */
public class NumberPropertyHolder extends NumberValidator implements PropertyHolder {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 265538172935110114L;
    
    /**
     * Store a number in the variable-name.
     * @param variableName
     */
    public NumberPropertyHolder(String variableName) {
        super(0, variableName);
    }

   
    @Override
    public boolean isValid(Number currentValue) {
        //TODO this is a hack.
        throw new RuntimeException("Don't call this method directly");
    }
    
    

}
