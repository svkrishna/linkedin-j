/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

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
     * Method description
     *
     *
     * @param email
     *
     * @return
     */
    @Override
    public Connections getConnectionsByEmail(String email) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param email
     * @param profileFields
     *
     * @return
     */
    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param id
     *
     * @return
     */
    @Override
    public Connections getConnectionsById(String id) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param id
     * @param profileFields
     *
     * @return
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param url
     *
     * @return
     */
    @Override
    public Connections getConnectionsByUrl(String url) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param url
     * @param profileFields
     *
     * @return
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Connections getConnectionsForCurrentUser() {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates() {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(int start, int count) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param startDate
     * @param endDate
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param updateTypes
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     * @param updateTypes
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(int start, int count, Set<NetworkUpdateType> updateTypes) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param startDate
     * @param endDate
     * @param updateTypes
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate, Set<NetworkUpdateType> updateTypes) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param count
     * @param start
     * @param startDate
     * @param endDate
     * @param updateTypes
     *
     * @return
     */
    @Override
    public Network getNetworkUpdates(int count, int start, Date startDate, Date endDate,
                                     Set<NetworkUpdateType> updateTypes) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.NETWORK_UPDATES, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param id
     * @param profileType
     *
     * @return
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param id
     * @param profileType
     * @param profileFields
     *
     * @return
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_ID, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param url
     * @param profileType
     *
     * @return
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param url
     * @param profileType
     * @param profileFields
     *
     * @return
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_BY_URL, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Person getProfileForCurrentUser() {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    @Override
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param networkUpdateId
     * @param commentText
     */
    @Override
    public void postComment(String networkUpdateId, String commentText) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_COMMENT, namedParameters);

    	UpdateComment comment = OBJECT_FACTORY.createUpdateComment();
    	// TODO-NM: Populate comment

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(comment), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     * @param updateText
     */
    @Override
    public void postNetworkUpdate(String updateText) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_UPDATE, namedParameters);

    	Activity update = OBJECT_FACTORY.createActivity();
    	// TODO-NM: Populate activity

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(update), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
        
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public People searchPeople() {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param searchParameters
     *
     * @return
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    @Override
    public People searchPeople(int start, int count) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param searchParameters
     * @param start
     * @param count
     *
     * @return
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param sortOrder
     *
     * @return
     */
    @Override
    public People searchPeople(SearchSortOrder sortOrder) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param searchParameters
     * @param sortOrder
     *
     * @return
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     * @param sortOrder
     *
     * @return
     */
    @Override
    public People searchPeople(int start, int count, SearchSortOrder sortOrder) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param searchParameters
     * @param start
     * @param count
     * @param sortOrder
     *
     * @return
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEARCH_PEOPLE, namedParameters);

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem invite = OBJECT_FACTORY.createMailboxItem();
    	// TODO-NM: Populate invite

    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
        
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     * @param auth
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message, Authorization auth) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem invite = OBJECT_FACTORY.createMailboxItem();
    	// TODO-NM: Populate invite
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
        
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     * @param recepientIds
     * @param subject
     * @param message
     */
    @Override
    public void sendMessage(List<String> recepientIds, String subject, String message) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.SEND_MESSAGE, namedParameters);

    	MailboxItem messageItem = OBJECT_FACTORY.createMailboxItem();
    	// TODO-NM: Populate messageItem
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(messageItem), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);
        
    	if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    @Override
    public void updateCurrentStatus(String statusText) {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_STATUS, namedParameters);

    	Object status = OBJECT_FACTORY.createCurrentStatus(statusText);
    	LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(status), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT);
        
    	if (response.getStatusCode() != HttpURLConnection.HTTP_NO_CONTENT) {
    		throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));    		
    	}
    }

    /**
     * Method description
     *
     *
     */
    @Override
    public void deleteCurrentStatus() {
    	Map<String, String> namedParameters = new HashMap<String, String>();
    	// TODO-NM: Populate Parameters
    	String apiUrl = LinkedInApiUrls.buildUrl(LinkedInApiUrls.POST_STATUS, namedParameters);

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE);
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
}
