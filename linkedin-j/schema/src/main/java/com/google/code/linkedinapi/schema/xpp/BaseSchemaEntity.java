/**
 * 
 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.Serializable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/**
 * The Class BaseSchemaEntity.
 * 
 * @author Nabeel Mukhtar
 */
public abstract class BaseSchemaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4249791194912997698L;

	/**
	 * To xml.
	 * 
	 * @param serializer the document
	 * 
	 * @return the element
	 */
	public abstract String toXml(XmlSerializer serializer);
	
	/**
	 * Inits the.
	 * 
	 * @param parser the element
	 */
	public abstract void init(XmlPullParser parser);
	
	
}
