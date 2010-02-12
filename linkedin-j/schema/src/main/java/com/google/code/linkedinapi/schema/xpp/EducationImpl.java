
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.StartDate;

public class EducationImpl
    extends BaseSchemaEntity
    implements Education
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -379013425062157845L;
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
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setSchoolName(XppUtils.getElementValueFromNode(parser, "school-name"));
		setDegree(XppUtils.getElementValueFromNode(parser, "degree"));
		Element startDateElem = (Element) XppUtils.getChildElementByName(parser, "start-date");
		if (startDateElem != null) {
			StartDateImpl startDate = new StartDateImpl();
			startDate.init(startDateElem);
			setStartDate(startDate);
		}
		Element endDateElem = (Element) XppUtils.getChildElementByName(parser, "end-date");
		if (endDateElem != null) {
			EndDateImpl endDate = new EndDateImpl();
			endDate.init(endDateElem);
			setEndDate(endDate);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("education");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "school-name", getSchoolName());
		XppUtils.setElementValueToNode(element, "degree", getDegree());
		if (getStartDate() != null) {
			element.appendChild(((StartDateImpl) getStartDate()).toXml(serializer));
		}
		if (getEndDate() != null) {
			element.appendChild(((EndDateImpl) getEndDate()).toXml(serializer));
		}
		return element;
	}
}
