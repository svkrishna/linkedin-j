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
	private static LinkedInOAuthServiceFactory instance;

	private final Map<LinkedInApiConsumer, LinkedInOAuthService> servicesMap;

	private LinkedInOAuthServiceFactory() {
		servicesMap = new ConcurrentHashMap<LinkedInApiConsumer, LinkedInOAuthService>();
	}

	public static synchronized LinkedInOAuthServiceFactory getInstance() {
		if (instance == null) {
			instance = new LinkedInOAuthServiceFactory();
		}

		return instance;
	}

	public LinkedInOAuthService createLinkedInOAuthService(String consumerKey, String consumerSecret) {
		return createLinkedInOAuthService(new LinkedInApiConsumer(consumerKey, consumerSecret));

	}

	public LinkedInOAuthService createLinkedInOAuthService(LinkedInApiConsumer apiConsumer) {
		LinkedInOAuthService service = servicesMap.get(apiConsumer);
		if (service == null) {
			service = new LinkedInOAuthServiceImpl(apiConsumer);
			servicesMap.put(apiConsumer, service);
		}
		return service;
	}
}
