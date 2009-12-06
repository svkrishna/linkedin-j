/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public enum PositionsField {

    /**
     * a unique identifier for this member's position.
     */
    ID("id"),

    /**
     * the job title held at the position, as indicated by the member
     */
    TITLE("title"),

    /**
     * a summary of the member's position
     */
    SUMMARY("summary"),

    /**
     * a structured object with month and year fields indicating when the position began
     */
    START_DATE("start-date"),

    /**
     * a structured object with month and year fields indicating when the position ended.
     */
    END_DATE("end-date"),

    /**
     * a "true" or "false" value, depending on whether it is marked current
     */
    IS_CURRENT("is-current"),

    /**
     * The name of the company the member works for
     */
    COMPANY_BANE("company/name");
    
    /**
     * Field Description.
     */
	private static final Map<String, PositionsField> stringToEnum = new HashMap<String, PositionsField>();

	static { // Initialize map from constant name to enum constant
		for (PositionsField op : values()) {
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
    PositionsField(String name) {
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
	 * @return Returns PositionsField for string, or null if string is invalid
	 */
	public static PositionsField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
