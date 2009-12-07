/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;
import com.google.code.linkedinapi.client.enumeration.HttpMethod;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.ObjectFactory;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComment;

/**
 * @author nmukhtar
 *
 */
public class LinkedInApiJaxbClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final String JAXB_PACKAGE_NAME = "com.google.code.linkedinapi.schema";

    /** Field description */
    private static final ObjectFactory OBJECT_FACTORY = createObjectFactory();

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiJaxbClient(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters", "profileFields");
    	namedParameters.put("email", email);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters");
    	namedParameters.put("email", email);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters", "profileFields");
    	namedParameters.put("id", id);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters");
    	namedParameters.put("id", id);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters", "profileFields");
    	namedParameters.put("url", url);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters");
    	namedParameters.put("url", url);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser() {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters", "profileFields");
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters");
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	namedParameters.put("email", email);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("email", email);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	namedParameters.put("queryParameters", queryParameters);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	namedParameters.put("id", id);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("id", id);
    	namedParameters.put("profileFields", profileFields);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	namedParameters.put("url", url);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("url", url);
    	namedParameters.put("profileFields", profileFields);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("profileFields", profileFields);
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates() {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters", "updateTypes");
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap("updateTypes");
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate) {
    	Map<String, Object> namedParameters = initParametersMap("updateTypes");
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("after", String.valueOf(startDate.getTime()));
    	queryParameters.put("before", String.valueOf(endDate.getTime()));
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("updateTypes", updateTypes);
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	queryParameters.put("updateTypes", updateTypes);
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("after", String.valueOf(startDate.getTime()));
    	queryParameters.put("before", String.valueOf(endDate.getTime()));
    	queryParameters.put("updateTypes", updateTypes);
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int count, int start, Date startDate,
                                     Date endDate) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	queryParameters.put("after", String.valueOf(startDate.getTime()));
    	queryParameters.put("before", String.valueOf(endDate.getTime()));
    	queryParameters.put("updateTypes", updateTypes);
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	namedParameters.put("id", id);
    	namedParameters.put("profileType", profileType);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("id", id);
    	namedParameters.put("profileType", profileType);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	namedParameters.put("url", url);
    	namedParameters.put("profileType", profileType);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("url", url);
    	namedParameters.put("profileType", profileType);
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser() {
    	Map<String, Object> namedParameters = initParametersMap("profileFields");
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("profileFields", profileFields);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postComment(String networkUpdateId, String commentText) {
    	Map<String, Object> namedParameters = initParametersMap();
    	namedParameters.put("updateKey", networkUpdateId);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_COMMENT, namedParameters);

    	UpdateComment comment = OBJECT_FACTORY.createUpdateComment();
    	comment.setComment(commentText);

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(comment), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postNetworkUpdate(String updateText) {
    	Map<String, Object> namedParameters = initParametersMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_UPDATE, namedParameters);

    	Activity update = OBJECT_FACTORY.createActivity();
    	update.setBody(updateText);
    	update.setLocale(Locale.getDefault().toString());
    	update.setContentType("linkedin-html");
    	update.setTimestamp(BigInteger.valueOf(System.currentTimeMillis()));

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(update), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople() {
    	Map<String, Object> namedParameters = initParametersMap("queryParameters");

    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	for (SearchParameter parameter : searchParameters.keySet()) {
    		queryParameters.put(parameter.fieldName(), searchParameters.get(parameter));
    	}
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	
    	for (SearchParameter parameter : searchParameters.keySet()) {
    		queryParameters.put(parameter.fieldName(), searchParameters.get(parameter));
    	}
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(SearchSortOrder sortOrder) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("sortCriteria", sortOrder.fieldName());
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	for (SearchParameter parameter : searchParameters.keySet()) {
    		queryParameters.put(parameter.fieldName(), searchParameters.get(parameter));
    	}
    	queryParameters.put("sortCriteria", sortOrder.fieldName());
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count, SearchSortOrder sortOrder) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	queryParameters.put("sortCriteria", sortOrder.fieldName());
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
    	Map<String, Object> namedParameters = initParametersMap();
    	Map<String, Object> queryParameters = initParametersMap();
    	for (SearchParameter parameter : searchParameters.keySet()) {
    		queryParameters.put(parameter.fieldName(), searchParameters.get(parameter));
    	}
    	queryParameters.put("sortCriteria", sortOrder.fieldName());
    	queryParameters.put("start", String.valueOf(start));
    	queryParameters.put("count", String.valueOf(count));
    	namedParameters.put("queryParameters", queryParameters);
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message) {
    	Map<String, Object> namedParameters = Collections.emptyMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem invite = OBJECT_FACTORY.createMailboxItem();
    	invite.setBody(message);
    	invite.setSubject(subject);
    	// TODO-NM: Populate invite

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message, Authorization auth) {
    	Map<String, Object> namedParameters = Collections.emptyMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem invite = OBJECT_FACTORY.createMailboxItem();
    	invite.setBody(message);
    	invite.setSubject(subject);
    	// TODO-NM: Populate invite
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(List<String> recepientIds, String subject, String message) {
    	Map<String, Object> namedParameters = Collections.emptyMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem messageItem = OBJECT_FACTORY.createMailboxItem();
    	messageItem.setBody(message);
    	messageItem.setSubject(subject);
    	// TODO-NM: Populate messageItem
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(messageItem), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentStatus(String statusText) {
    	Map<String, Object> namedParameters = Collections.emptyMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_STATUS, namedParameters);

    	Object status = OBJECT_FACTORY.createCurrentStatus(statusText);
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(status), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_NO_CONTENT) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCurrentStatus() {
    	Map<String, Object> namedParameters = Collections.emptyMap();
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_STATUS, namedParameters);

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, null, null, HttpMethod.DELETE);

    	if (response.getStatusCode() != HttpURLConnection.HTTP_NO_CONTENT) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * Method description
     *
     *
     * @param response
     * @param <T>
     *
     * @return
     */
    protected <T> T readResponse(LinkedInApiCallResponse response) {
    	if (response.getStatusCode() == HttpURLConnection.HTTP_OK) {
    		InputStream is = response.getResponseContent();
    		try {
                return unmarshallObject(is);
			} finally {
				closeStream(is);
			}
    	} else {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
    	}
    }

    /**
     * Method description
     *
     *
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T unmarshallObject(InputStream xmlContent) {
        try {
            JAXBContext  jc = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
            Unmarshaller u  = jc.createUnmarshaller();

            return (T) u.unmarshal(xmlContent);
        } catch (JAXBException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected String marshallObject(Object element) {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext  jc     = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
            Marshaller   m      = jc.createMarshaller();

            m.marshal(element, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Method description
     *
     * @return
     */
    @SuppressWarnings("unchecked")
	private static ObjectFactory createObjectFactory() {
        try {
        	Class<? extends ObjectFactory> clazz = (Class<? extends ObjectFactory>) Class.forName(ApplicationConstants.DEFAULT_OBJECT_FACTORY);
        	return clazz.newInstance();
		} catch (Exception e) {
			return new ObjectFactory();
		}
	}
}
