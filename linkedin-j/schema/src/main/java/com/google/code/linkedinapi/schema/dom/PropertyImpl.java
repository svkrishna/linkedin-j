
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Property;
public class PropertyImpl
    extends BaseSchemaEntity
    implements Property
{

    protected Long value;
    protected String key;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String value) {
        this.key = value;
    }

	@Override
	public void init(Element element) {
		setKey(element.getAttribute("key"));
		setValue(Long.parseLong(DomUtils.getElementValue(element)));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("property");
		element.setAttribute("key", getKey());
		DomUtils.setElementValue(element, getValue());
		return element;
	}

}
