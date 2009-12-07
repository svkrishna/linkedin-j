/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
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
public interface AsyncLinkedInApiClient extends LinkedInAuthenticationClient {

    // Profile API. Return Profile bean

    /**
     * Method description
     *
     *
     * @return
     */
    public Future<Person> getProfileForCurrentUser();

    /**
     * Method description
     *
     *
     * @param id
     * @param profileType
     *
     * @return
     */
    public Future<Person> getProfileById(String id, ProfileType profileType);

    /**
     * Method description
     *
     *
     * @param url
     * @param profileType
     *
     * @return
     */
    public Future<Person> getProfileByUrl(String url, ProfileType profileType);

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    public Future<Person> getProfileForCurrentUser(Set<ProfileField> profileFields);

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
    public Future<Person> getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields);

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
    public Future<Person> getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields);

    // Network Updates API. Return Network Update bean

    /**
     * Method description
     *
     *
     * @return
     */
    public Future<Network> getNetworkUpdates();

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(int start, int count);

    /**
     * Method description
     *
     *
     * @param startDate
     * @param endDate
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(Date startDate, Date endDate);

    /**
     * Method description
     *
     *
     * @param updateTypes
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes);

    /**
     * Method description
     * @param updateTypes
     * @param start
     * @param count
     *
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count);

    /**
     * Method description
     * @param updateTypes
     * @param startDate
     * @param endDate
     *
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

    /**
     * Method description
     * @param updateTypes
     * @param count
     * @param start
     * @param startDate
     * @param endDate
     *
     *
     * @return
     */
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int count, int start, Date startDate,
                                     Date endDate);

    // Connections API

    /**
     * Method description
     *
     *
     * @return
     */
    public Future<Connections> getConnectionsForCurrentUser();

    /**
     * Method description
     *
     *
     * @param id
     *
     * @return
     */
    public Future<Connections> getConnectionsById(String id);

    /**
     * Method description
     *
     *
     * @param email
     *
     * @return
     */
    public Future<Connections> getConnectionsByEmail(String email);

    /**
     * Method description
     *
     *
     * @param url
     *
     * @return
     */
    public Future<Connections> getConnectionsByUrl(String url);

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param id
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsById(String id, Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param email
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields);

    /**
     * Method description
     *
     *
     * @param url
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsByUrl(String url, Set<ProfileField> profileFields);

    // Connections API with Paging

    /**
     * Method description
     *
     *
     * @return
     */
    public Future<Connections> getConnectionsForCurrentUser(int start, int count);

    /**
     * Method description
     *
     *
     * @param id
     *
     * @return
     */
    public Future<Connections> getConnectionsById(String id, int start, int count);

    /**
     * Method description
     *
     *
     * @param email
     *
     * @return
     */
    public Future<Connections> getConnectionsByEmail(String email, int start, int count);

    /**
     * Method description
     *
     *
     * @param url
     *
     * @return
     */
    public Future<Connections> getConnectionsByUrl(String url, int start, int count);

    /**
     * Method description
     *
     *
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count);

    /**
     * Method description
     *
     *
     * @param id
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count);

    /**
     * Method description
     *
     *
     * @param email
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count);

    /**
     * Method description
     *
     *
     * @param url
     * @param profileFields
     *
     * @return
     */
    public Future<Connections> getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count);

    // Search API

    /**
     * Method description
     *
     *
     * @return
     */
    public Future<People> searchPeople();

    /**
     * Method description
     *
     *
     * @param searchParameters
     *
     * @return
     */
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters);

    /**
     * Method description
     *
     *
     * @param start
     * @param count
     *
     * @return
     */
    public Future<People> searchPeople(int start, int count);

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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Method description
     *
     *
     * @param sortOrder
     *
     * @return
     */
    public Future<People> searchPeople(SearchSortOrder sortOrder);

    /**
     * Method description
     *
     *
     * @param searchParameters
     * @param sortOrder
     *
     * @return
     */
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

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
    public Future<People> searchPeople(int start, int count, SearchSortOrder sortOrder);

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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    // Post Network Update API

    /**
     * Method description
     *
     *
     * @param updateText
     */
    public Future<?> postNetworkUpdate(String updateText);

    // Post Comment API

    /**
     * Method description
     *
     *
     * @param networkUpdateId
     * @param commentText
     */
    public Future<?> postComment(String networkUpdateId, String commentText);

    // Status Update API

    /**
     * Method description
     *
     *
     * @param status
     */
    public Future<?> updateCurrentStatus(String status);

    /**
     * Method description
     *
     *
     * @param status
     */
    public Future<?> deleteCurrentStatus();

    // Messaging API

    /**
     * Method description
     *
     *
     * @param recepientIds
     * @param subject
     * @param message
     */
    public Future<?> sendMessage(List<String> recepientIds, String subject, String message);

    // Invitation API

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     */
    public Future<?> sendInvite(String recepientId, String subject, String message);

    /**
     * Method description
     *
     *
     * @param recepientId
     * @param subject
     * @param message
     * @param auth
     */
    public Future<?> sendInvite(String recepientId, String subject, String message, Authorization auth);

}
