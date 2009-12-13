
package com.google.code.linkedinapi.schema.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;

public class HeadersImpl
    extends BaseSchemaEntity
    implements Headers
{

    protected HttpHeaderImpl httpHeader;
    protected Long total;

    public HttpHeader getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(HttpHeader value) {
        this.httpHeader = ((HttpHeaderImpl) value);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

}
