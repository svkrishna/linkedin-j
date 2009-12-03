/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public class LinkedInOAuthServiceFactory {
	private static LinkedInOAuthServiceFactory instance;

	private final Map<LinkedInApiConsumer, LinkedInOAuthService> servicesMap;

	private LinkedInOAuthServiceFactory() {
		servicesMap = new HashMap<LinkedInApiConsumer, LinkedInOAuthService>();
	}

	public static synchronized LinkedInOAuthServiceFactory getInstance() {
		if (instance == null) {
			instance = new LinkedInOAuthServiceFactory();
		}

		return instance;
	}

	public LinkedInOAuthService createLinkedInOAuthService(String consumerKey, String consumerSecret) {
		LinkedInApiConsumer apiConsumer = new LinkedInApiConsumer(consumerKey, consumerSecret);

		LinkedInOAuthService service = servicesMap.get(apiConsumer);
		if (service == null) {
			service = new LinkedInOAuthServiceImpl(apiConsumer);
			servicesMap.put(apiConsumer, service);
		}
		return service;
	}
}
