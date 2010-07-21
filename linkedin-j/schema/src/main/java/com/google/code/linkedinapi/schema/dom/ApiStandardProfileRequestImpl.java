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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		setUrl(DomUtils.getElementValueFromNode(element, "url"));
		Element headersElem = (Element) DomUtils.getChildElementByName(element, "headers");
		if (headersElem != null) {
			HeadersImpl headerImpl = new HeadersImpl();
			headerImpl.init(headersElem);
			setHeaders(headerImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("api-standard-profile-request");
		DomUtils.setElementValueToNode(element, "url", getUrl());
		if (getHeaders() != null) {
			element.appendChild(((HeadersImpl) getHeaders()).toXml(document));
		}
		return element;
	}
}
