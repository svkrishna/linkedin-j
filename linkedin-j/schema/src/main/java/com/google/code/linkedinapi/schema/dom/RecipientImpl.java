
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		Element personElem = (Element) DomUtils.getChildElementByName(element, "person");
		if (personElem != null) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(personElem);
			setPerson(personImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recipient");
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(document));
		}
		return element;
	}
}
