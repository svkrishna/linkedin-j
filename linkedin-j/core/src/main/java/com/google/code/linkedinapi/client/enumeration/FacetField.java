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
public enum FacetField implements FieldEnum {

    /**
     * A human readable name for the facet.
     */
	NAME("name"),

    /**
     * The machine processable value for the facet.
     */
	CODE("code"),

    /**
     * The facet bucket values for the facet.
     */
	BUCKETS("buckets"),

    /**
     * A human readable name for the facet bucket.
     */
	BUCKET_NAME("name"),

    /**
     * The machine processable value for the bucket.
     */
	BUCKET_CODE("code"),

    /**
     * The number of results inside the bucket.
     */
	BUCKET_COUNT("count"),

	/**
     * If this bucket's results are included in your search query.
     */
	BUCKET_SELECTED("selected");
    
    /**
     * Field Description.
     */
	private static final Map<String, FacetField> stringToEnum = new HashMap<String, FacetField>();

	static { // Initialize map from constant name to enum constant
		for (FacetField op : values()) {
			stringToEnum.put(op.fieldName(), op);
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
    FacetField(String name) {
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
	 * @return Returns ProfileType for string, or null if string is invalid
	 */
	public static FacetField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
