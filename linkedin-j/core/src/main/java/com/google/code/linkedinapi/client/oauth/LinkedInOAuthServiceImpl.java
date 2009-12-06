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
 * @author nmukhtar
 *
 */
class LinkedInOAuthServiceImpl implements LinkedInOAuthService {

    /** Field description */
    private final LinkedInApiConsumer apiConsumer;
    
    /** Field description */
    private final OAuthProvider provider;

    /** Field description */
    private final OAuthConsumer consumer;
    
    /**
     * Constructs ...
     *
     *
     * @param apiConsumer
     */
    LinkedInOAuthServiceImpl(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
        consumer = new DefaultOAuthConsumer(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret(),
                SignatureMethod.HMAC_SHA1);
        provider = new DefaultOAuthProvider(consumer,
                LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
                LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL,
                LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);
    }

    /**
     * Method description
     *
     *
     * @param requestToken
     * @param pin
     *
     * @return
     */
    @Override
    public LinkedInAccessToken getOAuthAccessToken(LinkedInRequestToken requestToken, String pin) {
        try {
            provider.retrieveAccessToken(pin);

            LinkedInAccessToken accessToken = new LinkedInAccessToken(consumer.getToken(), consumer.getTokenSecret());

            return accessToken;
        } catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public LinkedInRequestToken getOAuthRequestToken() {
        try {
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
     * Method description
     *
     *
     */
    @Override
    public void signRequestWithToken(HttpURLConnection request, LinkedInAccessToken accessToken) {
    	try {
        	consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());

        	consumer.sign(request);
		} catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
		}
    }
}
