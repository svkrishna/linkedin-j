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
import com.google.code.linkedinapi.schema.Error;
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

    /**
     * {@inheritDoc}
     */
//    @Override
    public Connections getConnectionsByEmail(String email) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("email", email).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
//    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
                                            profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id", id).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url", url).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_URL);
        String                apiUrl  = builder.withField("url", url).withFieldEnumSet("profileFields",
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
//    @Override
    public Connections getConnectionsByEmail(String email, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("email",
                                            email).withParameter("start", String.valueOf(start)).withParameter("count",
                                                String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
//    @Override
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_CONNECTIONS_BY_EMAIL);
        String                apiUrl  = builder.withField("email", email).withFieldEnumSet("profileFields",
                                            profileFields).withParameter("start",
                                                String.valueOf(start)).withParameter("count",
                                                    String.valueOf(count)).buildUrl();

        return readResponse(Connections.class, callApiMethod(apiUrl));
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

        return readResponse(Connections.class, callApiMethod(apiUrl));
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

        return readResponse(Connections.class, callApiMethod(apiUrl));
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

        return readResponse(Connections.class, callApiMethod(apiUrl));
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

        return readResponse(Connections.class, callApiMethod(apiUrl));
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

        return readResponse(Connections.class, callApiMethod(apiUrl));
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameterEnumSet("type", updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.NETWORK_UPDATES);
        String                apiUrl  = builder.withParameter("start", String.valueOf(start)).withParameter("count",
                                            String.valueOf(count)).withFieldEnumSet("type", updateTypes).buildUrl();

        return readResponse(Network.class, callApiMethod(apiUrl));
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

        return readResponse(Network.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int count, int start, Date startDate,
                                     Date endDate) {
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
    public Person getProfileById(String id, ProfileType profileType) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("id",
                                            id).withFieldEnum("profileType", profileType).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_ID);
        String                apiUrl  = builder.withField("id", id).withFieldEnum("profileType",
                                            profileType).withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withEmptyField("profileFields").withField("url",
                                            url).withFieldEnum("profileType", profileType).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_BY_URL);
        String                apiUrl  = builder.withField("url", url).withFieldEnum("profileType",
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.GET_PROFILE_FOR_CURRENT_USER);
        String                apiUrl  = builder.withFieldEnumSet("profileFields", profileFields).buildUrl();

        return readResponse(Person.class, callApiMethod(apiUrl));
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
        callApiMethod(apiUrl, marshallObject(comment), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnumMap(searchParameters).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(int start, int count) {
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
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.SEARCH_PEOPLE);
        String                apiUrl  = builder.withParameterEnum("sortCriteria", sortOrder).buildUrl();

        return readResponse(People.class, callApiMethod(apiUrl));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {
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
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
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
        callApiMethod(apiUrl, marshallObject(invite), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
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

        callApiMethod(apiUrl, marshallObject(messageItem), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_CREATED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentStatus(String statusText) {
        LinkedInApiUrlBuilder builder = createLinkedInApiUrlBuilder(LinkedInApiUrls.POST_STATUS);
        String                apiUrl  = builder.buildUrl();
        Object                status  = OBJECT_FACTORY.createCurrentStatus(statusText);

        callApiMethod(apiUrl, marshallObject(status), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.PUT,
                      HttpURLConnection.HTTP_NO_CONTENT);
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
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK);
    }

    /**
     *
     *
     * @param apiUrl
     * @param expected
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, int expected) {
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
