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
	public void init(Element element) {
		setName(DomUtils.getElementValueFromNode(element, "name"));
		setUrl(DomUtils.getElementValueFromNode(element, "url"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-url");
		DomUtils.setElementValueToNode(element, "name", getName());
		DomUtils.setElementValueToNode(element, "url", getUrl());
		return element;
	}
    
}
