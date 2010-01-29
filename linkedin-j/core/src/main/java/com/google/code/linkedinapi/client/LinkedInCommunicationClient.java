/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.Map;

/**
 * The Interface LinkedInCommunicationClient.
 *
 * @author Nabeel Mukhtar
 */
public interface LinkedInCommunicationClient {

    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders);

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders();

    /**
     * Adds the request header.
     *
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue);

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName);
}
