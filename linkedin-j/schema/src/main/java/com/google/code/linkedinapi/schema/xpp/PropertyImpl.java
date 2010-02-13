
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		setKey(parser.getAttributeValue(null, "key"));
		setValue(Long.parseLong(parser.nextText()));
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "property");
		XppUtils.setAttributeValueToNode(element, "key", getKey());
		XppUtils.setElementValue(element, getValue());
		serializer.endTag(null, "property");
	}

}
