/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.code.linkedinapi.client.impl.AsyncLinkedInApiJaxbClient;
import com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;

/**
 * @author nmukhtar
 *
 */
public class LinkedInApiClientFactory {

    /** Field description */
    private static final Map<LinkedInApiConsumer, LinkedInApiClientFactory> factoriesMap =
        new ConcurrentHashMap<LinkedInApiConsumer, LinkedInApiClientFactory>();

    /** Field description */
    private LinkedInApiConsumer apiConsumer;

    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    private LinkedInApiClientFactory(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
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
    public static LinkedInApiClientFactory newInstance(String consumerKey, String consumerSecret) {
        return newInstance(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * Method description
     *
     *
     * @param apiConsumer
     *
     * @return
     */
    public static synchronized LinkedInApiClientFactory newInstance(LinkedInApiConsumer apiConsumer) {
        LinkedInApiClientFactory factory = factoriesMap.get(apiConsumer);

        if (factory == null) {
            factory = new LinkedInApiClientFactory(apiConsumer);
            factoriesMap.put(apiConsumer, factory);
        }

        return factory;
    }

    /**
     * Method description
     *
     *
     * @param accessToken
     *
     * @return
     */
    public LinkedInApiClient createJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getToken(),
                                             apiConsumer.getTokenSecret());

        client.setAccessToken(accessToken);

        return client;
    }

    /**
     * Method description
     *
     *
     * @param accessToken
     *
     * @return
     */
    public AsyncLinkedInApiClient createAsyncJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getToken(),
                                             apiConsumer.getTokenSecret());

        client.setAccessToken(accessToken);

        return new AsyncLinkedInApiJaxbClient(client);
    }

    /**
     * Method description
     *
     *
     * @param token
     * @param tokenSecret
     *
     * @return
     */
    public LinkedInApiClient createJaxbClient(String token, String tokenSecret) {
        return createJaxbClient(new LinkedInAccessToken(token, tokenSecret));
    }

    /**
     * Method description
     *
     *
     * @param token
     * @param tokenSecret
     *
     * @return
     */
    public AsyncLinkedInApiClient createAsyncJaxbClient(String token, String tokenSecret) {
        return createAsyncJaxbClient(new LinkedInAccessToken(token, tokenSecret));
    }
}
