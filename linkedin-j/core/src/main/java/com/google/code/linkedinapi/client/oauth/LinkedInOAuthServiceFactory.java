/**
 *
 */
package com.google.code.linkedinapi.client.oauth;


/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInOAuthServiceFactory {

    /** Field description */
    private static LinkedInOAuthServiceFactory instance;

    /**
     * Constructs ...
     *
     */
    private LinkedInOAuthServiceFactory() {}

    /**
     * Method description
     *
     *
     * @return
     */
    public static synchronized LinkedInOAuthServiceFactory getInstance() {
        if (instance == null) {
            instance = new LinkedInOAuthServiceFactory();
        }

        return instance;
    }

    /**
     * Method description
     *
     *
     * @param consumerKey
     * @param consumerSecret
     *
     * @return
     */
    public LinkedInOAuthService createLinkedInOAuthService(String consumerKey, String consumerSecret) {
        return createLinkedInOAuthService(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Method description
     *
     *
     * @param apiConsumer
     *
     * @return
     */
    public LinkedInOAuthService createLinkedInOAuthService(LinkedInApiConsumer apiConsumer) {
        return new LinkedInOAuthServiceImpl(apiConsumer);
    }
}
