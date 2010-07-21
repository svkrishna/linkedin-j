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

import com.google.code.linkedinapi.schema.TwitterAccount;

public class TwitterAccountImpl
	extends BaseSchemaEntity
    implements Serializable, TwitterAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long providerAccountId;
    protected String providerAccountName;

    public Long getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(Long value) {
        this.providerAccountId = value;
    }

    public String getProviderAccountName() {
        return providerAccountName;
    }

    public void setProviderAccountName(String value) {
        this.providerAccountName = value;
    }
	@Override
	public void init(Element element) {
		setProviderAccountName(DomUtils.getElementValueFromNode(element, "provider-account-name"));
		setProviderAccountId(DomUtils.getElementValueAsLongFromNode(element, "provider-account-id"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("twitter-account");
		DomUtils.setElementValueToNode(element, "provider-account-name", getProviderAccountName());
		DomUtils.setElementValueToNode(element, "provider-account-id", getProviderAccountId());
		return element;
	}
}
