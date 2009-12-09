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
public enum NetworkUpdateReturnType implements FieldEnum {

    /**
     * A connection has answered a question posed on LinkedIn Answers.
     */
    ANSWER_UPDATE("ANSW"),

    /**
     * Activity of a connection in an application
     */
    APPLICATION_CONNECTION_UPDATE("APPM"),
    
    /**
     * Applicaiton-to-member direct update. Messages where an applicaiton needs to message a user directly. Rarely used.
     */
    APPLICATION_TO_MEMBER_UPDATE("APPS"),

    /**
     * A connection  has added connections to their network. This update indicates who those new connections are.
     */
    CONNECTION_ADDED_CONNECTIONS("CONN"),

    /**
     * New connections of the member.
     */
    NEW_CONNECTIONS("NCON"),
    
    /**
     * A contact (not a connection) has just joined LinkedIn and is open to be invited to become a connection..
     */
    CONTACT_JOINED("CCEM"),
    
    /**
     * A connection has posted a job posting on LinkedIn
     */
    JOB_POSTED("JOBP"),

    /**
     * A connection has joined a group.
     */
    CONNECTION_JOINED_GROUP("JGRP"),

    /**
     * A connection has updated their profile picture.
     */
    CONNECTION_UPDATED_PICTURE("PICU"),

    /**
     * A connection was recommended
     */
    CONNECTION_RECOMMENDED("PREC"),

    /**
     * A connection has updated their profile. This does not include picture updates, which are covered under PICT type.
     */
    CONNECTION_UPDATED_PROFILE("PROF"),

    /**
     * A connection has asked a question on LinkedIn Answers.
     */
    QUESTION_UPDATE("QSTN"),

    /**
     * A connection has updated their status.
     */
    STATUS_UPDATE("STAT");
    
    /**
     * Field Description.
     */
	private static final Map<String, NetworkUpdateReturnType> stringToEnum = new HashMap<String, NetworkUpdateReturnType>();

	static { // Initialize map from constant name to enum constant
		for (NetworkUpdateReturnType op : values()) {
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
    NetworkUpdateReturnType(String name) {
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
	public static NetworkUpdateReturnType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
