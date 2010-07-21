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

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneType;

public class PhoneNumberImpl
	extends BaseSchemaEntity
    implements Serializable, PhoneNumber
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String phoneNumber;
    protected PhoneType phoneType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType value) {
        this.phoneType = value;
    }

	@Override
	public void init(Element element) {
		setPhoneNumber(DomUtils.getElementValueFromNode(element, "phone-number"));
		setPhoneType(PhoneType.fromValue(DomUtils.getElementValueFromNode(element, "phone-type")));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("phone-number");
		DomUtils.setElementValueToNode(element, "phone-number", getPhoneNumber());
		DomUtils.setElementValueToNode(element, "phone-type", getPhoneType().value());
		return element;
	}
}
