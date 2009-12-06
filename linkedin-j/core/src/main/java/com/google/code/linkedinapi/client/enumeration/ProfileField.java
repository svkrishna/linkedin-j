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
public enum ProfileField {

    /**
     * the member token for this member
     */
    ID("id"),

    /**
     * the member's first name
     */
    FIRST_NAME("first-name"),

    /**
     * the member's last name
     */
    LAST_NAME("last-name"),

    /**
     * the member's headline (often "Job Title at Company")
     */
    HEADLINE("headline"),

    /**
     * Generic name of the location of the LinkedIn member, (ex: "San Francisco Bay Area")
     */
    LOCATION_NAME("location/name"),

    /**
     * country code for the LinkedIn member
     */
    LOCATION_COUNTRY_CODE("location/country/code"),

    /**
     * the industry the LinkedIn member has indicated their profile belongs to
     */
    INDUSTRY("industry"),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    DISTANCE("distance"),

    /**
     * the degree distance of the fetched profile from the member who fetched the profile
     */
    RELATION_TO_VIEWER_DISTANCE("relation-to-viewer/distance"),

    /**
     * a total attribute will denote the number of connections that link the fetching member to the fetched. Contains brief connection/person objects indicating the connecting first degree members.
     */
    RELATION_TO_VIEWER_CONNECTIONS("relation-to-viewer/connections"),

    /**
     * the member's current status, if set
     */
    CURRENT_STATUS("current-status"),

    /**
     * the timestamp, in milliseconds, when the member's status was last set
     */
    CURRENT_STATUS_TIMESTAMP("current-status-timestamp"),

    /**
     * an empty collection, indicating the # of connections the member has with a total attribute.
     */
    CONNECTIONS("connections"),

    /**
     * A long-form text area where the member describes their professional profile
     */
    SUMMARY("summary"),

    /**
     * A short-form text area where the member enumerates their specialties.
     */
    SPECIALTIES("specialties"),

    /**
     * A short-form text area describing how the member approaches proposals
     */
    PROPOSAL_COMMENTS("proposal-comments"),

    /**
     * A short-form text area enumerating the Associations a member has
     */
    ASSOCIATIONS("associations"),

    /**
     * A short-form text area describing what Honors the member may have
     */
    HONORS("honors"),

    /**
     * A collection of positions a member has had, the total indicated by a total attribute
     */
    POSITIONS("positions"),

    /**
     * A collection of education institutions a member has attended, the total indicated by a total attribute
     */
    EDUCATIONS("educations"),

    /**
     * A collection of URLs the member has chosen to share on their LinkedIn profile
     */
    MEMBER_URL_RESOURCES("member-url-resources"),

    /**
     * The fully-qualified URL being shared
     */
    MEMBER_URL_URL("member-url/url"),

    /**
     * The label given to the URL by the member
     */
    MEMBER_URL_NAME("member-url/name"),

    /**
     * the URL to the member's authenticated profile on LinkedIn (requires a login to be viewed, unlike public profiles)
     */
    SITE_STANDARD_PROFILE_REQUEST_URL("site-standard-profile-request/url"),

    /**
     * The Public Profile URL for the member on the LinkedIn.com website. Returned only for Public Profile requests.
     */
    SITE_PUBLIC_PROFILE_REQUEST_URL("site-public-profile-request/url"),

    /**
     * An URL representing the resource you would request for programmatic access to the member's public profile
     */
    API_PUBLIC_PROFILE_REQUEST_URL("api-public-profile-request/url"),

    /**
     * An URL representing the resource you would request for programmatic access to the member's profile
     */
    API_STANDARD_PROFILE_REQUEST_URL("api-standard-profile-request/url"),

    /**
     * A collection of fields that can be re-used as HTTP headers to request an out of network profile programmatically
     */
    API_STANDARD_PROFILE_REQUEST_HEADERS("api-standard-profile-request/headers"),

    /**
     * A URL to the profile picture, if the member has associated one with their profile and it is visible to the requestor
     */
    PICTURE_URL("picture-url");
    
    /**
     * Field Description.
     */
	private static final Map<String, ProfileField> stringToEnum = new HashMap<String, ProfileField>();

	static { // Initialize map from constant name to enum constant
		for (ProfileField op : values()) {
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
    ProfileField(String name) {
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
	 * @return Returns ProfileField for string, or null if string is invalid
	 */
	public static ProfileField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
