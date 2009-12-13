
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.Year;

public class EducationImpl
    extends BaseSchemaEntity
    implements Education
{

    protected String id;
    protected String schoolName;
    protected String degree;
    protected StartDateImpl startDate;
    protected YearImpl endDate;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String value) {
        this.schoolName = value;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String value) {
        this.degree = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public Year getEndDate() {
        return endDate;
    }

    public void setEndDate(Year value) {
        this.endDate = ((YearImpl) value);
    }

	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setSchoolName(DomUtils.getElementValueFromNode(element, "school-name"));
		setDegree(DomUtils.getElementValueFromNode(element, "degree"));
		Element startDateElem = (Element) DomUtils.getChildNode(element, "start-date");
		if (startDateElem != null) {
			StartDateImpl startDate = new StartDateImpl();
			startDate.init(startDateElem);
			setStartDate(startDate);
		}
		Element endDateElem = (Element) DomUtils.getChildNode(element, "end-date");
		if (endDateElem != null) {
			EndDateImpl endDate = new EndDateImpl();
			endDate.init(endDateElem);
			setEndDate(endDate);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("education");
		DomUtils.setElementValueToNode(element, "id", String.valueOf(getId()));
		DomUtils.setElementValueToNode(element, "school-name", String.valueOf(getSchoolName()));
		DomUtils.setElementValueToNode(element, "degree", String.valueOf(getDegree()));
		if (getStartDate() != null) {
			element.appendChild(((StartDateImpl) getStartDate()).toXml(document));
		}
		if (getEndDate() != null) {
			element.appendChild(((EndDateImpl) getEndDate()).toXml(document));
		}
		return element;
	}
}
