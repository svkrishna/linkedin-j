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
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComments;

/**
 * @author Nabeel Mukhtar
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
     * {@inheritDoc}
     */
//    @Override
//    public Future<Connections> getConnectionsByEmail(final String email) {
//        return execute(new Callable<Connections>() {
//            @Override
//            public Connections call() throws Exception {
//                return client.getConnectionsByEmail(email);
//            }
//        });
//    }

    /**
     * {@inheritDoc}
     */
//    @Override
//    public Future<Connections> getConnectionsByEmail(final String email, final Set<ProfileField> profileFields) {
//        return execute(new Callable<Connections>() {
//            @Override
//            public Connections call() throws Exception {
//                return client.getConnectionsByEmail(email, profileFields);
//            }
//        });
//    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
//    @Override
//    public Future<Connections> getConnectionsByEmail(final String email, final int start, final int count) {
//        return execute(new Callable<Connections>() {
//            @Override
//            public Connections call() throws Exception {
//                return client.getConnectionsByEmail(email, start, count);
//            }
//        });
//    }

    /**
     * {@inheritDoc}
     */
//    @Override
//    public Future<Connections> getConnectionsByEmail(final String email, final Set<ProfileField> profileFields, final int start, final int count) {
//        return execute(new Callable<Connections>() {
//            @Override
//            public Connections call() throws Exception {
//                return client.getConnectionsByEmail(email, profileFields, start, count);
//            }
//        });
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id, final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsById(final String id, final Set<ProfileField> profileFields, final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsById(id, profileFields, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url, final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsByUrl(final String url, final Set<ProfileField> profileFields, final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsByUrl(url, profileFields, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser(final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser(final Set<ProfileField> profileFields, final int start, final int count) {
        return execute(new Callable<Connections>() {
            @Override
            public Connections call() throws Exception {
                return client.getConnectionsForCurrentUser(profileFields, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, start, count);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final Date startDate, final Date endDate) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, startDate, endDate);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Network> getNetworkUpdates(final Set<NetworkUpdateType> updateTypes, final int start, final int count, final Date startDate,
            final Date endDate) {
        return execute(new Callable<Network>() {
            @Override
            public Network call() throws Exception {
                return client.getNetworkUpdates(updateTypes, start, count, startDate, endDate);
            }
        });
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<UpdateComments> getNetworkUpdateComments(final String networkUpdateId) {
        return execute(new Callable<UpdateComments>() {
            @Override
            public UpdateComments call() throws Exception {
                return client.getNetworkUpdateComments(networkUpdateId);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id, final ProfileType profileType) {
        return execute(new Callable<Person>() {
            @SuppressWarnings("deprecation")
			@Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileType);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id);
            }
        });
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id, final ProfileType profileType, final Set<ProfileField> profileFields) {
        return execute(new Callable<Person>() {
            @SuppressWarnings("deprecation")
			@Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileType, profileFields);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileById(final String id, final Set<ProfileField> profileFields) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileById(id, profileFields);
            }
        });
    }
    
    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public Future<Person> getProfileByApiRequest(final ApiStandardProfileRequest apiRequest) {
        return execute(new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return client.getProfileByApiRequest(apiRequest);
            }
        });
    }
    
    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public Future<?> sendInviteByEmail(final String email, final String firstName, final String lastName, final String subject, final String message) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.sendInviteByEmail(email, firstName, lastName, subject, message);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Future<?> sendInviteById(final String recepientId, final String subject, final String message, final String authHeader) {
        return execute(new Runnable() {
            @Override
            public void run() {
                client.sendInviteById(recepientId, subject, message, authHeader);
            }
        });
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public LinkedInAccessToken getAccessToken() {
        return client.getAccessToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedInApiConsumer getApiConsumer() {
        return client.getApiConsumer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccessToken(LinkedInAccessToken accessToken) {
    	client.setAccessToken(accessToken);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {
    	client.setApiConsumer(apiConsumer);
    }
}
