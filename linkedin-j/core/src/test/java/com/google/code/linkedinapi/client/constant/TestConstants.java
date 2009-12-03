/**
 *
 */
package com.google.code.linkedinapi.client.constant;

import java.io.IOException;
import java.util.Properties;

/**
 * @author nmukhtar
 *
 */
public final class TestConstants {
    public static final String TEST_CONSTANTS_FILE = "com/google/code/linkedinapi/client/constant/TestConstants.properties";

    private static final Properties testConstants = new Properties();

    static {
    	try {
			testConstants.load(TestConstants.class.getClassLoader().getResourceAsStream(TEST_CONSTANTS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private TestConstants() {}

	public static final String LINKED_IN_TEST_CONSUMER_KEY = testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerKey");
	public static final String LINKED_IN_TEST_CONSUMER_SECRET = testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerSecret");
	public static final String LINKED_IN_TEST_ACCESS_TOKEN_KEY = testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenKey");
	public static final String LINKED_IN_TEST_ACCESS_TOKEN_SECRET = testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenSecret");
}
