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
public enum InviteConnectType implements FieldEnum {

    /**
     * Always friend
     */
    FRIEND("friend");
    
    /**
     * Field Description.
     */
	private static final Map<String, InviteConnectType> stringToEnum = new HashMap<String, InviteConnectType>();

	static { // Initialize map from constant name to enum constant
		for (InviteConnectType op : values()) {
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
    InviteConnectType(String name) {
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
	public static InviteConnectType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
