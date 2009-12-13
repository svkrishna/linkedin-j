/**
 * 
 */
package com.google.code.linkedinapi.schema.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author akv
 *
 */
public abstract class BaseSchemaEntity {
	public abstract Element toXml(Document document);
	public abstract void init(Element element);
}
