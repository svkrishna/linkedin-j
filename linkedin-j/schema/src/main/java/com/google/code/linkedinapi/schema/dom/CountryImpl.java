
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Country;

public class CountryImpl
    extends BaseSchemaEntity
    implements Country
{
    protected String code;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

	@Override
	public void init(Element element) {
		setCode(DomUtils.getElementValueFromNode(element, "code"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("country");
		DomUtils.setElementValueToNode(element, "code", String.valueOf(getCode()));
		return element;
	}
}
