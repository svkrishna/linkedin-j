/**
 *
 */
package com.google.code.linkedinapi.client.impl;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.SchemaEntity;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.xpp.ActivityImpl;
import com.google.code.linkedinapi.schema.xpp.BaseSchemaEntity;
import com.google.code.linkedinapi.schema.xpp.ConnectionsImpl;
import com.google.code.linkedinapi.schema.xpp.XppUtils;
import com.google.code.linkedinapi.schema.xpp.ErrorImpl;
import com.google.code.linkedinapi.schema.xpp.MailboxItemImpl;
import com.google.code.linkedinapi.schema.xpp.NetworkImpl;
import com.google.code.linkedinapi.schema.xpp.PeopleImpl;
import com.google.code.linkedinapi.schema.xpp.PersonImpl;
import com.google.code.linkedinapi.schema.xpp.UpdateCommentImpl;
import com.google.code.linkedinapi.schema.xpp.UpdateCommentsImpl;
import com.google.code.linkedinapi.schema.xpp.XppElementFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInApiXppClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final SchemaElementFactory<Element> OBJECT_FACTORY = new XppElementFactory();
    
    /** Field description */
	private static final Map<Class<? extends SchemaEntity>, Class<? extends BaseSchemaEntity>> DOM_CLASSES_MAP = new HashMap<Class<? extends SchemaEntity>, Class<? extends BaseSchemaEntity>>();
	
	static {
		DOM_CLASSES_MAP.put(Person.class, PersonImpl.class);
		DOM_CLASSES_MAP.put(Network.class, NetworkImpl.class);
		DOM_CLASSES_MAP.put(People.class, PeopleImpl.class);
		DOM_CLASSES_MAP.put(Connections.class, ConnectionsImpl.class);
		DOM_CLASSES_MAP.put(Error.class, ErrorImpl.class);
		DOM_CLASSES_MAP.put(MailboxItem.class, MailboxItemImpl.class);
		DOM_CLASSES_MAP.put(UpdateComment.class, UpdateCommentImpl.class);
		DOM_CLASSES_MAP.put(Activity.class, ActivityImpl.class);
		DOM_CLASSES_MAP.put(UpdateComments.class, UpdateCommentsImpl.class);
	}
	
    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiXppClient(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
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
    protected <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent) {
        try {
        	XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        	
        	BaseSchemaEntity entity = getSchemaEntityByClass(clazz);
        	
        	entity.init(parser);

            return (T) entity;
        } catch (Exception e) {
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
    	if (element instanceof Node) {
    		return XppUtils.domToString((Node) element);
    	} else if (element instanceof BaseSchemaEntity) {
    		try {
				XmlSerializer serializer = XmlPullParserFactory.newInstance().newSerializer();
				return ((BaseSchemaEntity) element).toXml(serializer);
			} catch (Exception e) {
	    		throw new LinkedInApiClientException("Unkown element encountered:" + element, e);
			}
    	} else {
    		throw new LinkedInApiClientException("Unkown element encountered:" + element);
    	}
    }

    /**
     * Method description
     *
     * @return
     */
    protected SchemaElementFactory<?> createObjectFactory() {
    	return OBJECT_FACTORY;
    }
    
    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected LinkedInApiUrlBuilder createLinkedInApiUrlBuilder(String urlFormat) {
        return new LinkedInApiUrlBuilder(urlFormat);
    }
    
    /**
     * Method description
     *
     */
    private BaseSchemaEntity getSchemaEntityByClass(Class<?> clazz) {
    	if (DOM_CLASSES_MAP.containsKey(clazz)) {
    		Class<? extends BaseSchemaEntity> implClass = DOM_CLASSES_MAP.get(clazz);
    		try {
				return implClass.newInstance();
			} catch (Exception e) {
	    		throw new LinkedInApiClientException("Could not instantiate class: " + implClass.getName(), e);
			}
    	} else {
    		throw new LinkedInApiClientException("Unknown class encountered in response: " + clazz.getName());
    	}
	}
}
