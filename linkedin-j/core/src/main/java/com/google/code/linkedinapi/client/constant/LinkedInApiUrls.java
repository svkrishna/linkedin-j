/**
 *
 */
package com.google.code.linkedinapi.client.constant;

import java.io.IOException;
import java.util.Properties;

/**
 * @author nmukhtar
 *
 */
public final class LinkedInApiUrls {

    /** Field description */
    public static final String API_URLS_FILE = "com/google/code/linkedinapi/client/constant/LinkedInApiUrls.properties";

    /** Field description */
    private static final Properties linkedInApiUrls = new Properties();

    /** Field description */
    public static final String LINKED_IN_PROFILE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.profile");

    /** Field description */
    public static final String LINKED_IN_POST_UPDATE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");

    /** Field description */
    public static final String LINKED_IN_POST_STATUS_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");

    /** Field description */
    public static final String LINKED_IN_POST_COMMENT_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");

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
    public static final String LINKED_IN_NETWORK_UPDATES_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");

    /** Field description */
    public static final String LINKED_IN_CONNECTIONS_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.connections");

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
}
