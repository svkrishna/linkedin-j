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

import com.google.code.linkedinapi.schema.Property;
public class PropertyImpl
    extends BaseSchemaEntity
    implements Property
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7943634136391956316L;
	protected Long value;
    protected String key;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String value) {
        this.key = value;
    }

	@Override
	public void init(Element element) {
		setKey(element.getAttribute("key"));
		setValue(Long.parseLong(DomUtils.getElementValue(element)));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("property");
		DomUtils.setAttributeValueToNode(element, "key", getKey());
		DomUtils.setElementValue(element, getValue());
		return element;
	}

}
