
package com.google.code.linkedinapi.schema.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;

public class EducationsImpl
    extends BaseSchemaEntity
    implements Educations
{

    protected EducationImpl education;
    protected Long total;

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education value) {
        this.education = ((EducationImpl) value);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
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
