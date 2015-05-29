package org.dbunit.validator;

import java.util.Hashtable;

/**
 * Marker interface that it is a property-holder.
 * @author niels (<sf-user-name> AT users.sourceforge.net)
 * @author Last changed by: niels
 * @version 29.05.2015
 * @since 2.4.10
 *
 */
public interface PropertyHolder {

    final Hashtable<String, Object> STORAGE = new Hashtable<String, Object>();    
}