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

import com.google.code.linkedinapi.schema.ItemContent;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Recipients;

public class MailboxItemImpl
    extends BaseSchemaEntity
    implements MailboxItem
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8720504708417425242L;
	protected RecipientsImpl recipients;
    protected String subject;
    protected String body;
    protected ItemContentImpl itemContent;

    public Recipients getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipients value) {
        this.recipients = ((RecipientsImpl) value);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String value) {
        this.subject = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public ItemContent getItemContent() {
        return itemContent;
    }

    public void setItemContent(ItemContent value) {
        this.itemContent = ((ItemContentImpl) value);
    }

	@Override
	public void init(Element element) {
		Element recepientsElem = (Element) DomUtils.getChildElementByName(element, "recipients");
		if (recepientsElem != null) {
			RecipientsImpl recipientsImpl = new RecipientsImpl();
			recipientsImpl.init(recepientsElem);
			setRecipients(recipientsImpl);
		}
		Element itemContentElem = (Element) DomUtils.getChildElementByName(element, "item-content");
		if (itemContentElem != null) {
			ItemContentImpl itemContentImpl = new ItemContentImpl();
			itemContentImpl.init(itemContentElem);
			setItemContent(itemContentImpl);
		}
		setSubject(DomUtils.getElementValueFromNode(element, "subject"));
		setBody(DomUtils.getElementValueFromNode(element, "body"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("mailbox-item");
		DomUtils.setElementValueToNode(element, "subject", getSubject());
		DomUtils.setElementValueToNode(element, "body", getBody());
		
		if (getRecipients() != null) {
			element.appendChild(((RecipientsImpl) getRecipients()).toXml(document));
		}
		if (getItemContent() != null) {
			element.appendChild(((ItemContentImpl) getItemContent()).toXml(document));
		}
		return element;
	}

}
