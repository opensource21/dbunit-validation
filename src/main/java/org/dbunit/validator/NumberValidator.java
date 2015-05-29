package org.dbunit.validator;

public abstract class NumberValidator extends Number implements IValidator<Number> {

    
    /**
     *  Serial VersionNumber
     */
    private static final long serialVersionUID = -2979222569497382097L;
    
    private final Number expectedValue;
    
    private final String variableName;
    
    public NumberValidator(Number value) {
        this(value, null);
    }


    public NumberValidator(Number value, String variableName) {
        this.expectedValue = value;
        this.variableName = variableName;
    }
    

    /**
     * @return the expectedValue
     */
    protected Number getExpectedValue() {
        return expectedValue;
    }
    
    @Override
    public int intValue() {
        return expectedValue.intValue();
    }

    @Override
    public long longValue() {
        return expectedValue.longValue();
    }

    @Override
    public float floatValue() {
        return expectedValue.floatValue();
    }

    @Override
    public double doubleValue() {
        return expectedValue.doubleValue();
    }

    @Override
    public String toString() {
        return "GreaterThan " + expectedValue ;
    }

    @Override
    public String getVariableName() {
        return variableName;
    }


}
