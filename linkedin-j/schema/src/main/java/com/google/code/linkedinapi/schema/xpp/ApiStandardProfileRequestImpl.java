
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Headers;

public class ApiStandardProfileRequestImpl
	extends BaseSchemaEntity
    implements ApiStandardProfileRequest
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8959695220558645456L;
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
			setHeaders(headerImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("api-standard-profile-request");
		XppUtils.setElementValueToNode(element, "url", getUrl());
		if (getHeaders() != null) {
			element.appendChild(((HeadersImpl) getHeaders()).toXml(serializer));
		}
		return element;
	}
}
