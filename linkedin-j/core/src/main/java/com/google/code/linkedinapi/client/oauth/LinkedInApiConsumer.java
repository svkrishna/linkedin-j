/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 *
 *
 */
public class LinkedInApiConsumer extends LinkedInOAuthToken {

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiConsumer(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }
    
    /**
     * {@see LinkedInOAuthToken#getToken()}
     */
    public String getConsumerKey() {
        return getToken();
    }

    /**
     * {@see LinkedInOAuthToken#setToken()}
     */
    public void setConsumerKey(String consumerKey) {
        setToken(consumerKey);
    }

    /**
     * {@see LinkedInOAuthToken#getTokenSecret()}
     */
    public String getConsumerSecret() {
        return getTokenSecret();
    }

    /**
     * {@see LinkedInOAuthToken#setTokenSecret()}
     */
    public void setConsumerSecret(String consumerSecret) {
        setTokenSecret(consumerSecret);
    }
}
