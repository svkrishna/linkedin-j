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
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.AsyncLinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.enumeration.NetworkUpdateType;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
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
public class AsyncLinkedInApiJaxbClient implements AsyncLinkedInApiClient {

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
    public AsyncLinkedInApiJaxbClient(LinkedInApiClient client) {
        this.client  = client;
        taskExecutor = Executors.newCachedThreadPool();
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
    public Future<Connections> getConnectionsByEmail(String email) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsByEmail(String email, Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsById(String id) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsById(String id, Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsByUrl(String url) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsByUrl(String url, Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Connections> getConnectionsForCurrentUser() {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Connections> getConnectionsForCurrentUser(Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Network> getNetworkUpdates() {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(int start, int count) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(Date startDate, Date endDate) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(int start, int count, Set<NetworkUpdateType> updateTypes) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(Date startDate, Date endDate, Set<NetworkUpdateType> updateTypes) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Network> getNetworkUpdates(int count, int start, Date startDate, Date endDate,
            Set<NetworkUpdateType> updateTypes) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Person> getProfileById(String id) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Person> getProfileById(String id, Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Person> getProfileByUrl(String url) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Person> getProfileByUrl(String url, Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<Person> getProfileForCurrentUser() {

        // TODO Auto-generated method stub
        return null;
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
    public Future<Person> getProfileForCurrentUser(Set<ProfileField> profileFields) {

        // TODO Auto-generated method stub
        return null;
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

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     * @param updateText
     */
    @Override
    public void postNetworkUpdate(String updateText) {

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public Future<People> searchPeople() {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(int start, int count) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(SearchSortOrder sortOrder) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(int start, int count, SearchSortOrder sortOrder) {

        // TODO Auto-generated method stub
        return null;
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
    public Future<People> searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
                                       SearchSortOrder sortOrder) {

        // TODO Auto-generated method stub
        return null;
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

        // TODO Auto-generated method stub
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

        // TODO Auto-generated method stub
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

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     * @param status
     */
    @Override
    public void updateStatus(String status) {

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public LinkedInAccessToken getAccessToken() {

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public LinkedInApiConsumer getApiConsumer() {

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method description
     *
     *
     * @param accessToken
     */
    @Override
    public void setAccessToken(LinkedInAccessToken accessToken) {

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     * @param apiConsumer
     */
    @Override
    public void setApiConsumer(LinkedInApiConsumer apiConsumer) {

        // TODO Auto-generated method stub
    }
}
