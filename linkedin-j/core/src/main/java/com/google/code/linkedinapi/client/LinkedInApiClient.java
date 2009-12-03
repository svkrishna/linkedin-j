/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

/**
 * @author nmukhtar
 *
 */
public interface LinkedInApiClient extends LinkedInAuthenticationClient {

    // Profile API. Return Profile bean

    /**
     * Method description
     *
     *
     * @return
     */
    public Person getProfileForCurrentUser();

    /**
     * Method description
     *
     *
     * @param id
     *
     * @return
     */
    public Person getProfileById(String id);

    /**
     * Method description
     *
     *
     * @param url
     *
     * @return
     */
    public Person getProfileByUrl(String url);

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param id
     * @param profileFields
     *
     * @return
     */
    public Person getProfileById(String id, Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param url
     * @param profileFields
     *
     * @return
     */
    public Person getProfileByUrl(String url, Set<ProfileField> profileFields);

    // Network Updates API. Return Network Update bean

    /**
     * Method description
     *
     *
     * @return
     */
    public Network getNetworkUpdates();

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    public Network getNetworkUpdates(int start, int count);

    /**
     * Method description
     *
     *
     * @param startDate
     * @param endDate
     *
     * @return
     */
    public Network getNetworkUpdates(Date startDate, Date endDate);

    /**
     * Method description
     *
     *
     * @param updateTypes
     *
     * @return
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes);

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
    public Network getNetworkUpdates(int start, int count, Set<NetworkUpdateType> updateTypes);

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
    public Network getNetworkUpdates(Date startDate, Date endDate, Set<NetworkUpdateType> updateTypes);

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
    public Network getNetworkUpdates(int count, int start, Date startDate, Date endDate,
                                     Set<NetworkUpdateType> updateTypes);

    // Connections API

    /**
     * Method description
     *
     *
     * @return
     */
    public Connections getConnectionsForCurrentUser();

    /**
     * Method description
     *
     *
     * @param id
     *
     * @return
     */
    public Connections getConnectionsById(String id);

    /**
     * Method description
     *
     *
     * @param email
     *
     * @return
     */
    public Connections getConnectionsByEmail(String email);

    /**
     * Method description
     *
     *
     * @param url
     *
     * @return
     */
    public Connections getConnectionsByUrl(String url);

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param id
     * @param profileFields
     *
     * @return
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param email
     * @param profileFields
     *
     * @return
     */
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param url
     * @param profileFields
     *
     * @return
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields);

    // Search API

    /**
     * Method description
     *
     *
     * @return
     */
    public People searchPeople();

    /**
     * Method description
     *
     *
     * @param searchParameters
     *
     * @return
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters);

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    public People searchPeople(int start, int count);

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
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Method description
     *
     *
     * @param sortOrder
     *
     * @return
     */
    public People searchPeople(SearchSortOrder sortOrder);

    /**
     * Method description
     *
     *
     * @param searchParameters
     * @param sortOrder
     *
     * @return
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

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
    public People searchPeople(int start, int count, SearchSortOrder sortOrder);

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
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    // Post Network Update API

    /**
     * Method description
     *
     *
     * @param updateText
     */
    public void postNetworkUpdate(String updateText);

    // Post Comment API

    /**
     * Method description
     *
     *
     * @param networkUpdateId
     * @param commentText
     */
    public void postComment(String networkUpdateId, String commentText);

    // Status Update API

    /**
     * Method description
     *
     *
     * @param status
     */
    public void updateStatus(String status);

    // Messaging API

    /**
     * Method description
     *
     *
     * @param recepientIds
     * @param subject
     * @param message
     */
    public void sendMessage(List<String> recepientIds, String subject, String message);

    // Invitation API

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     */
    public void sendInvite(String recepientId, String subject, String message);

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     * @param auth
     */
    public void sendInvite(String recepientId, String subject, String message, Authorization auth);
}
