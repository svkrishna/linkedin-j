
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("education")) {
    			EducationImpl educationImpl = new EducationImpl();
    			educationImpl.init(parser);
    			getEducationList().add(educationImpl);
            } else {
                // Consume something we don't understand.
            	System.err.println(getClass().getName() + ":Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "educations");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Education education : getEducationList()) {
			((EducationImpl) education).toXml(serializer);
		}
		serializer.endTag(null, "educations");
	}
}
