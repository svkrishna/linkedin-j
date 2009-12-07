/**
 *
 */
package com.google.code.linkedinapi.client.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.FieldEnum;

/**
 * @author nmukhtar
 *
 */
public final class LinkedInApiUrls {

    /** Field description */
    public static final String API_URLS_FILE = "com/google/code/linkedinapi/client/constant/LinkedInApiUrls.properties";

    /** Field description */
    private static final char API_URLS_PLACEHOLDER_START = '{';

    /** Field description */
    private static final char API_URLS_PLACEHOLDER_END = '}';

    /** Field description */
    private static final Properties linkedInApiUrls = new Properties();

    static {
        try {
            linkedInApiUrls.load(LinkedInApiUrls.class.getClassLoader().getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Field description */
    public static final String GET_PROFILE_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileForCurrentUser");

    /** Field description */
    public static final String GET_PROFILE_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileById");

    /** Field description */
    public static final String GET_PROFILE_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileByUrl");

    /** Field description */
    public static final String SEARCH_PEOPLE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchPeople");

    /** Field description */
    public static final String POST_UPDATE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");

    /** Field description */
    public static final String POST_STATUS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");

    /** Field description */
    public static final String POST_COMMENT =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");

    /** Field description */
    public static final String SEND_MESSAGE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.sendMessage");


    /** Field description */
    public static final String LINKED_IN_OAUTH_REQUEST_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.requestToken");

    /** Field description */
    public static final String LINKED_IN_OAUTH_AUTHORIZE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.authorize");

    /** Field description */
    public static final String LINKED_IN_OAUTH_ACCESS_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.accessToken");

    /** Field description */
    public static final String NETWORK_UPDATES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");

    /** Field description */
    public static final String GET_CONNECTIONS_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsForCurrentUser");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsById");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_EMAIL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByEmail");

    /** Field description */
    public static final String GET_CONNECTIONS_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByUrl");

    /**
     * Constructs ...
     *
     */
    private LinkedInApiUrls() {}

    /**
     * Method description
     *
     *
     * @param urlFormat
     * @param namedParameters
     *
     * @return
     */
    @SuppressWarnings("unchecked")
	public static String buildUrl(String urlFormat, Map<String, Object> namedParameters) {
    	StringBuilder urlBuilder = new StringBuilder();
    	StringBuilder placeHolderBuilder = new StringBuilder();
    	boolean placeHolderFlag = false;
    	for (int i = 0; i < urlFormat.length(); i++) {
    		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
    			placeHolderBuilder = new StringBuilder();
    			placeHolderFlag = true;
    		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
    			String placeHolder = placeHolderBuilder.toString();
    			if (namedParameters.containsKey(placeHolder)) {
    				Object value = namedParameters.get(placeHolder);
    				if (value instanceof Map) {
    					// this is a query string map.
    					Map<String, Object> parameterMap = (Map<String, Object>) value;
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parameterMap.isEmpty()) {
    			        	builder.append("?");
    			    		Iterator<String> iter = parameterMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
    			    			Object paramValue = parameterMap.get(name);
    			    			if (paramValue instanceof Collection<?>) {
    			    				Collection<Object> parameterValues = (Collection<Object>) paramValue;
    			    				for (Object o : parameterValues) {
        			    				builder.append(name);
        			    				builder.append("=");
        			    				builder.append(encodeUrl(o.toString(), ApplicationConstants.CONTENT_ENCODING));
    			    				}
    			    				    				
    			    			} else {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(encodeUrl(paramValue.toString(), ApplicationConstants.CONTENT_ENCODING));
    			    			}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
    				} else if (value instanceof Set) {
    					// this is an enum set.
    					Set<? extends FieldEnum> enumSet = (Set<? extends FieldEnum>) value;
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!enumSet.isEmpty()) {
    			        	builder.append(":");
    			    		Iterator<? extends FieldEnum> iter = enumSet.iterator();
    			        	builder.append("(");
    			    		while (iter.hasNext()) {
    			    			FieldEnum fieldEnum = iter.next();
    			    			builder.append(fieldEnum.fieldName());
    			    			if (iter.hasNext()) {
    			    				builder.append(",");
    			    			}
    			    		}
    			        	builder.append(")");
    			    	}
        				// bind the parameter to the placeholder
        				urlBuilder.append(builder.toString());
    				} else if (value instanceof FieldEnum) {
    					// this is an enum set.
    			    	StringBuilder builder = new StringBuilder();
			        	builder.append(":");
			        	builder.append(((FieldEnum) value).fieldName());
        				// bind the parameter to the placeholder
        				urlBuilder.append(builder.toString());
    				} else {
        				// bind the parameter to the placeholder
        				urlBuilder.append(encodeUrl(value.toString(), ApplicationConstants.CONTENT_ENCODING));
    				}
    			} else {
    				// we did not find a binding for the placeholder.
    				// append it as it is.
    				urlBuilder.append(API_URLS_PLACEHOLDER_START);
    				urlBuilder.append(placeHolder);
    				urlBuilder.append(API_URLS_PLACEHOLDER_END);
    			}
    			placeHolderFlag = false;
    		} else if (placeHolderFlag) {
    			placeHolderBuilder.append(urlFormat.charAt(i));
    		} else {
    			urlBuilder.append(urlFormat.charAt(i));
    		}
    	}

    	return urlBuilder.toString();
    }

    /**
     * Method description
     *
     *
     * @param original
     * @param encoding
     *
     * @return
     */
    private static String encodeUrl(String original, String encoding) {
    	try {
			return URLEncoder.encode(original, encoding);
		} catch (UnsupportedEncodingException e) {
			// should never be here..
			return original;
		}
    }
}
