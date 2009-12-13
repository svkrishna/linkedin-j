
package com.google.code.linkedinapi.schema.sax;

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

    protected List<Recipient> recipient;

    public List<Recipient> getRecipient() {
        if (recipient == null) {
            recipient = new ArrayList<Recipient>();
        }
        return this.recipient;
    }

	@Override
	public void init(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

}
