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

import com.google.code.linkedinapi.schema.HttpHeader;

public class HttpHeaderImpl
    extends BaseSchemaEntity
    implements HttpHeader
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8392710882497445323L;
	protected String name;
    protected String value;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	@Override
	public void init(Element element) {
		setName(DomUtils.getElementValueFromNode(element, "name"));
		setValue(DomUtils.getElementValueFromNode(element, "value"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("http-header");
		DomUtils.setElementValueToNode(element, "name", getName());
		DomUtils.setElementValueToNode(element, "value", getValue());
		return element;
	}
}
