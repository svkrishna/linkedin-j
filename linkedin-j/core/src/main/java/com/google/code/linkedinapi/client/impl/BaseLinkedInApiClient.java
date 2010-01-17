/**
 *
 */
package com.google.code.linkedinapi.client.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.client.enumeration.HttpMethod;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.HttpHeader;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class BaseLinkedInApiClient implements LinkedInApiClient {

    /** Field description */
    private static final String GZIP_ENCODING = "gzip";

    /** Field description */
    private final SchemaElementFactory<?> OBJECT_FACTORY = createObjectFactory();

    /** Field description */
    private LinkedInAccessToken accessToken;

    /** Field description */
    private LinkedInApiConsumer apiConsumer;

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    protected BaseLinkedInApiClient(String consumerKey, String consumerSecret) {
        apiConsumer = new LinkedInApiConsumer(consumerKey, consumerSecret);
    }

    /**
     * {@inheritDoc}
     */
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedInApiConsumer getApiConsumer() {
        return apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    public void setAccessToken(LinkedInAccessToken accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * {@inheritDoc}
     */
    public LinkedInAccessToken getAccessToken() {
        return accessToken;
    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Connections getConnectionsByEmail(String email) {
//        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
//        String                apiUrl  = builder.withEmptyField("profileFields").withField("email", email).buildUrl();
//
//        return readResponse(Connections.class, callApiMethod(apiUrl));
//    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {
//        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
//        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
//                                            profileFields).buildUrl();
//
//        return readResponse(Connections.class, callApiMethod(apiUrl));
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id) {
    	assertNotNullOrEmpty("id", id);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id", id).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
    	assertNotNullOrEmpty("id", id);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url) {
    	assertNotNullOrEmpty("url", url);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url", url, true).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
    	assertNotNullOrEmpty("url", url);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField("url", url, true).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
//    @Override
//    public Connections getConnectionsByEmail(String email, int start, int count) {
//        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
//        String                apiUrl  = builder.withEmptyField("profileFields").withField("email",
//                                            email).withParameter("start", String.valueOf(start)).withParameter("count",
//                                                String.valueOf(count)).buildUrl();
//
//        return readResponse(Connections.class, callApiMethod(apiUrl));
//    }

    /**
     * {@inheritDoc}
     */
//    @Override
//    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count) {
//        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
//        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
//                                            profileFields).withParameter("start",
//                                                String.valueOf(start)).withParameter("count",
//                                                    String.valueOf(count)).buildUrl();
//
//        return readResponse(Connections.class, callApiMethod(apiUrl));
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, int start, int count) {
    	assertNotNullOrEmpty("id", id);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id",
                                            id).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count) {
    	assertNotNullOrEmpty("id", id);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, int start, int count) {
    	assertNotNullOrEmpty("url", url);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url",
                                            url, true).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count) {
    	assertNotNullOrEmpty("url", url);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField("url", url, true).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(int start, int count) {
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count) {
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(int start, int count) {
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate) {
    	assertNotNull("start date", startDate);
    	assertNotNull("end date", endDate);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("after",
                                            String.valueOf(startDate.getTime())).withParameter("before",
                                                String.valueOf(endDate.getTime())).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {
    	assertNotNull("update types", updateTypes);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameterEnumSet("type", updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
    	assertNotNull("update types", updateTypes);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withParameterEnumSet("type", updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
    	assertNotNull("update types", updateTypes);
    	assertNotNull("start date", startDate);
    	assertNotNull("end date", endDate);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("after",
                                            String.valueOf(startDate.getTime())).withParameter("before",
                                                String.valueOf(endDate.getTime())).withParameterEnumSet("type",
                                                    updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count, Date startDate,
                                     Date endDate) {
    	assertNotNull("update types", updateTypes);
    	assertNotNull("start date", startDate);
    	assertNotNull("end date", endDate);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withParameter("after",
                                                String.valueOf(startDate.getTime())).withParameter("before",
                                                    String.valueOf(endDate.getTime())).withParameterEnumSet("type",
                                                        updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public UpdateComments getNetworkUpdateComments(String networkUpdateId) {
    	assertNotNullOrEmpty("network update id", networkUpdateId);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATE_COMMENTS);
        String                apiUrl  = builder.withField("updateKey", networkUpdateId).buildUrl();
        
        return readResponse(UpdateComments.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType) {
    	return getProfileById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id) {
    	assertNotNullOrEmpty("id", id);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id",
                                            id).withFieldEnum("profileType", ProfileType.STANDARD).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
    	return getProfileById(id, profileFields);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, Set<ProfileField> profileFields) {
    	assertNotNullOrEmpty("id", id);
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnum("profileType",
                                            ProfileType.STANDARD).withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
    	assertNotNullOrEmpty("url", url);
    	assertNotNull("profile type", profileType);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url",
                                            url, true).withFieldEnum("profileType", profileType).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
    	assertNotNullOrEmpty("url", url);
    	assertNotNull("profile fields", profileFields);
    	assertNotNull("profile type", profileType);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withField("url", url, true).withFieldEnum("profileType",
                                            profileType).withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {
    	assertNotNull("profile fields", profileFields);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByApiRequest(ApiStandardProfileRequest apiRequest) {
    	assertNotNull("api request", apiRequest);
    	if (apiRequest.getHeaders() != null) {
            return readResponse(Person.class, callApiMethod(apiRequest.getUrl(), apiRequest.getHeaders().getHttpHeader()));
    	} else {
    		return readResponse(Person.class, callApiMethod(apiRequest.getUrl()));
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postComment(String networkUpdateId, String commentText) {
    	assertNotNullOrEmpty("network update id", networkUpdateId);
    	assertNotNullOrEmpty("comment", commentText);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_COMMENT);
        String                apiUrl  = builder.withField("updateKey", networkUpdateId).buildUrl();
        UpdateComment         comment = OBJECT_FACTORY.createUpdateComment();

        comment.setComment(commentText);
        callApiMethod(apiUrl, marshallObject(comment), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postNetworkUpdate(String updateText) {
    	assertNotNullOrEmpty("network update", updateText);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_UPDATE);
        String                apiUrl  = builder.buildUrl();
        Activity              update  = OBJECT_FACTORY.createActivity();

        update.setBody(updateText);
        update.setLocale(Locale.getDefault().toString());
        update.setContentType(NetworkUpdateContentType.LINKED_IN_HTML);
        update.setTimestamp(System.currentTimeMillis());
        callApiMethod(apiUrl, marshallObject(update), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters) {
    	assertNotNull("search parameters", searchParameters);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count) {
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
    	
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {
    	assertNotNull("search parameters", searchParameters);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnumMap(searchParameters).withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(SearchSortOrder sortOrder) {
    	assertNotNull("sort order", sortOrder);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnum("sortCriteria", sortOrder).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
    	assertNotNull("search parameters", searchParameters);
    	assertNotNull("sort order", sortOrder);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withParameterEnumMap(searchParameters).withParameterEnum("sortCriteria", sortOrder).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count, SearchSortOrder sortOrder) {
    	assertNotNull("sort order", sortOrder);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withParameterEnum("sortCriteria",
                                                sortOrder).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
    	assertNotNull("search parameters", searchParameters);
    	assertPositiveNumber("start", start);
    	assertPositiveNumber("count", count);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withParameterEnumMap(searchParameters).withParameterEnum("sortCriteria",
                                         sortOrder).withParameter("start",
                                             String.valueOf(start)).withParameter("count",
                                                 String.valueOf(count)).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteByEmail(String email, String firstName, String lastName, String subject, String message) {
    	assertNotNullOrEmpty("email", email);
    	assertNotNullOrEmpty("firstName", firstName);
    	assertNotNullOrEmpty("lastName", lastName);
    	assertNotNullOrEmpty("subject", subject);
    	assertNotNullOrEmpty("message", message);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_INVITE_EMAIL_PERSON_PATH).withField("email", email).buildUrl());
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipient().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);
        invite.getItemContent().setInvitationRequest(request);
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteById(String recepientId, String subject, String message, String authHeader) {
    	assertNotNullOrEmpty("recepient id", recepientId);
    	assertNotNullOrEmpty("subject", subject);
    	assertNotNullOrEmpty("message", message);
    	assertNotNullOrEmpty("auth header", authHeader);
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_INVITE_ID_PERSON_PATH).withField("id", recepientId).buildUrl());

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipient().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);
        String[] authTuple = authHeader.split(":");
        if (authTuple.length == 2) {
            Authorization authorization = OBJECT_FACTORY.createAuthorization();
            authorization.setName(authTuple[0]);
            authorization.setValue(authTuple[1]);
            request.setAuthorization(authorization);
        }
        invite.getItemContent().setInvitationRequest(request);
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInviteToPerson(Person recepient, String subject, String message) {
    	assertNotNull("recepient", recepient);
    	assertNotNull("recepient api request", recepient.getApiStandardProfileRequest());
    	String authHeader = null; 
    	if (recepient.getApiStandardProfileRequest().getHeaders() != null) {
    		for (HttpHeader header : recepient.getApiStandardProfileRequest().getHeaders().getHttpHeader()) {
    			if (ApplicationConstants.AUTH_HEADER_NAME.equals(header.getName())) {
    				authHeader = header.getValue();
    				break;
    			}
    		}
    	}
    	
    	sendInviteById(recepient.getId(), subject, message, authHeader);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(List<String> recepientIds, String subject, String message) {
    	assertNotNullOrEmpty("recepient ids", recepientIds);
    	assertNotNullOrEmpty("subject", subject);
    	assertNotNullOrEmpty("message", message);
    	
        LinkedInApiUrlBuilder builder     = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl      = builder.buildUrl();
        MailboxItem           messageItem = OBJECT_FACTORY.createMailboxItem();

        messageItem.setBody(message);
        messageItem.setSubject(subject);
        messageItem.setRecipients(OBJECT_FACTORY.createRecipients());

        for (String recepientId : recepientIds) {
            Person person = OBJECT_FACTORY.createPerson();
            
            person.setPath(createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE_PERSON_PATH).withField("id", recepientId).buildUrl());

            Recipient recepient = OBJECT_FACTORY.createRecipient();

            recepient.setPerson(person);
            messageItem.getRecipients().getRecipient().add(recepient);
        }

        callApiMethod(apiUrl, marshallObject(messageItem), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentStatus(String statusText) {
    	if (isNullOrEmpty(statusText)) {
    		deleteCurrentStatus();
    	} else {
            LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
            String                apiUrl  = builder.buildUrl();
            Object                status  = OBJECT_FACTORY.createCurrentStatus(statusText);

            callApiMethod(apiUrl, marshallObject(status), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                          HttpURLConnection.HTTP_NO_CONTENT);
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCurrentStatus() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
        String                apiUrl  = builder.buildUrl();

        callApiMethod(apiUrl, null, null, HttpMethod.DELETE, HttpURLConnection.HTTP_NO_CONTENT);
    }

    /**
     * Method description
     *
     *
     *
     * @param is
     * @param <T>
     *
     * @return
     */
    protected <T> T readResponse(Class<T> clazz, InputStream is) {
        try {
            return unmarshallObject(clazz, is);
        } finally {
            closeStream(is);
        }
    }

    /**
     *
     *
     * @param apiUrl
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl) {
    	final List<HttpHeader> httpHeaders = Collections.emptyList();
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK, httpHeaders);
    }

    /**
     *
     *
     * @param apiUrl
     * @param httpHeaders
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, List<HttpHeader> httpHeaders) {
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK, httpHeaders);
    }
    
    /**
     *
     *
     * @param apiUrl
     * @param expected
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, int expected, List<HttpHeader> httpHeaders) {
        try {
            LinkedInOAuthService oAuthService =
                LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }

            if (ApplicationConstants.COMPRESS_CONTENTS) {
                request.setRequestProperty("Accept-Encoding", "gzip, deflate");
            }
            
            for (HttpHeader header : httpHeaders) {
                request.setRequestProperty(header.getName(), header.getValue());
            }
            
            oAuthService.signRequestWithToken(request, accessToken);
            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class, getWrappedInputStream(request.getErrorStream(), GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
            	return getWrappedInputStream(request.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     *
     *
     * @param apiUrl
     * @param xmlContent
     * @param contentType
     * @param method
     * @param expected
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType, HttpMethod method,
            int expected) {
        try {
            LinkedInOAuthService oAuthService =
                LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(apiConsumer.getConsumerKey(),
                    apiConsumer.getConsumerSecret());
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }

            if (ApplicationConstants.COMPRESS_CONTENTS) {
                request.setRequestProperty("Accept-Encoding", "gzip, deflate");
            }
            
            request.setRequestMethod(method.fieldName());
            request.setDoOutput(true);
            oAuthService.signRequestWithToken(request, accessToken);

            if (contentType != null) {
                request.setRequestProperty("Content-Type", contentType);
            }

            if (xmlContent != null) {
                PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));

                out.print(xmlContent);
                out.flush();
                out.close();
            }

            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class, getWrappedInputStream(request.getErrorStream(), GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
            	return getWrappedInputStream(request.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @param is
     *
     */
    protected void closeStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method description
     *
     * @return
     */
	protected LinkedInApiClientException createLinkedInApiClientException(Error error) {
		final String message = error.getMessage();
		final String errorCode = error.getErrorCode();
		final int statusCode = (error.getStatus() == null) ? 0 : error.getStatus().intValue();
		final Date timestamp = (error.getTimestamp() == null) ? new Date() : new Date(error.getTimestamp());
		return new LinkedInApiClientException(message, statusCode, errorCode, timestamp);
	}

    /**
     * Method description
     *
     * @return
     * @throws IOException 
     */
	protected InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}
	
    /**
     * Get property as long.
     */
	protected boolean isNullOrEmpty(String s) {
        return ((s == null) || s.length() == 0);
    }
    
    /**
     * 
     */
    protected void assertNotNullOrEmpty(String name, String value) {
    	if (isNullOrEmpty(value)) {
    		throw new IllegalArgumentException(name + " cannot be null or empty.");    		
    	}
    }
	
    /**
     * 
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
    	if ((value == null) || value.isEmpty()) {
    		throw new IllegalArgumentException(name + " cannot be null or empty.");    		
    	}
    }
    
    /**
     * 
     */
    protected void assertPositiveNumber(String name, int value) {
    	if (value < 0) {
    		throw new IllegalArgumentException(name + " cannot be less than zero.");    		
    	}
    }
    
    /**
     * 
     */
    protected void assertNotNull(String name, Object value) {
    	if (value == null) {
    		throw new IllegalArgumentException(name + " cannot be null.");    		
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
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected abstract String marshallObject(Object element);

    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected abstract LinkedInApiUrlBuilder createLinkedInApiUrlBuilder(String urlFormat);

    /**
     * Method description
     *
     * @return
     */
    protected abstract SchemaElementFactory<?> createObjectFactory();
}
