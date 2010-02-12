
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		Element recepientsElem = (Element) XppUtils.getChildElementByName(parser, "recipients");
		if (recepientsElem != null) {
			RecipientsImpl recipientsImpl = new RecipientsImpl();
			recipientsImpl.init(recepientsElem);
			setRecipients(recipientsImpl);
		}
		Element itemContentElem = (Element) XppUtils.getChildElementByName(parser, "item-content");
		if (itemContentElem != null) {
			ItemContentImpl itemContentImpl = new ItemContentImpl();
			itemContentImpl.init(itemContentElem);
			setItemContent(itemContentImpl);
		}
		setSubject(XppUtils.getElementValueFromNode(parser, "subject"));
		setBody(XppUtils.getElementValueFromNode(parser, "body"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("mailbox-item");
		XppUtils.setElementValueToNode(element, "subject", getSubject());
		XppUtils.setElementValueToNode(element, "body", getBody());
		
		if (getRecipients() != null) {
			element.appendChild(((RecipientsImpl) getRecipients()).toXml(serializer));
		}
		if (getItemContent() != null) {
			element.appendChild(((ItemContentImpl) getItemContent()).toXml(serializer));
		}
		return element;
	}

}
