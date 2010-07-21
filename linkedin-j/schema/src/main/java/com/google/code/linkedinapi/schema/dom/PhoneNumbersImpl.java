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
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneNumbers;

public class PhoneNumbersImpl
	extends BaseSchemaEntity
    implements Serializable, PhoneNumbers
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<PhoneNumber> phoneNumberList;
    protected Long total;

    public List<PhoneNumber> getPhoneNumberList() {
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<PhoneNumber>();
        }
        return this.phoneNumberList;
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
		List<Element> phoneNumberElems = DomUtils.getChildElementsByLocalName(element, "phone-number");
		for (Element phoneNumberElem : phoneNumberElems) {
			PhoneNumberImpl phoneNumberImpl = new PhoneNumberImpl();
			phoneNumberImpl.init(phoneNumberElem);
			getPhoneNumberList().add(phoneNumberImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("phone-numbers");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (PhoneNumber phoneNumber : getPhoneNumberList()) {
			element.appendChild(((PhoneNumberImpl) phoneNumber).toXml(document));
		}
		return element;
	}
}
