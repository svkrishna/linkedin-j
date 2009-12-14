
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;

public class HeadersImpl
    extends BaseSchemaEntity
    implements Headers
{

    protected List<HttpHeader> httpHeader;
    protected Long total;

    public List<HttpHeader> getHttpHeader() {
        if (httpHeader == null) {
            httpHeader = new ArrayList<HttpHeader>();
        }
        return this.httpHeader;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(Long.valueOf(element.getAttribute("total")));
		List<Element> headers = DomUtils.getChildElementsByLocalName(element, "http-header");
		for (Element httpHeader : headers) {
			HttpHeaderImpl httpHeaderImpl = new HttpHeaderImpl();
			httpHeaderImpl.init(httpHeader);
			getHttpHeader().add(httpHeaderImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("headers");
		element.setAttribute("total", String.valueOf(getTotal()));
		for (HttpHeader httpHeader : getHttpHeader()) {
			element.appendChild(((HttpHeaderImpl) httpHeader).toXml(document));
		}
		return element;
	}
}
