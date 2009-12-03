/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nmukhtar
 *
 */
public class LinkedInOAuthServiceFactory {

    /** Field description */
    private static LinkedInOAuthServiceFactory instance;

    /** Field description */
    private final Map<LinkedInApiConsumer, LinkedInOAuthService> servicesMap;

    /**
     * Constructs ...
     *
     */
    private LinkedInOAuthServiceFactory() {
        servicesMap = new ConcurrentHashMap<LinkedInApiConsumer, LinkedInOAuthService>();
    }

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
        LinkedInOAuthService service = servicesMap.get(apiConsumer);

        if (service == null) {
            service = new LinkedInOAuthServiceImpl(apiConsumer);
            servicesMap.put(apiConsumer, service);
        }

        return service;
    }
}
