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

    /** Field description */
    public static final String TEST_CONSTANTS_FILE =
        "com/google/code/linkedinapi/client/constant/TestConstants.properties";

    /** Field description */
    private static final Properties testConstants = new Properties();

    /** Field description */
    public static final String LINKED_IN_TEST_CONSUMER_SECRET =
        testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerSecret");

    /** Field description */
    public static final String LINKED_IN_TEST_CONSUMER_KEY =
        testConstants.getProperty("com.google.code.linkedinapi.client.apiConsumerKey");

    /** Field description */
    public static final String LINKED_IN_TEST_ACCESS_TOKEN_SECRET =
        testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenSecret");

    /** Field description */
    public static final String LINKED_IN_TEST_ACCESS_TOKEN_KEY =
        testConstants.getProperty("com.google.code.linkedinapi.client.accessTokenKey");

    static {
        try {
            testConstants.load(TestConstants.class.getClassLoader().getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs ...
     *
     */
    private TestConstants() {}
}
