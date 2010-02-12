
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Recipient;

public class RecipientImpl
    extends BaseSchemaEntity
    implements Recipient
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4532326761923396639L;
	protected PersonImpl person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		Element personElem = (Element) XppUtils.getChildElementByName(parser, "person");
		if (personElem != null) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(personElem);
			setPerson(personImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("recipient");
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(serializer));
		}
		return element;
	}
}
