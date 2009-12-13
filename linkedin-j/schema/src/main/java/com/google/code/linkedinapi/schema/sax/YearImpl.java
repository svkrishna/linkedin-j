
package com.google.code.linkedinapi.schema.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Year;

public class YearImpl
    extends BaseSchemaEntity
    implements Year
{

    protected Long year;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
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
