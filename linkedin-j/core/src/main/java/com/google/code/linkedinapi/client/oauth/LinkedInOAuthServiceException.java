/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

/**
 * Class description
 *
 *
 */
public class LinkedInOAuthServiceException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
     * Constructs ...
     *
     */
    public LinkedInOAuthServiceException() {
        super();
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     */
    public LinkedInOAuthServiceException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     *
     * @param cause
     */
    public LinkedInOAuthServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public LinkedInOAuthServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
