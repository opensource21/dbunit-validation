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

import java.util.regex.Pattern;

public class RegExpValidator implements IValidator<String> {

    private final Pattern pattern;
    
    private final String variableName;

    public RegExpValidator(String regExp) {
        this(regExp, null);
    }
    
    public RegExpValidator(String regExp, String variableName) {
        this.pattern = Pattern.compile(regExp);
        this.variableName = variableName;
    }

    @Override
    public boolean isValid(String currentValue) {
        return pattern.matcher(currentValue).matches();
    }

    @Override
    public String getVariableName() {
        return variableName;
    }

    @Override
    public String toString() {
        return "RegExpValidator " + pattern;
    }



}
