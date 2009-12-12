
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

public class LocationImpl
    extends BaseSchemaEntity
    implements Location
{

    protected String name;
    protected CountryImpl country;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = ((CountryImpl) value);
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
