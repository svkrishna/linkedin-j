
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Company;

public class CompanyImpl
    extends BaseSchemaEntity
    implements Company
{

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
