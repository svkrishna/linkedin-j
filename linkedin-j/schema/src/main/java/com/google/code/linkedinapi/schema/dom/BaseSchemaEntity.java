/**
 * 
 */
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

/**
 * @author akv
 *
 */
public abstract class BaseSchemaEntity {
	public abstract Element toXml();
	public abstract void init(Element element);
}
