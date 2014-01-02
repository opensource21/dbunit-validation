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

import org.dbunit.assertion.DefaultFailureHandler;
import org.dbunit.assertion.Difference;
import org.dbunit.assertion.FailureHandler;
import org.dbunit.dataset.ITable;

/**
 * @author niels
 *
 */
public class ValidatorFailureHandler implements FailureHandler {


    private final FailureHandler delegateFailureHandler;


    public ValidatorFailureHandler() {
        this(new DefaultFailureHandler());
    }


    /**
     * @param delegateFailureHandler
     */
    public ValidatorFailureHandler(FailureHandler delegateFailureHandler) {
        super();
        this.delegateFailureHandler = delegateFailureHandler;
    }

    /* (non-Javadoc)
     * @see org.dbunit.assertion.DifferenceListener#handle(org.dbunit.assertion.Difference)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void handle(Difference diff) {
        //Check if Validation needed
        if (diff.getExpectedValue() instanceof IValidator<?>) {
            final IValidator validator = (IValidator) diff.getExpectedValue();
            if (validator.isValid(diff.getActualValue())) {
                return;
            };
        }
        delegateFailureHandler.handle(diff);
    }

    /* (non-Javadoc)
     * @see org.dbunit.assertion.FailureFactory#createFailure(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Error createFailure(String message, String expected, String actual) {
        return delegateFailureHandler.createFailure(message, expected, actual);
    }

    /* (non-Javadoc)
     * @see org.dbunit.assertion.FailureFactory#createFailure(java.lang.String)
     */
    @Override
    public Error createFailure(String message) {
        return delegateFailureHandler.createFailure(message);
    }

    /* (non-Javadoc)
     * @see org.dbunit.assertion.FailureHandler#getAdditionalInfo(org.dbunit.dataset.ITable, org.dbunit.dataset.ITable, int, java.lang.String)
     */
    @Override
    public String getAdditionalInfo(ITable expectedTable, ITable actualTable,
            int row, String columnName) {
        return delegateFailureHandler.getAdditionalInfo(expectedTable, actualTable, row, columnName);
    }

}
