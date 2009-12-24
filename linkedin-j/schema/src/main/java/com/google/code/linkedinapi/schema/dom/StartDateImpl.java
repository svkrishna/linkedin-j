
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.StartDate;

public class StartDateImpl
	extends BaseSchemaEntity
    implements StartDate
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3332888832061238011L;
	protected Long year;
    protected Long month;

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
    
	@Override
	public void init(Element element) {
		setYear(DomUtils.getElementValueAsLongFromNode(element, "year"));
		setMonth(DomUtils.getElementValueAsLongFromNode(element, "month"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("start-date");
		DomUtils.setElementValueToNode(element, "month", getMonth());
		DomUtils.setElementValueToNode(element, "year", getYear());
		return element;
	}
}
