/**
 *
 */
package com.google.code.linkedinapi.client;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;

/**
 * @author nmukhtar
 *
 */
public interface LinkedInAuthenticationClient {

    /**
     * Method description
     *
     *
     * @param apiConsumer
     */
    public void setApiConsumer(LinkedInApiConsumer apiConsumer);

    /**
     * Method description
     *
     *
     * @return
     */
    public LinkedInApiConsumer getApiConsumer();

    /**
     * Method description
     *
     *
     * @param accessToken
     */
    public void setAccessToken(LinkedInAccessToken accessToken);

    /**
     * Method description
     *
     *
     * @return
     */
    public LinkedInAccessToken getAccessToken();
}
