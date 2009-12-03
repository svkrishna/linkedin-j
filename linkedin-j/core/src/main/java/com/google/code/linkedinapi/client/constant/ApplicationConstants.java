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
public final class ApplicationConstants {
    public static final String APP_CONSTANTS_FILE = "com/google/code/linkedinapi/client/constant/ApplicationConstants.properties";

    private static final Properties applicationConstants = new Properties();

    static {
    	try {
			applicationConstants.load(ApplicationConstants.class.getClassLoader().getResourceAsStream(APP_CONSTANTS_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private ApplicationConstants() {}
}
