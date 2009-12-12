
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Country;

public class CountryImpl
    extends BaseSchemaEntity
    implements Country
{
    protected String code;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
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
