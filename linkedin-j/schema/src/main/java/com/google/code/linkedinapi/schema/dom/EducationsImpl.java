
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;

public class EducationsImpl
    extends BaseSchemaEntity
    implements Educations
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2213150259938479083L;
	protected List<Education> education;
    protected Long total;

    public List<Education> getEducation() {
        if (education == null) {
            education = new ArrayList<Education>();
        }
        return this.education;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> educations = DomUtils.getChildElementsByLocalName(element, "education");
		for (Element education : educations) {
			EducationImpl educationImpl = new EducationImpl();
			educationImpl.init(education);
			getEducation().add(educationImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("educations");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Education education : getEducation()) {
			element.appendChild(((EducationImpl) education).toXml(document));
		}
		return element;
	}
}
