
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Country;

public class CountryImpl
    extends BaseSchemaEntity
    implements Country
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3791971546760035359L;
	protected String code;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setCode(XppUtils.getElementValueFromNode(parser, "code"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("country");
		XppUtils.setElementValueToNode(element, "code", getCode());
		return element;
	}
}
