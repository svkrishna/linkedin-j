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

	public void setApiConsumer(LinkedInApiConsumer apiConsumer);

	public LinkedInApiConsumer getApiConsumer();

	public void setAccessToken(LinkedInAccessToken accessToken);

	public LinkedInAccessToken getAccessToken();
}
