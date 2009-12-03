/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;

/**
 * @author nmukhtar
 *
 */
public abstract class BaseLinkedInApiClient implements LinkedInApiClient {
	private LinkedInApiConsumer apiConsumer;
	private LinkedInAccessToken accessToken;

	public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
		this.apiConsumer = apiConsumer;
	}

	public LinkedInApiConsumer getApiConsumer() {
		return apiConsumer;
	}

	public void setAccessToken(LinkedInAccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public LinkedInAccessToken getAccessToken() {
		return accessToken;
	}


	protected BaseLinkedInApiClient(String consumerKey, String consumerSecret) {
		apiConsumer = new LinkedInApiConsumer(consumerKey, consumerSecret);
	}

	/**
	 *
	 */
	protected void callApiMethod(String apiUrl) {

		try {
			LinkedInOAuthService oAuthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getToken(), apiConsumer.getTokenSecret());
			URL url = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();

	        oAuthService.signRequestWithToken(request, accessToken);

	        request.connect();
	        String responseBody = convertStreamToString(request.getInputStream());

	        System.out.println("Response: " + request.getResponseCode() + " "
	                + request.getResponseMessage() + "\n\n" + responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	protected void callApiMethod(String apiUrl, String xmlContent, String contentType, String method) {
		try {
			LinkedInOAuthService oAuthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getToken(), apiConsumer.getTokenSecret());

			URL url = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();

			request.setRequestMethod(method);
			request.setDoOutput(true);

	        oAuthService.signRequestWithToken(request, accessToken);

			request.setRequestProperty("Content-Type", contentType);

			PrintStream out = new PrintStream(request.getOutputStream());

			out.print(xmlContent);

			out.flush();
			out.close();

	        request.connect();

	        String responseBody = convertStreamToString(request.getInputStream());

	        System.out.println("Response: " + request.getResponseCode() + " "
	                + request.getResponseMessage() + "\n\n" + responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    protected String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }



}
