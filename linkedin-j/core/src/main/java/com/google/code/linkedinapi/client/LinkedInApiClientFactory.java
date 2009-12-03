/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.HashMap;
import java.util.Map;

import com.google.code.linkedinapi.client.impl.AsyncLinkedInApiJaxbClient;
import com.google.code.linkedinapi.client.impl.LinkedInApiJaxbClient;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;

/**
 * @author nmukhtar
 *
 */
public class LinkedInApiClientFactory {
	private static final Map<LinkedInApiConsumer, LinkedInApiClientFactory> factoriesMap = new HashMap<LinkedInApiConsumer, LinkedInApiClientFactory>();
	private LinkedInApiConsumer apiConsumer;

	private LinkedInApiClientFactory(LinkedInApiConsumer apiConsumer) {
		this.apiConsumer = apiConsumer;
	}

	public static synchronized LinkedInApiClientFactory newInstance(String consumerKey, String consumerSecret) {
		LinkedInApiConsumer apiConsumer = new LinkedInApiConsumer(consumerKey, consumerSecret);
		LinkedInApiClientFactory factory = factoriesMap.get(apiConsumer);
		if (factory == null) {
			factory = new LinkedInApiClientFactory(apiConsumer);
			factoriesMap.put(apiConsumer, factory);
		}

		return factory;
	}

	public LinkedInApiClient createJaxbClient(String token, String tokenSecret) {
		final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getToken(), apiConsumer.getTokenSecret());
		client.setAccessToken(new LinkedInAccessToken(token, tokenSecret));

		return client;
	}

	public AsyncLinkedInApiClient createAsyncJaxbClient(String token, String tokenSecret) {
		final LinkedInApiClient client = new LinkedInApiJaxbClient(apiConsumer.getToken(), apiConsumer.getTokenSecret());
		client.setAccessToken(new LinkedInAccessToken(token, tokenSecret));

		return new AsyncLinkedInApiJaxbClient(client);
	}
}
