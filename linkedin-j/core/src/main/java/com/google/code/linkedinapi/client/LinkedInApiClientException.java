/**
 *
 */
package com.google.code.linkedinapi.client;

/**
 * Class description
 *
 *
 */
public class LinkedInApiClientException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
     * Constructs ...
     *
     */
    public LinkedInApiClientException() {
        super();
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     */
    public LinkedInApiClientException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     *
     * @param cause
     */
    public LinkedInApiClientException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public LinkedInApiClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
