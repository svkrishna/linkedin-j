/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.AsyncLinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInApiConsumer;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

/**
 * @author nmukhtar
 *
 */
public class AsyncLinkedInApiClientAdapter implements AsyncLinkedInApiClient {

    /** Field description */
    private LinkedInApiClient client;

    /** Field description */
    private ExecutorService taskExecutor;

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncLinkedInApiClientAdapter(LinkedInApiClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Method description
     *
     *
     * @param task
     *
     * @return
     */
    protected Future<?> execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Method description
     *
     *
     * @param task
     * @param <T>
     *
     * @return
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
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
    public Future<Connections> getConnectionsByEmail(final String email) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByEmail(email);
            }
        });
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
    public Future<Connections> getConnectionsByEmail(final String email, final Set<ProfileField> profileFields) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByEmail(email, profileFields);
            }
        });
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
    public Future<Connections> getConnectionsById(final String id) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id);
            }
        });
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
    public Future<Connections> getConnectionsById(final String id, final Set<ProfileField> profileFields) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, profileFields);
            }
        });
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
    public Future<Connections> getConnectionsByUrl(final String url) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url);
            }
        });
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
    public Future<Connections> getConnectionsByUrl(final String url, final Set<ProfileField> profileFields) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, profileFields);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser() {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser();
            }
        });
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
    public Future<Connections> getConnectionsForCurrentUser(final Set<ProfileField> profileFields) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(profileFields);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Network> getNetworkUpdates() {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates();
            }
        });
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
    public Future<Network> getNetworkUpdates(final int start, final int count) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(start, count);
            }
        });
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
    public Future<Network> getNetworkUpdates(final Date startDate, final Date endDate) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(startDate, endDate);
            }
        });
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
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes);
            }
        });
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
    public Future<Network> getNetworkUpdates(final int start, final int count, final Set<NetworkUpdateType> updateTypes) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(start, count, updateTypes);
            }
        });
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
    public Future<Network> getNetworkUpdates(final Date startDate, final Date endDate, final Set<NetworkUpdateType> updateTypes) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(startDate, endDate, updateTypes);
            }
        });
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
    public Future<Network> getNetworkUpdates(final int count, final int start, final Date startDate, final Date endDate,
            final Set<NetworkUpdateType> updateTypes) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(count, start, startDate, endDate, updateTypes);
            }
        });
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
    public Future<Person> getProfileById(final String id, final ProfileType profileType) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileType);
            }
        });
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
    public Future<Person> getProfileById(final String id, final ProfileType profileType, final Set<ProfileField> profileFields) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileType, profileFields);
            }
        });
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
    public Future<Person> getProfileByUrl(final String url, final ProfileType profileType) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByUrl(url, profileType);
            }
        });
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
    public Future<Person> getProfileByUrl(final String url, final ProfileType profileType, final Set<ProfileField> profileFields) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByUrl(url, profileType, profileFields);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Person> getProfileForCurrentUser() {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileForCurrentUser();
            }
        });
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
    public Future<Person> getProfileForCurrentUser(final Set<ProfileField> profileFields) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileForCurrentUser(profileFields);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @param networkUpdateId
     * @param commentText
     */
    @Override
    public Future<?> postComment(final String networkUpdateId, final String commentText) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.postComment(networkUpdateId, commentText);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @param updateText
     */
    @Override
    public Future<?> postNetworkUpdate(final String updateText) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.postNetworkUpdate(updateText);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<People> searchPeople() {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople();
            }
        });
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
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters);
            }
        });
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
    public Future<People> searchPeople(final int start, final int count) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(start, count);
            }
        });
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
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, start, count);
            }
        });
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
    public Future<People> searchPeople(final SearchSortOrder sortOrder) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(sortOrder);
            }
        });
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
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final SearchSortOrder sortOrder) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, sortOrder);
            }
        });
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
    public Future<People> searchPeople(final int start, final int count, final SearchSortOrder sortOrder) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(start, count, sortOrder);
            }
        });
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
    public Future<People> searchPeople(final Map<SearchParameter, String> searchParameters, final int start, final int count,
                                       final SearchSortOrder sortOrder) {
        return execute(new Callable<People>() {
            @Override
            public People call() throws Exception {
                return client.searchPeople(searchParameters, start, count, sortOrder);
            }
        });
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
    public Future<?> sendInvite(final String recepientId, final String subject, final String message) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.sendInvite(recepientId, subject, message);
            }
        });
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
    public Future<?> sendInvite(final String recepientId, final String subject, final String message, final Authorization auth) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.sendInvite(recepientId, subject, message, auth);
            }
        });
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
    public Future<?> sendMessage(final List<String> recepientIds, final String subject, final String message) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.sendMessage(recepientIds, subject, message);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    @Override
    public Future<?> updateCurrentStatus(final String status) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.updateCurrentStatus(status);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    @Override
    public Future<?> deleteCurrentStatus() {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.deleteCurrentStatus();
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public LinkedInAccessToken getAccessToken() {
        return client.getAccessToken();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public LinkedInApiConsumer getApiConsumer() {
        return client.getApiConsumer();
    }

    /**
     * Method description
     *
     *
     * @param accessToken
     */
    @Override
    public void setAccessToken(LinkedInAccessToken accessToken) {
    	client.setAccessToken(accessToken);
    }

    /**
     * Method description
     *
     *
     * @param apiConsumer
     */
    @Override
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
    	client.setApiConsumer(apiConsumer);
    }
}
