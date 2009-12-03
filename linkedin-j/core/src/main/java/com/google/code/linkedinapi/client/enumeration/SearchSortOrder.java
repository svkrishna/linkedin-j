/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

/**
 * @author nmukhtar
 *
 */
public enum SearchSortOrder {

    /**
     * Orders the returns by number of connections each of the search returns has.
     */
    NUMBER_OF_CONNECTIONS("ctx"),

    /**
     * Orders the returns by number of ensorsers each of the search returns has.
     */
    NUMBER_OF_ENDORSERS("endorsers"),

    /**
     * Orders the returns based on the ascending degree of separation within a member's network, with first degree connections first.
     */
    DISTANCE("distance"),

    /**
     * Orders the returns based on relevance for the keywords provided.
     */
    RELEVANCE("relevance");

    /** Field description */
    private String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    SearchSortOrder(String name) {
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
