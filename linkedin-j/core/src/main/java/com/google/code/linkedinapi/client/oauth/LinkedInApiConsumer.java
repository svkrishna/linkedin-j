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
     * Method description
     *
     *
     * @return
     */
    public String getConsumerKey() {
        return getToken();
    }

    /**
     * Method description
     *
     *
     * @param token
     */
    public void setConsumerKey(String consumerKey) {
        setToken(consumerKey);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getConsumerSecret() {
        return getTokenSecret();
    }

    /**
     * Method description
     *
     *
     * @param tokenSecret
     */
    public void setConsumerSecret(String consumerSecret) {
        setTokenSecret(consumerSecret);
    }
}
