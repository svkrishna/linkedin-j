
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
