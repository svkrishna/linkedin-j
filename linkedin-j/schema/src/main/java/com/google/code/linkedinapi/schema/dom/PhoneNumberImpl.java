
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneType;

public class PhoneNumberImpl
	extends BaseSchemaEntity
    implements Serializable, PhoneNumber
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String phoneNumber;
    protected PhoneType phoneType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType value) {
        this.phoneType = value;
    }

	@Override
	public void init(Element element) {
		setPhoneNumber(DomUtils.getElementValueFromNode(element, "phone-number"));
		setPhoneType(PhoneType.fromValue(DomUtils.getElementValueFromNode(element, "phone-type")));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("phone-number");
		DomUtils.setElementValueToNode(element, "phone-number", getPhoneNumber());
		DomUtils.setElementValueToNode(element, "phone-type", getPhoneType().value());
		return element;
	}
}
