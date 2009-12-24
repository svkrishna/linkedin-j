
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
	protected List<Recipient> recipient;

    public List<Recipient> getRecipient() {
        if (recipient == null) {
            recipient = new ArrayList<Recipient>();
        }
        return this.recipient;
    }

	@Override
	public void init(Element element) {
		List<Element> recipientElems = DomUtils.getChildElementsByLocalName(element, "recipient");
		for (Element recepient : recipientElems) {
			RecipientImpl recipientImpl = new RecipientImpl();
			recipientImpl.init(recepient);
			getRecipient().add(recipientImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recipients");
		for (Recipient recepient : getRecipient()) {
			element.appendChild(((RecipientImpl) recepient).toXml(document));
		}
		return element;
	}
}
