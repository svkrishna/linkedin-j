
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Authorization;

public class AuthorizationImpl
    extends BaseSchemaEntity
    implements Authorization
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3758281729858290229L;
	protected String name;
    protected String value;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	@Override
	public void init(Element element) {
		setName(DomUtils.getElementValueFromNode(element, "name"));
		setValue(DomUtils.getElementValueFromNode(element, "value"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("authorization");
		DomUtils.setElementValueToNode(element, "name", getName());
		DomUtils.setElementValueToNode(element, "value", getValue());
		return element;
	}
}
