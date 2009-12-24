
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.MemberUrl;

public class MemberUrlImpl
	extends BaseSchemaEntity
    implements MemberUrl
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2382692750939419298L;
	protected String url;
    protected String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

	@Override
	public void init(Element element) {
		setName(DomUtils.getElementValueFromNode(element, "name"));
		setUrl(DomUtils.getElementValueFromNode(element, "url"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-url");
		DomUtils.setElementValueToNode(element, "name", getName());
		DomUtils.setElementValueToNode(element, "url", getUrl());
		return element;
	}
    
}
