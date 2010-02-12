
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
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
	public void init(XmlPullParser parser) {
		setYear(XppUtils.getElementValueAsLongFromNode(parser, "year"));
		setMonth(XppUtils.getElementValueAsLongFromNode(parser, "month"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("start-date");
		XppUtils.setElementValueToNode(element, "month", getMonth());
		XppUtils.setElementValueToNode(element, "year", getYear());
		return element;
	}
}
