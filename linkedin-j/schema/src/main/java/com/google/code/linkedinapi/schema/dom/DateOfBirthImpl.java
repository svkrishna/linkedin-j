
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.DateOfBirth;

public class DateOfBirthImpl
	extends BaseSchemaEntity
    implements Serializable, DateOfBirth
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long year;
    protected Long month;
    protected Long day;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long value) {
        this.day = value;
    }

	@Override
	public void init(Element element) {
		setYear(DomUtils.getElementValueAsLongFromNode(element, "year"));
		setMonth(DomUtils.getElementValueAsLongFromNode(element, "month"));
		setDay(DomUtils.getElementValueAsLongFromNode(element, "day"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("date-of-birth");
		DomUtils.setElementValueToNode(element, "month", getMonth());
		DomUtils.setElementValueToNode(element, "year", getYear());
		DomUtils.setElementValueToNode(element, "day", getDay());
		return element;
	}
}
