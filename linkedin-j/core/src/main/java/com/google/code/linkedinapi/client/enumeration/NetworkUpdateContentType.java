/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum NetworkUpdateContentType implements FieldEnum {

    /**
     * Always linkedin-html
     */
    LINKED_IN_HTML("linkedin-html");

    /**
     * Field Description.
     */
	private static final Map<String, NetworkUpdateContentType> stringToEnum = new HashMap<String, NetworkUpdateContentType>();

	static { // Initialize map from constant name to enum constant
		for (NetworkUpdateContentType op : values()) {
			stringToEnum.put(op.toString(), op);
		}
	}
    
    /** Field description */
    private final String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    NetworkUpdateContentType(String name) {
        this.fieldName = name;
    }

    /**
     * @return the name of the field
     */
    public String fieldName() {
        return this.fieldName;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

	/**
	 *
	 * @return Returns NetworkUpdateType for string, or null if string is invalid
	 */
	public static NetworkUpdateContentType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
