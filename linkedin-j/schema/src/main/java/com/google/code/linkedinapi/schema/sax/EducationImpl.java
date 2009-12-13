
package com.google.code.linkedinapi.schema.sax;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

}
