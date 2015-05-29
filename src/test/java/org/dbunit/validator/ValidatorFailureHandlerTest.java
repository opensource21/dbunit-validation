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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.dbunit.assertion.Difference;
import org.dbunit.assertion.FailureHandler;
import org.dbunit.dataset.ITable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author niels (linux-java AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 01.01.2014
 * @since 2.4.10
 *
 */
public class ValidatorFailureHandlerTest {

    @Mock
    private FailureHandler failureHandler;

    private ValidatorFailureHandler testee;

    /**
     * @author niels
     * @since 2.4.10
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testee = new ValidatorFailureHandler(failureHandler);        
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#handle(org.dbunit.assertion.Difference)}.
     */
    @Test
    public void testHandleNoValidator() {
        //Arrange
        final Difference diff = mock(Difference.class);
        when(diff.getExpectedValue()).thenReturn(Long.valueOf(1));
        //Act
        testee.handle(diff);
        //Assert
        verify(failureHandler).handle(diff);
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#handle(org.dbunit.assertion.Difference)}.
     */
    @Test
    public void testHandleValidatorInvalid() {
        //Arrange
        final Difference diff = mock(Difference.class);
        when(diff.getExpectedValue()).thenReturn(new GreaterThan(3L));
        when(diff.getActualValue()).thenReturn(2L);
        //Act
        testee.handle(diff);
        //Assert
        verify(failureHandler).handle(diff);
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#handle(org.dbunit.assertion.Difference)}.
     */
    @Test
    public void testHandleValidatorValid() {
        //Arrange
        final Difference diff = mock(Difference.class);
        when(diff.getExpectedValue()).thenReturn(new GreaterThan(3L));
        when(diff.getActualValue()).thenReturn(4L);
        //Act
        testee.handle(diff);
        //Assert
        verify(failureHandler, times(0)).handle(diff);
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#createFailure(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCreateFailureStringStringString() {
        //Arrange
        final String message = "Message";
        final String expected = "expected";
        final String actual = "actual";
        //Act
        testee.createFailure(message, expected, actual);
        //Assert
        verify(failureHandler).createFailure(message, expected, actual);
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#createFailure(java.lang.String)}.
     */
    @Test
    public void testCreateFailureString() {
      //Arrange
        final String message = "Message";
        //Act
        testee.createFailure(message);
        //Assert
        verify(failureHandler).createFailure(message);
    }

    /**
     * Test method for {@link org.dbunit.validator.ValidatorFailureHandler#getAdditionalInfo(org.dbunit.dataset.ITable, org.dbunit.dataset.ITable, int, java.lang.String)}.
     */
    @Test
    public void testGetAdditionalInfo() {
        //Arrange
        final ITable expectedTable = mock(ITable.class);
        final ITable actualTable = mock(ITable.class);
        final String columnName = "Col";

        //Act
        testee.getAdditionalInfo(expectedTable, actualTable, 0, columnName);

        //Assert
        verify(failureHandler).getAdditionalInfo(expectedTable, actualTable, 0, columnName);
    }
    
    /**
     * Test storage of variables.
     */
    @Test
    public void testStoreVariables() {
      //Arrange
        final Difference diff = mock(Difference.class);
        when(diff.getExpectedValue()).thenReturn(new GreaterThan(3L, "varName"));
        when(diff.getActualValue()).thenReturn(4L);
        //Act
        testee.handle(diff);
        //Assert
        verify(failureHandler, times(0)).handle(diff);
        assertThat(PropertyHolder.STORAGE).containsEntry("varName", 4L);
    }

}
