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

import com.google.code.linkedinapi.schema.Country;

public class CountryImpl
    extends BaseSchemaEntity
    implements Country
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3791971546760035359L;
	protected String code;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

	@Override
	public void init(Element element) {
		setCode(DomUtils.getElementValueFromNode(element, "code"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("country");
		DomUtils.setElementValueToNode(element, "code", getCode());
		return element;
	}
}
