/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

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

    /**
	 * 
	 */
	private static final long serialVersionUID = -2641335452688934142L;
	protected List<HttpHeader> httpHeaderList;
    protected Long total;

    public List<HttpHeader> getHttpHeaderList() {
        if (httpHeaderList == null) {
            httpHeaderList = new ArrayList<HttpHeader>();
        }
        return this.httpHeaderList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> headers = DomUtils.getChildElementsByLocalName(element, "http-header");
		for (Element httpHeader : headers) {
			HttpHeaderImpl httpHeaderImpl = new HttpHeaderImpl();
			httpHeaderImpl.init(httpHeader);
			getHttpHeaderList().add(httpHeaderImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("headers");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (HttpHeader httpHeader : getHttpHeaderList()) {
			element.appendChild(((HttpHeaderImpl) httpHeader).toXml(document));
		}
		return element;
	}
}
