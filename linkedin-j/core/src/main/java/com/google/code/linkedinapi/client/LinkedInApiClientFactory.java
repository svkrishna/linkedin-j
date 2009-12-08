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
 * A factory for creating LinkedInApiClient objects.
 * 
 * @author Nabeel Mukhtar
 */
public class LinkedInApiClientFactory {

    /** The Constant factoriesMap. */
    private static final Map<LinkedInApiConsumer, LinkedInApiClientFactory> factoriesMap =
        new ConcurrentHashMap<LinkedInApiConsumer, LinkedInApiClientFactory>();
    
    /** The task executor. */
    private ExecutorService taskExecutor;

    /** The api consumer. */
    private LinkedInApiConsumer apiConsumer;

    /** The default client impl. */
    private Constructor<? extends LinkedInApiClient> defaultClientImpl;
    
    /**
     * Instantiates a new linked in api client factory.
     * 
     * @param apiConsumer the api consumer
     */
	private LinkedInApiClientFactory(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
        this.taskExecutor = Executors.newCachedThreadPool();
    }

    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the linked in api client factory
     */
    public static LinkedInApiClientFactory newInstance(String consumerKey, String consumerSecret) {
        return newInstance(new LinkedInApiConsumer(consumerKey, consumerSecret));
    }

    /**
     * New instance.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the linked in api client factory
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
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the linked in api client
     */
    @SuppressWarnings("unchecked")
	public LinkedInApiClient createLinkedInApiClient(LinkedInAccessToken accessToken) {
    	try {
    		if (defaultClientImpl == null) {
        		Class<? extends LinkedInApiClient> clazz = (Class<? extends LinkedInApiClient>) Class.forName(ApplicationConstants.CLIENT_DEFAULT_IMPL);
        		
        		defaultClientImpl = clazz.getConstructor(String.class, String.class);
    		}
			
			final LinkedInApiClient client = defaultClientImpl.newInstance(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());

			client.setAccessToken(accessToken);

	        return client;
		} catch (Exception e) {
			throw new LinkedInApiClientException(e);
		}
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the linked in api client
     */
    public LinkedInApiClient createLinkedInApiJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getConsumerKey(),
                                             apiConsumer.getConsumerSecret());

        client.setAccessToken(accessToken);

        return client;
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = createLinkedInApiClient(accessToken);

        return new AsyncLinkedInApiClientAdapter(client, taskExecutor);
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiJaxbClient(LinkedInAccessToken accessToken) {
        final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getConsumerKey(),
                                             apiConsumer.getConsumerSecret());

        client.setAccessToken(accessToken);

        return new AsyncLinkedInApiClientAdapter(client, taskExecutor);
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the linked in api client
     */
    public LinkedInApiClient createLinkedInApiClient(String token, String tokenSecret) {
        return createLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the linked in api client
     */
    public LinkedInApiClient createLinkedInApiJaxbClient(String token, String tokenSecret) {
        return createLinkedInApiJaxbClient(new LinkedInAccessToken(token, tokenSecret));
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the async linked in api client
     */
    public AsyncLinkedInApiClient createAsyncLinkedInApiJaxbClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiJaxbClient(new LinkedInAccessToken(token, tokenSecret));
    }
}
