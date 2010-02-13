
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.StartDate;

public class StartDateImpl
	extends BaseSchemaEntity
    implements StartDate
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3332888832061238011L;
	protected Long year;
    protected Long month;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("year")) {
        		setYear(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("month")) {
        		setMonth(XppUtils.getElementValueAsLongFromNode(parser));
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "start-date");
		XppUtils.setElementValueToNode(element, "month", getMonth());
		XppUtils.setElementValueToNode(element, "year", getYear());
		serializer.endTag(null, "start-date");
	}
}
