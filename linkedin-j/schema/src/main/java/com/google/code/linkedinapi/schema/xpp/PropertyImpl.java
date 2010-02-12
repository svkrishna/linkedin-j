
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Property;
public class PropertyImpl
    extends BaseSchemaEntity
    implements Property
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7943634136391956316L;
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
	public void init(XmlPullParser parser) {
		setKey(parser.getAttribute("key"));
		setValue(Long.parseLong(XppUtils.getElementValue(parser)));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("property");
		XppUtils.setAttributeValueToNode(element, "key", getKey());
		XppUtils.setElementValue(element, getValue());
		return element;
	}

}
