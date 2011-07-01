package com.google.code.linkedinapi.client.examples;

// LinkedIn SignPost Sample Code
// Adapted by Taylor Singletary 
// from Twitter SignPost Sample Code ( http://oauth-signpost.googlecode.com/files/OAuthTwitterExample.zip )
// Tested and Functional with attached SignPost JAR
// YMMV

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class Signposter {

    public static void main(String[] args) throws Exception {
    	OAuthConsumer consumer = new DefaultOAuthConsumer(
                "TdA4ZuoRgD46-vh8kFF9l0xcs5W3ODBaGdto1OdLv9ujfZiKpq4_KBfT7j-xa0d6",
                "biSbgqH0hSzCvDMDsQyA21AOapiLzUS8Ka11QDraqVGj8kFZJEY1FrqUqYdffCwi");

//        OAuthProvider provider = new DefaultOAuthProvider("https://api.linkedin.com/uas/oauth/requestToken",
//                "https://api.linkedin.com/uas/oauth/accessToken",
//                "https://api.linkedin.com/uas/oauth/authorize");
//				
//        System.out.println("Fetching request token from LinkedIn...");
//
//        // we do not support callbacks, thus pass OOB
//        provider.setOAuth10a(true);
//        String authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
//
//        System.out.println("Request token: " + consumer.getToken());
//        System.out.println("Token secret: " + consumer.getTokenSecret());
//
//        System.out.println("Now visit:\n" + authUrl
//                + "\n... and grant this app authorization");
//        System.out.println("Enter the PIN code and hit ENTER when you're done:");
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String pin = br.readLine();
//
//        System.out.println("Fetching access token from LinkedIn...");
//
//        provider.retrieveAccessToken(consumer, pin);
//
//        System.out.println("Access token: " + consumer.getToken());
//        System.out.println("Token secret: " + consumer.getTokenSecret());

    	consumer.setTokenWithSecret("a2e551c2-56d0-4042-918f-087b39e6f42f", "49772a11-416a-44f4-aa04-8528f574102d");
//        URL url = new URL("http://api.linkedin.com/v1/groups/35222:(id,name,short-description,description,relation-to-viewer:(membership-state,available-actions),counts-by-category,is-open-to-non-members,category,website-url,site-group-url,contact-email,locale,location:(country,postal-code),allow-member-invites,small-logo-url,large-logo-url,posts:(id,type,category,title,summary,creator,creation-timestamp,relation-to-viewer:(is-following,is-liked,available-actions),likes,comments,attachment,site-group-post-url))");
    	URL url = new URL("http://api.linkedin.com/v1/people/~/group-memberships:(group:(id,name),person,membership-state,contact-email,show-group-logo-in-profile,allow-messages-from-members,email-digest-frequency,email-announcements-from-managers,email-for-every-new-post)?count=5&start=0");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();

        consumer.sign(request);

        System.out.println("Sending request to LinkedIn...");
        request.connect();
		
        if (request.getResponseCode() == 200) {
	        String responseBody = convertStreamToString(request.getInputStream());
	        
	        System.out.println("Response: " + request.getResponseCode() + " "
	                + request.getResponseMessage() + "\n\n" + responseBody);
		} else {
	        String responseBody = convertStreamToString(request.getErrorStream());
	        
	        System.out.println("Response: " + request.getResponseCode() + " "
	                + request.getResponseMessage() + "\n\n" + responseBody);
		}
    }
    
    // Stolen liberally from http://www.kodejava.org/examples/266.html
    public static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
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