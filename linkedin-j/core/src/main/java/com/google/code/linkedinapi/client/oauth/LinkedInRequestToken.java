/**
 * 
 */
package com.google.code.linkedinapi.client.oauth;

public class LinkedInRequestToken extends LinkedInOAuthToken {
	private String authorizationUrl;

	public LinkedInRequestToken(String token, String tokenSecret) {
		super(token, tokenSecret);
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}
}