/**
 * 
 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/**
 * The Class BaseSchemaEntity.
 * 
 * @author Nabeel Mukhtar
 */
public abstract class BaseSchemaEntity implements Serializable {
	
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249791194912997698L;

	/**
	 * To xml.
	 * 
	 * @param serializer the document
	 * @throws IOException TODO
	 */
	public abstract void toXml(XmlSerializer serializer) throws IOException;
	
	/**
	 * Inits the.
	 * 
	 * @param parser the element
	 * @throws IOException TODO
	 * @throws XmlPullParserException TODO
	 */
	public abstract void init(XmlPullParser parser) throws IOException, XmlPullParserException;
	
	
}
