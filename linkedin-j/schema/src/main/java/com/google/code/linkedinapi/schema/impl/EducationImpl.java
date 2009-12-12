
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.Year;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "schoolName",
    "degree",
    "startDate",
    "endDate"
})
@XmlRootElement(name = "education")
public class EducationImpl
    extends BaseSchemaEntity
    implements Education
{

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String id;
    @XmlElement(name = "school-name", required = true)
    protected String schoolName;
    @XmlElement(required = true)
    protected String degree;
    @XmlElement(name = "start-date", required = true, type = StartDateImpl.class)
    protected StartDateImpl startDate;
    @XmlElement(name = "end-date", required = true, type = YearImpl.class)
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

}
