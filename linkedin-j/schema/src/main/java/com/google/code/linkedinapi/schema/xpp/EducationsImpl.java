
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	protected List<Education> educationList;
    protected Long total;

    public List<Education> getEducationList() {
        if (educationList == null) {
            educationList = new ArrayList<Education>();
        }
        return this.educationList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> educations = XppUtils.getChildElementsByLocalName(parser, "education");
		for (Element education : educations) {
			EducationImpl educationImpl = new EducationImpl();
			educationImpl.init(education);
			getEducationList().add(educationImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("educations");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Education education : getEducationList()) {
			element.appendChild(((EducationImpl) education).toXml(serializer));
		}
		return element;
	}
}
