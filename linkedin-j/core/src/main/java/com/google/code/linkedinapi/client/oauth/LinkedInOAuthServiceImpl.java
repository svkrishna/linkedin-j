/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;

/**
 * @author Nabeel Mukhtar
 *
 */
class LinkedInOAuthServiceImpl implements LinkedInOAuthService {

    /** Field description */
    private final LinkedInApiConsumer apiConsumer;

    /** Field description */
    private Map<String, String> requestHeaders;
    
    /** Field description */
    private static final String OAUTH_VERSION_1_0_a = "1.0a";
    
    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    LinkedInOAuthServiceImpl(LinkedInApiConsumer apiConsumer) {
    	requestHeaders = new HashMap<String, String>();
    	this.apiConsumer = apiConsumer;
    }
    
    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	if (requestHeaders == null) {
    		throw new IllegalArgumentException("request headers cannot be null.");
    	}
        this.requestHeaders = requestHeaders;
    }

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * Adds the request header.
     *
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier) {
    	if (requestToken == null) {
    		throw new IllegalArgumentException("request token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
        	consumer.setTokenWithSecret(requestToken.getToken(), requestToken.getTokenSecret());
            provider.retrieveAccessToken(consumer, oauthVerifier);

            return new LinkedInAccessToken(consumer.getToken(), consumer.getTokenSecret());
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInRequestToken getOAuthRequestToken() {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
            LinkedInRequestToken requestToken     = new LinkedInRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);

            return requestToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInRequestToken getOAuthRequestToken(String callBackUrl) {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider();
        	
            String               authorizationUrl = provider.retrieveRequestToken(consumer, callBackUrl);
            LinkedInRequestToken requestToken     = new LinkedInRequestToken(consumer.getToken(),
                                                        consumer.getTokenSecret());

            requestToken.setAuthorizationUrl(authorizationUrl);

            return requestToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken) {
    	if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
            consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());
            consumer.sign(request);
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }
    
    /** 
     *
     */
    protected OAuthProvider getOAuthProvider() {
    	DefaultOAuthProvider provider = new DefaultOAuthProvider(LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
		        LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL, LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);
    	
    	provider.setOAuth10a(OAUTH_VERSION_1_0_a.equals(ApplicationConstants.OAUTH_VERSION));
    	
        for (String headerName : requestHeaders.keySet()) {
        	provider.setRequestHeader(headerName, requestHeaders.get(headerName));
        }
    	
    	return provider;
	}

    /** 
    *
    */
	protected OAuthConsumer getOAuthConsumer() {
		return new DefaultOAuthConsumer(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());
	}
}
