
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.StartDate;

public class StartDateImpl
    extends YearImpl
    implements StartDate
{

    protected Long month;

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }
    
	@Override
	public void init(Element element) {
		super.init(element);
		setMonth(DomUtils.getElementValueAsLongFromNode(element, "month"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("start-date");
		DomUtils.setElementValueToNode(element, "month", String.valueOf(getMonth()));
		return element;
	}
}
