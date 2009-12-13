
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Year;

public class YearImpl
    extends BaseSchemaEntity
    implements Year
{

    protected Long year;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

	@Override
	public void init(Element element) {
		setYear(Long.parseLong(DomUtils.getElementValue(element)));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("year");
		DomUtils.setElementValue(element, String.valueOf(getYear()));
		return element;
	}
}
