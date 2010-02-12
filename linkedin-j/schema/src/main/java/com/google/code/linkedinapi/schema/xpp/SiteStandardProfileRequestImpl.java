
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class SiteStandardProfileRequestImpl
	extends BaseSchemaEntity
    implements SiteStandardProfileRequest
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1502818715963152421L;
	protected String url;
    protected HeadersImpl headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }
	@Override
	public void init(XmlPullParser parser) {
		setUrl(XppUtils.getElementValueFromNode(parser, "url"));
		Element headersElem = (Element) XppUtils.getChildElementByName(parser, "headers");
		if (headersElem != null) {
			HeadersImpl headerImpl = new HeadersImpl();
			headerImpl.init(headersElem);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("site-standard-profile-request");
		XppUtils.setElementValueToNode(element, "url", getUrl());
		if (getHeaders() != null) {
			element.appendChild(((HeadersImpl) getHeaders()).toXml(serializer));
		}
		return element;
	}
}
