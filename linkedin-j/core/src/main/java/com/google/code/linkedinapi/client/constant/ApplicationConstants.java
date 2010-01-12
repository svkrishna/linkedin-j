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
    public static final boolean VALIDATE_XML = getBooleanProperty("com.google.code.linkedinapi.client.validateXml");

    /** The Constant OAUTH_VERSION. */
    public static final String OAUTH_VERSION = getProperty("com.google.code.linkedinapi.client.oauthVersion");

    /** The Constant DEFAULT_RESULT_SIZE. */
    public static final int DEFAULT_RESULT_SIZE =
        getIntProperty("com.google.code.linkedinapi.client.defaultResultSize");

    /** The Constant CONTENT_TYPE_XML. */
    public static final String CONTENT_TYPE_XML = getProperty("com.google.code.linkedinapi.client.contentTypeXml");

    /** The Constant CONTENT_ENCODING. */
    public static final String CONTENT_ENCODING = getProperty("com.google.code.linkedinapi.client.encoding");

    /** The Constant COMPRESS_CONTENTS. */
    public static final boolean COMPRESS_CONTENTS =
        getBooleanProperty("com.google.code.linkedinapi.client.compressContent");

    /** The Constant CLIENT_DEFAULT_IMPL. */
    public static final String CLIENT_DEFAULT_IMPL = getProperty("com.google.code.linkedinapi.client.defaultImpl");

    /** The Constant CONNECT_TIMEOUT. */
    public static final int CONNECT_TIMEOUT = getIntProperty("com.google.code.linkedinapi.client.connectTimeout");
    
    /** The Constant READ_TIMEOUT. */
    public static final int READ_TIMEOUT = getIntProperty("com.google.code.linkedinapi.client.readTimeout");
    
    /** The Constant AUTH_HEADER_NAME. */
    public static final String AUTH_HEADER_NAME = getProperty("com.google.code.linkedinapi.client.authHeaderName");
    
    /**
     * Instantiates a new application constants.
     */
    private ApplicationConstants() {}

    /**
     * Get property as int.
     */
    public static String getProperty(String key) {
        return applicationConstants.getProperty(key);
    }

    /**
     * Get property as int.
     */
    public static int getIntProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Integer.parseInt(property);
        }
    }

    /**
     * Get property as boolean.
     */
    public static boolean getBooleanProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return false;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    /**
     * Get property as double.
     */
    public static double getDoubleProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Double.parseDouble(property);
        }
    }

    /**
     * Get property as long.
     */
    public static long getLongProperty(String key) {
        String property = applicationConstants.getProperty(key);

        if (isNullOrEmpty(property)) {
            return 0;
        } else {
            return Long.parseLong(property);
        }
    }

    /**
     * Get property as long.
     */
    private static boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
}
