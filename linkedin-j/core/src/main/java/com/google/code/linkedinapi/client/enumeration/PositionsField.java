/**
 *
 */
package com.google.code.linkedinapi.client.enumeration;

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

	private String fieldName;

	PositionsField(String name) {
		this.fieldName = name;
	}

	/**
	 * @return the name of the field
	 */
	public String fieldName() {
		return this.fieldName;
	}

	public String toString() {
		return fieldName();
	}

	/**
	 * @param name
	 *            the name to check against
	 *
	 * @return true if this field has the specified name.
	 */
	public boolean isName(String name ) {
		return toString().equals( name );
	}
}
