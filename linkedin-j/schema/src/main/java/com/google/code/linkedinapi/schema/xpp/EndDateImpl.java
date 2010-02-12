
package com.google.code.linkedinapi.schema.xpp;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.EndDate;

public class EndDateImpl
	extends BaseSchemaEntity
    implements EndDate
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8815338299095045227L;
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
		Element element = serializer.createElement("end-date");
		XppUtils.setElementValueToNode(element, "month", getMonth());
		XppUtils.setElementValueToNode(element, "year", getYear());
		return element;
	}
}
