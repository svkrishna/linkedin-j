package com.google.code.linkedinapi.client.oauth;

import java.net.HttpURLConnection;

/**
 * Interface description
 *
 *
 */
public interface LinkedInOAuthService {

    /**
     * Method description
     *
     *
     * @return
     */
    public LinkedInRequestToken getOAuthRequestToken();

    /**
     * Method description
     *
     *
     * @param requestToken
     * @param pin
     *
     * @return
     */
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String pin);

    /**
     * Method description
     *
     *
     * @param request
     * @param accessToken
     */
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken);
}
