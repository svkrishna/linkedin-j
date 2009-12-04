/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

/**
 * @author nmukhtar
 *
 */
public enum HttpMethod {

    /**
     * HTTP Get Method
     */
    GET("GET"),

    /**
     * HTTP Put Method
     */
    PUT("PUT"),

    /**
     * HTTP Post Method
     */
    POST("POST"),

    /**
     * HTTP Delete Method
     */
    DELETE("DELETE");

    /** Field description */
    private String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    HttpMethod(String name) {
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
    public String toString() {
        return fieldName();
    }

    /**
     * @param name
     *            the name to check against
     *
     * @return true if this field has the specified name.
     */
    public boolean isName(String name) {
        return toString().equals(name);
    }
}
