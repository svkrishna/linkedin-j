/**
 *
 */
package com.google.code.linkedinapi.client.impl;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.dom.ActivityImpl;
import com.google.code.linkedinapi.schema.dom.BaseSchemaEntity;
import com.google.code.linkedinapi.schema.dom.ConnectionsImpl;
import com.google.code.linkedinapi.schema.dom.DomElementFactory;
import com.google.code.linkedinapi.schema.dom.DomUtils;
import com.google.code.linkedinapi.schema.dom.ErrorImpl;
import com.google.code.linkedinapi.schema.dom.MailboxItemImpl;
import com.google.code.linkedinapi.schema.dom.NetworkImpl;
import com.google.code.linkedinapi.schema.dom.PeopleImpl;
import com.google.code.linkedinapi.schema.dom.PersonImpl;
import com.google.code.linkedinapi.schema.dom.UpdateCommentImpl;

/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInApiDomClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final SchemaElementFactory<Element> OBJECT_FACTORY = new DomElementFactory();
    
    /** Field description */
	private final static DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
	
    /** Field description */
	private static final Map<String, Class<?>> DOM_CLASSES_MAP = new HashMap<String, Class<?>>();
	
	static {
		DOM_CLASSES_MAP.put("person", PersonImpl.class);
		DOM_CLASSES_MAP.put("network", NetworkImpl.class);
		DOM_CLASSES_MAP.put("people", PeopleImpl.class);
		DOM_CLASSES_MAP.put("connections", ConnectionsImpl.class);
		DOM_CLASSES_MAP.put("error", ErrorImpl.class);
		DOM_CLASSES_MAP.put("mailbox-item", MailboxItemImpl.class);
		DOM_CLASSES_MAP.put("update-comment", UpdateCommentImpl.class);
		DOM_CLASSES_MAP.put("activity", ActivityImpl.class);
	}
	
    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiDomClient(String consumerKey, String consumerSecret) {
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
	protected <T> T unmarshallObject(InputStream xmlContent) {
        try {
        	Document document = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder().parse(xmlContent);
        	
        	BaseSchemaEntity entity = getSchemaEntityByName(document.getDocumentElement().getNodeName());
        	
        	entity.init(document.getDocumentElement());

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
    		return DomUtils.domToString((Node) element);
    	} else if (element instanceof BaseSchemaEntity) {
    		try {
				Document document = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder().newDocument();
				return DomUtils.domToString(((BaseSchemaEntity) element).toXml(document));
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
    private BaseSchemaEntity getSchemaEntityByName(String localName) {
    	if (DOM_CLASSES_MAP.containsKey(localName)) {
    		Class<?> clazz = DOM_CLASSES_MAP.get(localName);
    		try {
				return (BaseSchemaEntity) clazz.newInstance();
			} catch (Exception e) {
	    		throw new LinkedInApiClientException("Could not instantiate class: " + clazz.getName(), e);
			}
    	} else {
    		throw new LinkedInApiClientException("Unknown tag encountered in response: " + localName);
    	}
	}
}
