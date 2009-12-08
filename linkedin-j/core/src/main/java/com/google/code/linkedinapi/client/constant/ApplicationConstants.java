/**
 *
 */
package com.google.code.linkedinapi.client.constant;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class ApplicationConstants.
 * 
 * @author Nabeel Mukhtar
 */
public final class ApplicationConstants {

    /** The Constant APP_CONSTANTS_FILE. */
    public static final String APP_CONSTANTS_FILE =
        "com/google/code/linkedinapi/client/constant/ApplicationConstants.properties";

    /** The Constant applicationConstants. */
    private static final Properties applicationConstants = new Properties();

    static {
        try {
            applicationConstants.load(
                ApplicationConstants.class.getClassLoader().getResourceAsStream(APP_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** The Constant VALIDATE_XML. */
    public static final String VALIDATE_XML =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.validateXml");

    /** The Constant OAUTH_VERSION. */
    public static final String OAUTH_VERSION =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.oauthVersion");

    /** The Constant CONTENT_ENCODING. */
    public static final String CONTENT_ENCODING =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.encoding");

    /** The Constant CONTENT_TYPE_XML. */
    public static final String CONTENT_TYPE_XML =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.contentTypeXml");

    /** The Constant CLIENT_DEFAULT_IMPL. */
    public static final String CLIENT_DEFAULT_IMPL =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.defaultImpl");

    /** The Constant DEFAULT_OBJECT_FACTORY. */
    public static final String DEFAULT_OBJECT_FACTORY =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.jaxb.objectFactory");
    
    /** The Constant DEFAULT_RESULT_SIZE. */
    public static final String DEFAULT_RESULT_SIZE =
    	applicationConstants.getProperty("com.google.code.linkedinapi.client.defaultResultSize");
    
    /**
     * Instantiates a new application constants.
     */
    private ApplicationConstants() {}
}
