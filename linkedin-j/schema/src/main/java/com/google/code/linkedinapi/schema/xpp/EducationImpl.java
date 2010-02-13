
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("school-name")) {
        		setSchoolName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("degree")) {
        		setDegree(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("start-date")) {
    			StartDateImpl startDate = new StartDateImpl();
    			startDate.init(parser);
    			setStartDate(startDate);
        	} else if (name.equals("end-date")) {
    			EndDateImpl endDate = new EndDateImpl();
    			endDate.init(parser);
    			setEndDate(endDate);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "education");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "school-name", getSchoolName());
		XppUtils.setElementValueToNode(element, "degree", getDegree());
		if (getStartDate() != null) {
			((StartDateImpl) getStartDate()).toXml(serializer);
		}
		if (getEndDate() != null) {
			((EndDateImpl) getEndDate()).toXml(serializer);
		}
		serializer.endTag(null, "education");
	}
}
