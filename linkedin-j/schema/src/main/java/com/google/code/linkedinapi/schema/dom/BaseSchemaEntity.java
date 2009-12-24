/**
 * 
 */
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The Class BaseSchemaEntity.
 * 
 * @author Nabeel Mukhtar
 */
public abstract class BaseSchemaEntity implements Serializable {
	
	/**
	 * To xml.
	 * 
	 * @param document the document
	 * 
	 * @return the element
	 */
	public abstract Element toXml(Document document);
	
	/**
	 * Inits the.
	 * 
	 * @param element the element
	 */
	public abstract void init(Element element);
	
	
}
