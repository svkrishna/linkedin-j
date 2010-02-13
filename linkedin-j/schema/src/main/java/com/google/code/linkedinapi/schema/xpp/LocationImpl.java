
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("country")) {
    			CountryImpl countryImpl = new CountryImpl();
    			countryImpl.init(parser);
    			setCountry(countryImpl);
        	} else if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "location");
		XppUtils.setElementValueToNode(element, "name", getName());
		
		if (getCountry() != null) {
			((CountryImpl) getCountry()).toXml(serializer);
		}
		serializer.endTag(null, "location");
	}
}
