
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneNumbers;

public class PhoneNumbersImpl
	extends BaseSchemaEntity
    implements Serializable, PhoneNumbers
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<PhoneNumber> phoneNumberList;
    protected Long total;

    public List<PhoneNumber> getPhoneNumberList() {
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<PhoneNumber>();
        }
        return this.phoneNumberList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> phoneNumberElems = DomUtils.getChildElementsByLocalName(element, "phone-number");
		for (Element phoneNumberElem : phoneNumberElems) {
			PhoneNumberImpl phoneNumberImpl = new PhoneNumberImpl();
			phoneNumberImpl.init(phoneNumberElem);
			getPhoneNumberList().add(phoneNumberImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("phone-numbers");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (PhoneNumber phoneNumber : getPhoneNumberList()) {
			element.appendChild(((PhoneNumberImpl) phoneNumber).toXml(document));
		}
		return element;
	}
}
