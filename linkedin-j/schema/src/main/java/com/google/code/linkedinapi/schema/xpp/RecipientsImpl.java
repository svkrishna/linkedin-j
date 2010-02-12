
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		List<Element> recipientElems = XppUtils.getChildElementsByLocalName(parser, "recipient");
		for (Element recepient : recipientElems) {
			RecipientImpl recipientImpl = new RecipientImpl();
			recipientImpl.init(recepient);
			getRecipientList().add(recipientImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("recipients");
		for (Recipient recepient : getRecipientList()) {
			element.appendChild(((RecipientImpl) recepient).toXml(serializer));
		}
		return element;
	}
}
