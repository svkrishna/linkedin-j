/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

/**
 * @author nmukhtar
 *
 */
public enum NetworkUpdateType {

    /**
     * A connection has answered a question posed on LinkedIn Answers.
     */
    ANSWER_UPDATE("ANSW"),

    /**
     * An action that occurred in a partner application either by a connection or by an application itself. The contents of the update will be HTML entity encoded.
     */
    APPLICATION_UPDATE("APPS"),

    /**
     * These updates cover aspects of connections made on LinkedIn. They cover both the user connecting and the user's connections making connections (second degree connections).
     */
    CONNECTION_UPDATE("CONN"),

    /**
     * A connection has posted a job posting on LinkedIn
     */
    JOB_UPDATE("JOBS"),

    /**
     * A connection has joined a group.
     */
    GROUP_UPDATE("JGRP"),

    /**
     * A connection has updated their profile picture.
     */
    PICTURE_UPDATE("PICT"),

    /**
     * A connection was recommended
     */
    RECOMMENDATION_UPDATE("RECU"),

    /**
     * A connection has updated their profile. This does not include picture updates, which are covered under PICT type.
     */
    PROFILE_UPDATE("PRFU"),

    /**
     * A connection has asked a question on LinkedIn Answers.
     */
    QUESTION_UPDATE("QSTN"),

    /**
     * A connection has updated their status.
     */
    STATUS_UPDATE("STAT");

    /** Field description */
    private String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    NetworkUpdateType(String name) {
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
