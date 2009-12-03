/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 *
 *
 */
public class LinkedInRequestToken extends LinkedInOAuthToken {

    /** Field description */
    private String authorizationUrl;

    /**
     * Constructs ...
     *
     *
     * @param token
     * @param tokenSecret
     */
    public LinkedInRequestToken(String token, String tokenSecret) {
        super(token, tokenSecret);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    /**
     * Method description
     *
     *
     * @param authorizationUrl
     */
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }
}
