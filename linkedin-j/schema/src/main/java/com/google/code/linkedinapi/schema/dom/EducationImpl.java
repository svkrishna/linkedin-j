
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.StartDate;

public class EducationImpl
    extends BaseSchemaEntity
    implements Education
{

    protected String id;
    protected String schoolName;
    protected String degree;
    protected StartDateImpl startDate;
    protected EndDateImpl endDate;

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

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setSchoolName(DomUtils.getElementValueFromNode(element, "school-name"));
		setDegree(DomUtils.getElementValueFromNode(element, "degree"));
		Element startDateElem = (Element) DomUtils.getChildElementByName(element, "start-date");
		if (startDateElem != null) {
			StartDateImpl startDate = new StartDateImpl();
			startDate.init(startDateElem);
			setStartDate(startDate);
		}
		Element endDateElem = (Element) DomUtils.getChildElementByName(element, "end-date");
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
