
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

public class LocationImpl
    extends BaseSchemaEntity
    implements Location
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8469907482652062050L;
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
	public void init(XmlPullParser parser) {
		Element countryElem = (Element) XppUtils.getChildElementByName(parser, "country");
		if (countryElem != null) {
			CountryImpl countryImpl = new CountryImpl();
			countryImpl.init(countryElem);
			setCountry(countryImpl);
		}
		setName(XppUtils.getElementValueFromNode(parser, "name"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("location");
		XppUtils.setElementValueToNode(element, "name", getName());
		
		if (getCountry() != null) {
			element.appendChild(((CountryImpl) getCountry()).toXml(serializer));
		}
		return element;
	}
}
