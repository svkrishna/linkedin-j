
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
public class ActivityImpl
    extends BaseSchemaEntity
    implements Activity
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2002088204138306557L;
	protected Long timestamp;
    protected NetworkUpdateContentType contentType;
    protected String body;
    protected String locale;
    protected String appId;
    
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public NetworkUpdateContentType getContentType() {
        return contentType;
    }

    public void setContentType(NetworkUpdateContentType value) {
        this.contentType = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String value) {
        this.locale = value;
    }
    
    public String getAppId() {
        return appId;
    }

    public void setAppId(String value) {
        this.appId = value;
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setLocale(parser.getAttribute("locale"));
		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser, "timestamp"));
		String contentTypeStr = XppUtils.getElementValueFromNode(parser, "content-type");
		if (contentTypeStr != null) {
			setContentType(NetworkUpdateContentType.fromValue(contentTypeStr));
		}
		setBody(XppUtils.getElementValueFromNode(parser, "body"));
		setAppId(XppUtils.getElementValueFromNode(parser, "app-id"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("activity");
		XppUtils.setAttributeValueToNode(element, "locale", getLocale());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "content-type", getContentType().value());
		XppUtils.setElementValueToNode(element, "body", getBody());
		XppUtils.setElementValueToNode(element, "app-id", getAppId());
		return element;
	}

}
