/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.code.linkedinapi.client.LinkedInApiClientException;
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
public class LinkedInApiJaxbClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final String JAXB_PACKAGE_NAME = "com.google.code.linkedinapi.schema";

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
    public Connections getConnectionsByEmail(String email, Set<ProfileField> profileFields) {

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
    public Connections getConnectionsById(String id) {

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
    public Connections getConnectionsById(String id, Set<ProfileField> profileFields) {

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
    public Connections getConnectionsByUrl(String url) {

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
    public Connections getConnectionsByUrl(String url, Set<ProfileField> profileFields) {

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
    public Connections getConnectionsForCurrentUser() {

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
    public Connections getConnectionsForCurrentUser(Set<ProfileField> profileFields) {

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
    public Network getNetworkUpdates() {

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
    public Network getNetworkUpdates(int start, int count) {

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
    public Network getNetworkUpdates(Date startDate, Date endDate) {

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
    public Network getNetworkUpdates(Set<NetworkUpdateType> updateTypes) {

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
    public Network getNetworkUpdates(int start, int count, Set<NetworkUpdateType> updateTypes) {

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
    public Network getNetworkUpdates(Date startDate, Date endDate, Set<NetworkUpdateType> updateTypes) {

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
    public Network getNetworkUpdates(int count, int start, Date startDate, Date endDate,
                                     Set<NetworkUpdateType> updateTypes) {

        // TODO Auto-generated method stub
        return null;
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

        // TODO Auto-generated method stub
        return null;
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

        // TODO Auto-generated method stub
        return null;
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

        // TODO Auto-generated method stub
        return null;
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
    public Person getProfileForCurrentUser() {

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
    public Person getProfileForCurrentUser(Set<ProfileField> profileFields) {

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
    public People searchPeople() {

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
    public People searchPeople(Map<SearchParameter, String> searchParameters) {

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
    public People searchPeople(int start, int count) {

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
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count) {

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
    public People searchPeople(SearchSortOrder sortOrder) {

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
    public People searchPeople(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder) {

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
    public People searchPeople(int start, int count, SearchSortOrder sortOrder) {

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
    public People searchPeople(Map<SearchParameter, String> searchParameters, int start, int count,
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
    public void updateCurrentStatus(String status) {

        // TODO Auto-generated method stub
    }

    /**
     * Method description
     *
     *
     */
    @Override
    public void deleteCurrentStatus() {

        // TODO Auto-generated method stub
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
    protected <T> T unmarshallObject(String xmlContent) {
        try {
            JAXBContext  jc = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
            Unmarshaller u  = jc.createUnmarshaller();

            return (T) u.unmarshal(new StringReader(xmlContent));
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
