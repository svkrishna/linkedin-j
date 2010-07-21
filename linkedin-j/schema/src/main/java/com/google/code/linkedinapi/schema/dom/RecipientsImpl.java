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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.Recipients;

public class RecipientsImpl
    extends BaseSchemaEntity
    implements Recipients
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5874984453850790428L;
	protected List<Recipient> recipientList;

    public List<Recipient> getRecipientList() {
        if (recipientList == null) {
            recipientList = new ArrayList<Recipient>();
        }
        return this.recipientList;
    }

	@Override
	public void init(Element element) {
		List<Element> recipientElems = DomUtils.getChildElementsByLocalName(element, "recipient");
		for (Element recepient : recipientElems) {
			RecipientImpl recipientImpl = new RecipientImpl();
			recipientImpl.init(recepient);
			getRecipientList().add(recipientImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recipients");
		for (Recipient recepient : getRecipientList()) {
			element.appendChild(((RecipientImpl) recepient).toXml(document));
		}
		return element;
	}
}
