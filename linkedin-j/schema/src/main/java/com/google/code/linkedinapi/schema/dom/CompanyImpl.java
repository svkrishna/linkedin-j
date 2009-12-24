
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		setName(DomUtils.getElementValueFromNode(element, "name"));
		setType(DomUtils.getElementValueFromNode(element, "type"));
		setIndustry(DomUtils.getElementValueFromNode(element, "industry"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("company");
		DomUtils.setElementValueToNode(element, "name", getName());
		DomUtils.setElementValueToNode(element, "type", getType());
		DomUtils.setElementValueToNode(element, "industry", getIndustry());
		return element;
	}
}
