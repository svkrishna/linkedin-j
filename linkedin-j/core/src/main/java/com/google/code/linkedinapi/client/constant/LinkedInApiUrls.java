/**
 *
 */
package com.google.code.linkedinapi.client.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

/**
 * @author nmukhtar
 *
 */
public final class LinkedInApiUrls {

    /** Field description */
    public static final String API_URLS_FILE = "com/google/code/linkedinapi/client/constant/LinkedInApiUrls.properties";

    /** Field description */
    private static final char API_URLS_PLACEHOLDER_START = '{';

    /** Field description */
    private static final char API_URLS_PLACEHOLDER_END = '}';

    /** Field description */
    private static final Properties linkedInApiUrls = new Properties();

    /** Field description */
    public static final String GET_PROFILE_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileForCurrentUser");

    /** Field description */
    public static final String GET_PROFILE_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileById");

    /** Field description */
    public static final String GET_PROFILE_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileByUrl");

    /** Field description */
    public static final String SEARCH_PEOPLE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchPeople");

    /** Field description */
    public static final String POST_UPDATE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");

    /** Field description */
    public static final String POST_STATUS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");

    /** Field description */
    public static final String POST_COMMENT =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");

    /** Field description */
    public static final String SEND_MESSAGE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.sendMessage");


    /** Field description */
    public static final String LINKED_IN_OAUTH_REQUEST_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.requestToken");

    /** Field description */
    public static final String LINKED_IN_OAUTH_AUTHORIZE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.authorize");

    /** Field description */
    public static final String LINKED_IN_OAUTH_ACCESS_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.accessToken");

    /** Field description */
    public static final String NETWORK_UPDATES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");

    /** Field description */
    public static final String GET_CONNECTIONS_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsForCurrentUser");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsById");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_EMAIL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByEmail");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByUrl");

    static {
        try {
            linkedInApiUrls.load(LinkedInApiUrls.class.getClassLoader().getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs ...
     *
     */
    private LinkedInApiUrls() {}

    /**
     * Method description
     *
     *
     * @param urlFormat
     * @param namedParameters
     *
     * @return
     */
    public static String buildUrl(String urlFormat, Map<String, String> namedParameters) {
    	StringBuilder urlBuilder = new StringBuilder();
    	StringBuilder placeHolderBuilder = new StringBuilder();
    	boolean placeHolderFlag = false;
    	for (int i = 0; i < urlFormat.length(); i++) {
    		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
    			placeHolderBuilder = new StringBuilder();
    			placeHolderFlag = true;
    		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
    			String placeHolder = placeHolderBuilder.toString();
    			if (namedParameters.containsKey(placeHolder)) {
    				// bind the parameter to the placeholder
    				urlBuilder.append(encodeUrl(namedParameters.get(placeHolder), ApplicationConstants.CONTENT_ENCODING));
    			} else {
    				// we did not find a binding for the placeholder.
    				// append it as it is.
    				urlBuilder.append(API_URLS_PLACEHOLDER_START);
    				urlBuilder.append(placeHolder);
    				urlBuilder.append(API_URLS_PLACEHOLDER_END);
    			}
    			placeHolderFlag = false;
    		} else if (placeHolderFlag) {
    			placeHolderBuilder.append(urlFormat.charAt(i));
    		} else {
    			urlBuilder.append(urlFormat.charAt(i));
    		}
    	}

    	return urlBuilder.toString();
    }

    /**
     * Method description
     *
     *
     * @param original
     * @param encoding
     *
     * @return
     */
    private static String encodeUrl(String original, String encoding) {
    	try {
			return URLEncoder.encode(original, encoding);
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
    }
}
