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
    private LinkedInApiConsumer apiConsumer;

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
            OAuthConsumer consumer = new DefaultOAuthConsumer(apiConsumer.getToken(), apiConsumer.getTokenSecret(),
                                         SignatureMethod.HMAC_SHA1);
            OAuthProvider provider = new DefaultOAuthProvider(consumer,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);

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
            OAuthConsumer consumer = new DefaultOAuthConsumer(apiConsumer.getToken(), apiConsumer.getTokenSecret(),
                                         SignatureMethod.HMAC_SHA1);
            OAuthProvider provider = new DefaultOAuthProvider(consumer,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_REQUEST_TOKEN_URL,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_ACCESS_TOKEN_URL,
                                         LinkedInApiUrls.LINKED_IN_OAUTH_AUTHORIZE_URL);
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
            OAuthConsumer consumer = new DefaultOAuthConsumer(apiConsumer.getToken(), apiConsumer.getTokenSecret(),
                    SignatureMethod.HMAC_SHA1);
        	consumer.setTokenWithSecret(accessToken.getToken(), accessToken.getTokenSecret());

        	consumer.sign(request);
		} catch (Exception e) {
            throw new LinkedInOAuthServiceException(e);
		}
    }
}
