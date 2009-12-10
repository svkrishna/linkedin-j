/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
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
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import com.google.code.linkedinapi.schema.ObjectFactory;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.UpdateComment;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class BaseLinkedInApiClient implements LinkedInApiClient {

    /** Field description */
    private static final String GZIP_ENCODING = "gzip";
    
    /** Field description */
    private LinkedInAccessToken accessToken;

    /** Field description */
    private LinkedInApiConsumer apiConsumer;
    
    /** Field description */
    private final ObjectFactory OBJECT_FACTORY = createObjectFactory();

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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("email", email).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id", id).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url", url).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField("url", url).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("email",
                                            email).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id",
                                            id).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url",
                                            url).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField("url", url).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Date startDate, Date endDate) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("after",
                                            String.valueOf(startDate.getTime())).withParameter("before",
                                                String.valueOf(endDate.getTime())).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameterEnumSet("type", updateTypes).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withFieldEnumSet("type",
                                                updateTypes).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("after",
                                            String.valueOf(startDate.getTime())).withParameter("before",
                                                String.valueOf(endDate.getTime())).withParameterEnumSet("type",
                                                    updateTypes).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int count, int start, Date startDate,
                                     Date endDate) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  =
            builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                  String.valueOf(count)).withParameter("after",
                                      String.valueOf(startDate.getTime())).withParameter("before",
                                          String.valueOf(endDate.getTime())).withParameterEnumSet("type",
                                              updateTypes).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id",
                                            id).withFieldEnum("profileType", profileType).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnum("profileType",
                                            profileType).withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url",
                                            url).withFieldEnum("profileType", profileType).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withField("url", url).withFieldEnum("profileType",
                                            profileType).withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withEmptyField("profileFields").buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postComment(String networkUpdateId, String commentText) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_COMMENT);
        String                apiUrl  = builder.withField("updateKey", networkUpdateId).buildUrl();
        UpdateComment         comment = OBJECT_FACTORY.createUpdateComment();

        comment.setComment(commentText);

        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(comment),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

        if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postNetworkUpdate(String updateText) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_UPDATE);
        String                apiUrl  = builder.buildUrl();
        Activity              update  = OBJECT_FACTORY.createActivity();

        update.setBody(updateText);
        update.setLocale(Locale.getDefault().toString());
        update.setContentType(NetworkUpdateContentType.LINKED_IN_HTML);
        update.setTimestamp(BigInteger.valueOf(System.currentTimeMillis()));

        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(update),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

        if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople() {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnumMap(searchParameters).withParameter("start",
                                            String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(SearchSortOrder sortOrder) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnum("sortCriteria", sortOrder).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withParameterEnumMap(searchParameters).withParameterEnum("sortCriteria", sortOrder).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count, SearchSortOrder sortOrder) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withParameterEnum("sortCriteria",
                                                sortOrder).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  =
            builder.withParameterEnumMap(searchParameters).withParameterEnum("sortCriteria",
                                         sortOrder).withParameter("start",
                                             String.valueOf(start)).withParameter("count",
                                                 String.valueOf(count)).buildUrl();

        return readResponse(callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setId(recepientId);

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipient().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);
        invite.getItemContent().setInvitationRequest(request);

        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

        if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendInvite(String recepientId, String subject, String message, Authorization auth) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl  = builder.buildUrl();
        MailboxItem           invite  = OBJECT_FACTORY.createMailboxItem();

        invite.setBody(message);
        invite.setSubject(subject);
        invite.setRecipients(OBJECT_FACTORY.createRecipients());

        Person person = OBJECT_FACTORY.createPerson();

        person.setId(recepientId);

        Recipient recepient = OBJECT_FACTORY.createRecipient();

        recepient.setPerson(person);
        invite.getRecipients().getRecipient().add(recepient);
        invite.setItemContent(OBJECT_FACTORY.createItemContent());

        InvitationRequest request = OBJECT_FACTORY.createInvitationRequest();

        request.setConnectType(InviteConnectType.FRIEND);
        request.setAuthorization(auth);
        invite.getItemContent().setInvitationRequest(request);

        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(invite),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

        if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(List<String> recepientIds, String subject, String message) {
        LinkedInApiUrlBuilder builder     = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEND_MESSAGE);
        String                apiUrl      = builder.buildUrl();
        MailboxItem           messageItem = OBJECT_FACTORY.createMailboxItem();

        messageItem.setBody(message);
        messageItem.setSubject(subject);
        messageItem.setRecipients(OBJECT_FACTORY.createRecipients());

        for (String recepientId : recepientIds) {
            Person person = OBJECT_FACTORY.createPerson();

            person.setPath("/people/" + recepientId);

            Recipient recepient = OBJECT_FACTORY.createRecipient();

            recepient.setPerson(person);
            messageItem.getRecipients().getRecipient().add(recepient);
        }

        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(messageItem),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST);

        if (response.getStatusCode() != HttpURLConnection.HTTP_CREATED) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentStatus(String statusText) {
        LinkedInApiUrlBuilder   builder  = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
        String                  apiUrl   = builder.buildUrl();
        Object                  status   = OBJECT_FACTORY.createCurrentStatus(statusText);
        LinkedInApiCallResponse response = callApiMethod(apiUrl, marshallObject(status),
                                               ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT);

        if (response.getStatusCode() != HttpURLConnection.HTTP_NO_CONTENT) {
            throw new LinkedInApiClientException(convertStreamToString(response.getResponseContent()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCurrentStatus() {
        LinkedInApiUrlBuilder   builder  = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
        String                  apiUrl   = builder.buildUrl();
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
     *
     *
     * @param apiUrl
     *
     * @return
     */
    protected LinkedInApiCallResponse callApiMethod(String apiUrl) {
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

            oAuthService.signRequestWithToken(request, accessToken);
            request.connect();
            
            if (GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())) { 
                return new LinkedInApiCallResponse(request.getResponseCode(), new GZIPInputStream(request.getInputStream()));
            } else {
                return new LinkedInApiCallResponse(request.getResponseCode(), request.getInputStream());
            }
        } catch (Exception e) {
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
     *
     * @return
     */
    protected LinkedInApiCallResponse callApiMethod(String apiUrl, String xmlContent, String contentType,
            HttpMethod method) {
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

            request.setRequestMethod(method.fieldName());
            request.setDoOutput(true);
            oAuthService.signRequestWithToken(request, accessToken);

            if (contentType != null) {
                request.setRequestProperty("Content-Type", contentType);
            }

            if (xmlContent != null) {
                PrintStream out = new PrintStream(request.getOutputStream());

                out.print(xmlContent);
                out.flush();
                out.close();
            }

            request.connect();

            return new LinkedInApiCallResponse(request.getResponseCode(), request.getInputStream());
        } catch (Exception e) {
            throw new LinkedInApiClientException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @param is
     *
     * @return
     */
    protected String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder  sb     = new StringBuilder();
        String         line   = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	closeStream(is);
        }

        return sb.toString();
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
     *
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    protected abstract <T> T unmarshallObject(InputStream xmlContent);
    
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
    protected abstract ObjectFactory createObjectFactory();
    	
    /**
     * Class description
     *
     *
     */
    protected static class LinkedInApiCallResponse {

        /** Field description */
        private InputStream responseContent;

        /** Field description */
        private String responseMessage;

        /** Field description */
        private int statusCode;

        /**
         * Constructs ...
         *
         *
         * @param statusCode
         * @param responseContent
         */
        public LinkedInApiCallResponse(int statusCode, InputStream responseContent) {
            this.statusCode      = statusCode;
            this.responseContent = responseContent;
        }

        /**
         * @return the statusCode
         */
        public int getStatusCode() {
            return statusCode;
        }

        /**
         * @param statusCode the statusCode to set
         */
        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        /**
         * @return the responseContent
         */
        public InputStream getResponseContent() {
            return responseContent;
        }

        /**
         * @param responseContent the responseContent to set
         */
        public void setResponseContent(InputStream responseContent) {
            this.responseContent = responseContent;
        }

        /**
         * @return the responseMessage
         */
        public String getResponseMessage() {
            return responseMessage;
        }

        /**
         * @param responseMessage the responseMessage to set
         */
        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }
    }
}
