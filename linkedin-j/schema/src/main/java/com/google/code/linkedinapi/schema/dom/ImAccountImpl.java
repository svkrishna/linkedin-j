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

import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccountType;

public class ImAccountImpl
	extends BaseSchemaEntity
    implements Serializable, ImAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected ImAccountType imAccountType;
    protected String imAccountName;

    public ImAccountType getImAccountType() {
        return imAccountType;
    }

    public void setImAccountType(ImAccountType value) {
        this.imAccountType = value;
    }

    public String getImAccountName() {
        return imAccountName;
    }

    public void setImAccountName(String value) {
        this.imAccountName = value;
    }

	@Override
	public void init(Element element) {
		setImAccountName(DomUtils.getElementValueFromNode(element, "im-account-name"));
		setImAccountType(ImAccountType.fromValue(DomUtils.getElementValueFromNode(element, "im-account-type")));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("im-account");
		DomUtils.setElementValueToNode(element, "im-account-name", getImAccountName());
		DomUtils.setElementValueToNode(element, "im-account-type", getImAccountType().value());
		return element;
	}
}
