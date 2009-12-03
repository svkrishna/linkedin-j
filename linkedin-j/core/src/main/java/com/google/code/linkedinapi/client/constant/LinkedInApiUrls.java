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
    public static final String API_URLS_FILE = "com/google/code/linkedinapi/client/constant/LinkedInApiUrls.properties";

    private static final Properties linkedInApiUrls = new Properties();

    static {
    	try {
			linkedInApiUrls.load(LinkedInApiUrls.class.getClassLoader().getResourceAsStream(API_URLS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private LinkedInApiUrls() {}

	public static final String LINKED_IN_CONNECTIONS_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.connections");
	public static final String LINKED_IN_PROFILE_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.profile");
	public static final String LINKED_IN_NETWORK_UPDATES_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");
	public static final String LINKED_IN_POST_STATUS_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");
	public static final String LINKED_IN_POST_UPDATE_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");
	public static final String LINKED_IN_POST_COMMENT_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");
	public static final String LINKED_IN_OAUTH_REQUEST_TOKEN_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.requestToken");
	public static final String LINKED_IN_OAUTH_ACCESS_TOKEN_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.accessToken");
	public static final String LINKED_IN_OAUTH_AUTHORIZE_URL = linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.authorize");
}
