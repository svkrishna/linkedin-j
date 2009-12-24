
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

	@Override
	public void init(Element element) {
		setLocale(element.getAttribute("locale"));
		setTimestamp(DomUtils.getElementValueAsLongFromNode(element, "timestamp"));
		String contentTypeStr = DomUtils.getElementValueFromNode(element, "content-type");
		if (contentTypeStr != null) {
			setContentType(NetworkUpdateContentType.fromValue(contentTypeStr));
		}
		setBody(DomUtils.getElementValueFromNode(element, "body"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("activity");
		element.setAttribute("locale", getLocale());
		DomUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		DomUtils.setElementValueToNode(element, "content-type", getContentType().value());
		DomUtils.setElementValueToNode(element, "body", getBody());
		return element;
	}

}
