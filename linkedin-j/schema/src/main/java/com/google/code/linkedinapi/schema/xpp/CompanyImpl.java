
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Company;

public class CompanyImpl
    extends BaseSchemaEntity
    implements Company
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6951793253375914262L;
	protected String type;
    protected String name;
    protected String industry;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setName(XppUtils.getElementValueFromNode(parser, "name"));
		setType(XppUtils.getElementValueFromNode(parser, "type"));
		setIndustry(XppUtils.getElementValueFromNode(parser, "industry"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("company");
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "type", getType());
		XppUtils.setElementValueToNode(element, "industry", getIndustry());
		return element;
	}
}
