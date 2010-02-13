
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("url")) {
        		setUrl(XppUtils.getElementValueFromNode(parser));
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "member-url");
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "url", getUrl());
		serializer.endTag(null, "member-url");
	}
    
}
