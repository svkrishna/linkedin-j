
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Url;

public class UrlImpl
    extends BaseSchemaEntity
    implements Url
{

    protected String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

	@Override
	public void init(Element element) {
		setUrl(DomUtils.getElementValue(element));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("url");
		DomUtils.setElementValue(element, getUrl());
		return element;
	}
}
