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
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

/**
 * The Interface LinkedInApiClient. It acts as a facade for the whole LinkedIn API.
 * 
 * @author Nabeel Mukhtar
 */
public interface LinkedInApiClient extends LinkedInAuthenticationClient {

    // Profile API. Return Profile bean

    /**
     * Gets the profile for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @return the profile for current user
     */
    public Person getProfileForCurrentUser();

    /**
     * Gets the profile by id.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @param id the id
     * @param profileType the profile type
     * 
     * @return the profile by id
     */
    public Person getProfileById(String id, ProfileType profileType);

    /**
     * Gets the profile by url.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @param url the url
     * @param profileType the profile type
     * 
     * @return the profile by url
     */
    public Person getProfileByUrl(String url, ProfileType profileType);

    /**
     * Gets the profile for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @param profileFields the profile fields
     * 
     * @return the profile for current user
     */
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Gets the profile by id.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @param id the id
     * @param profileType the profile type
     * @param profileFields the profile fields
     * 
     * @return the profile by id
     */
    public Person getProfileById(String id, ProfileType profileType, Set<ProfileField> profileFields);

    /**
     * Gets the profile by url.
     * {@see http://developer.linkedin.com/docs/DOC-1002}
     * 
     * @param url the url
     * @param profileType the profile type
     * @param profileFields the profile fields
     * 
     * @return the profile by url
     */
    public Person getProfileByUrl(String url, ProfileType profileType, Set<ProfileField> profileFields);

    // Network Updates API. Return Network Update bean

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates();

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(int start, int count);

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param updateTypes the update types
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes);

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param updateTypes the update types
     * @param start the start
     * @param count the count
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int start, int count);

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param updateTypes the update types
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, Date startDate, Date endDate);

    /**
     * Gets the network updates.
     * {@see http://developer.linkedin.com/docs/DOC-1006}
     * 
     * @param updateTypes the update types
     * @param count the count
     * @param start the start
     * @param startDate the start date
     * @param endDate the end date
     * 
     * @return the network updates
     */
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes, int count, int start, Date startDate,
                                     Date endDate);

    // Connections API

    /**
     * Gets the connections for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser();

    /**
     * Gets the connections by id.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param id the id
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id);

    /**
     * Gets the connections by email.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param email the email
     * 
     * @return the connections by email
     */
    public Connections getConnectionsByEmail(String email);

    /**
     * Gets the connections by url.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param url the url
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url);

    /**
     * Gets the connections for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param profileFields the profile fields
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields);

    /**
     * Gets the connections by id.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param id the id
     * @param profileFields the profile fields
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields);

    /**
     * Gets the connections by email.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param email the email
     * @param profileFields the profile fields
     * 
     * @return the connections by email
     */
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields);

    /**
     * Gets the connections by url.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param url the url
     * @param profileFields the profile fields
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields);

    // Connections API with Paging

    /**
     * Gets the connections for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(int start, int count);

    /**
     * Gets the connections by id.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param id the id
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, int start, int count);

    /**
     * Gets the connections by email.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param email the email
     * @param start the start
     * @param count the count
     * 
     * @return the connections by email
     */
    public Connections getConnectionsByEmail(String email, int start, int count);

    /**
     * Gets the connections by url.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param url the url
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, int start, int count);

    /**
     * Gets the connections for current user.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections for current user
     */
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by id.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param id the id
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by id
     */
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by email.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param email the email
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by email
     */
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields, int start, int count);

    /**
     * Gets the connections by url.
     * {@see http://developer.linkedin.com/docs/DOC-1004}
     * 
     * @param url the url
     * @param profileFields the profile fields
     * @param start the start
     * @param count the count
     * 
     * @return the connections by url
     */
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields, int start, int count);

    // Search API

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @return the people
     */
    public People searchPeople();

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param searchParameters the search parameters
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(int start, int count);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(SearchSortOrder sortOrder);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(int start, int count, SearchSortOrder sortOrder);

    /**
     * Search people.
     * {@see http://developer.linkedin.com/docs/DOC-1005}
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the people
     */
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    // Post Network Update API

    /**
     * Post network update.
     * {@see http://developer.linkedin.com/docs/DOC-1009}
     * 
     * @param updateText the update text
     */
    public void postNetworkUpdate(String updateText);

    // Post Comment API

    /**
     * Post comment.
     * {@see http://developer.linkedin.com/docs/DOC-1009}
     * 
     * @param networkUpdateId the network update id
     * @param commentText the comment text
     */
    public void postComment(String networkUpdateId, String commentText);

    // Status Update API

    /**
     * Update current status.
     * {@see http://developer.linkedin.com/docs/DOC-1007}
     * 
     * @param status the status
     */
    public void updateCurrentStatus(String status);

    /**
     * Delete current status.
     * {@see http://developer.linkedin.com/docs/DOC-1007}
     */
    public void deleteCurrentStatus();

    // Messaging API

    /**
     * Send message.
     * {@see http://developer.linkedin.com/docs/DOC-1044}
     * 
     * @param recepientIds the recepient ids
     * @param subject the subject
     * @param message the message
     */
    public void sendMessage(List<String> recepientIds, String subject, String message);

    // Invitation API

    /**
     * Send invite.
     * {@see http://developer.linkedin.com/docs/DOC-1012}
     * 
     * @param recepientId the recepient id
     * @param subject the subject
     * @param message the message
     */
    public void sendInvite(String recepientId, String subject, String message);

    /**
     * Send invite.
     * {@see http://developer.linkedin.com/docs/DOC-1012}
     * 
     * @param recepientId the recepient id
     * @param subject the subject
     * @param message the message
     * @param auth the auth
     */
    public void sendInvite(String recepientId, String subject, String message, Authorization auth);
}
