
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setName(XppUtils.getElementValueFromNode(parser, "name"));
		setUrl(XppUtils.getElementValueFromNode(parser, "url"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("member-url");
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "url", getUrl());
		return element;
	}
    
}
