/**
 *
 */
package com.google.code.linkedinapi.client;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.impl.AsyncLinkedInApiClientAdapter;
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
    private ExecutorService taskExecutor;

    /** Field description */
    private LinkedInApiConsumer apiConsumer;

    /** Field description */
    private Class<? extends LinkedInApiClient> defaultClientImpl;
    
    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    @SuppressWarnings("unchecked")
	private LinkedInApiClientFactory(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
        this.taskExecutor = Executors.newCachedThreadPool();
        try {
			defaultClientImpl = (Class<? extends LinkedInApiClient>) Class.forName(ApplicationConstants.CLIENT_DEFAULT_IMPL);
		} catch (ClassNotFoundException e) {
			defaultClientImpl = LinkedInApiJaxbClient.class; 
		}
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
    public LinkedInApiClient createLinkedInApiClient(LinkedInAccessToken accessToken) {
    	try {
			Constructor<? extends LinkedInApiClient> constructor = defaultClientImpl.getConstructor(String.class, String.class);
			
			final LinkedInApiClient client = constructor.newInstance(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());

			client.setAccessToken(accessToken);

	        return client;
		} catch (Exception e) {
			throw new LinkedInApiClientException(e);
		}
    }
    
    /**
     * Method description
     *
     *
     * @param accessToken
     *
     * @return
     */
    public LinkedInApiClient createLinkedInApiJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getConsumerKey(),
                                             apiConsumer.getConsumerSecret());

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
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = createLinkedInApiClient(accessToken);

        return new AsyncLinkedInApiClientAdapter(client, taskExecutor);
    }
    
    /**
     * Method description
     *
     *
     * @param accessToken
     *
     * @return
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getConsumerKey(),
                                             apiConsumer.getConsumerSecret());

        client.setAccessToken(accessToken);

        return new AsyncLinkedInApiClientAdapter(client, taskExecutor);
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
    public LinkedInApiClient createLinkedInApiClient(String token, String tokenSecret) {
        return createLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
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
    public LinkedInApiClient createLinkedInApiJaxbClient(String token, String tokenSecret) {
        return createLinkedInApiJaxbClient(new LinkedInAccessToken(token, tokenSecret));
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
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
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
    public AsyncLinkedInApiClient createAsyncLinkedInApiJaxbClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiJaxbClient(new LinkedInAccessToken(token, tokenSecret));
    }
}
