package org.dbunit.validator;

/**
 * Marker interface that it is a property-holder.
 * @author niels (<sf-user-name> AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 29.05.2015
 * @since 2.4.10
 *
 */
public interface PropertyHolder {

    /**
     * Return the name of a variable.
     * @author niels
     * @since 2.4.0
     * @return the name of a variable or null.
     */
    public String getVariableName(); 
    
}