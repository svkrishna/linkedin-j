package com.google.code.linkedinapi.client.oauth;

import java.net.HttpURLConnection;

/**
 * The Interface LinkedInOAuthService.
 * 
 * @author Nabeel Mukhtar
 */
public interface LinkedInOAuthService {

    /**
     * Gets the o auth request token.
     * 
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken();

    /**
     * Gets the o auth request token.
     * 
     * @param callBackUrl the callback url.
     * 
     * @return the o auth request token
     */
    public LinkedInRequestToken getOAuthRequestToken(String callBackUrl);
    
    /**
     * Gets the o auth access token.
     * 
     * @param requestToken the request token
     * @param oauthVerifier the oauthVerifier
     * 
     * @return the o auth access token
     */
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier);

    /**
     * Sign request with token.
     * 
     * @param request the request
     * @param accessToken the access token
     */
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken);
}
