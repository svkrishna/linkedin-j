/**
 *
 */
package com.google.code.linkedinapi.client.impl;
import java.io.InputStream;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.dom.DomElementFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInApiSaxClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final SchemaElementFactory<Element> OBJECT_FACTORY = new DomElementFactory();
    
    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiSaxClient(String consumerKey, String consumerSecret) {
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
    protected <T> T unmarshallObject(InputStream xmlContent) {
//        try {
//            Unmarshaller u  = getJaxbContext().createUnmarshaller();
//
//            return (T) u.unmarshal(xmlContent);
//        } catch (JAXBException e) {
//            throw new LinkedInApiClientException(e);
//        }
    	// TODO-NM: Implement this method.
    	return null;
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
//        try {
//            StringWriter writer = new StringWriter();
//            Marshaller   m = getJaxbContext().createMarshaller();
//
//            m.marshal(element, writer);
//
//            return writer.toString();
//        } catch (JAXBException e) {
//            throw new LinkedInApiClientException(e);
//        }
    	// TODO-NM: Implement this method.
    	return null;
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
}
