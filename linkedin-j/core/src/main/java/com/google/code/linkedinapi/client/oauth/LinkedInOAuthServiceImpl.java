/**
 *
 */
package com.google.code.linkedinapi.client.oauth;

import java.net.HttpURLConnection;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.signature.SignatureMethod;

import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;

/**
 * @author Nabeel Mukhtar
 *
 */
class LinkedInOAuthServiceImpl implements LinkedInOAuthService {

    /** Field description */
    private final LinkedInApiConsumer apiConsumer;

    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    LinkedInOAuthServiceImpl(LinkedInApiConsumer apiConsumer) {
    	this.apiConsumer = apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String oauthVerifier) {
        try {
        	final OAuthConsumer consumer = getOAuthConsumer();
        	final OAuthProvider provider = getOAuthProvider(consumer);
        	
        	consumer.setTokenWithSecret(requestToken.getToken(), requestToken.getTokenSecret());
            provider.retrieveAccessToken(oauthVerifier);

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
        	final OAuthProvider provider = getOAuthProvider(consumer);
        	
            String               authorizationUrl = provider.retrieveRequestToken(OAuth.OUT_OF_BAND);
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
        	final OAuthProvider provider = getOAuthProvider(consumer);
        	
            String               authorizationUrl = provider.retrieveRequestToken(callBackUrl);
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
    protected OAuthProvider getOAuthProvider(OAuthConsumer consumer) {
		return new DefaultOAuthProvider(consumer, LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
		        LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL, LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);
	}

    /** 
    *
    */
	protected OAuthConsumer getOAuthConsumer() {
		return new DefaultOAuthConsumer(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret(),
		        SignatureMethod.HMAC_SHA1);
	}
}
