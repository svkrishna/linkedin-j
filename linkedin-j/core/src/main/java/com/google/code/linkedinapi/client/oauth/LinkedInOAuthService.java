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
     *
     * @return
     */
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String pin);

    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken);
}
