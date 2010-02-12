
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.HttpHeader;

public class HttpHeaderImpl
    extends BaseSchemaEntity
    implements HttpHeader
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8392710882497445323L;
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
	public void init(XmlPullParser parser) {
		setName(XppUtils.getElementValueFromNode(parser, "name"));
		setValue(XppUtils.getElementValueFromNode(parser, "value"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("http-header");
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "value", getValue());
		return element;
	}
}
