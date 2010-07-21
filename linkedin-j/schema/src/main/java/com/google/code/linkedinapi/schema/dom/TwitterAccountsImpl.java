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

import com.google.code.linkedinapi.schema.TwitterAccount;
import com.google.code.linkedinapi.schema.TwitterAccounts;

public class TwitterAccountsImpl
	extends BaseSchemaEntity
    implements Serializable, TwitterAccounts
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<TwitterAccount> twitterAccountList;
    protected Long total;

    public List<TwitterAccount> getTwitterAccountList() {
        if (twitterAccountList == null) {
            twitterAccountList = new ArrayList<TwitterAccount>();
        }
        return this.twitterAccountList;
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
		List<Element> imAccountElems = DomUtils.getChildElementsByLocalName(element, "twitter-account");
		for (Element accountElem : imAccountElems) {
			TwitterAccountImpl accountImpl = new TwitterAccountImpl();
			accountImpl.init(accountElem);
			getTwitterAccountList().add(accountImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("twitter-accounts");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (TwitterAccount account : getTwitterAccountList()) {
			element.appendChild(((TwitterAccountImpl) account).toXml(document));
		}
		return element;
	}
}
