/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

/**
 * @author nmukhtar
 *
 */
public enum EducationsField {

    /**
     * a unique identifier for this member's education entry.
     */
    ID("id"),

    /**
     * the name of the school, as indicated by the member
     */
    SCHOOL_NAME("school-name"),

    /**
     * the field of study at the school, as indicated by the member
     */
    FIELD_OF_STUDY("field-of-study"), DEGREE("degree"), ACTIVITIES("activities"),

    /**
     * a structured object a year field indicating when the education began
     */
    START_DATE("start-date"),

    /**
     * a structured object with a year field indicating when the education ended.
     */
    END_DATE("end-date");

    /** Field description */
    private String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    EducationsField(String name) {
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
