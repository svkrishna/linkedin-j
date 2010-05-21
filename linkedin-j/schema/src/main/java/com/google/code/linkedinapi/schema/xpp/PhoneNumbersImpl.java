
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneNumbers;

public class PhoneNumbersImpl
	extends BaseSchemaEntity
    implements Serializable, PhoneNumbers
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<PhoneNumber> phoneNumberList;
    protected Long total;

    public List<PhoneNumber> getPhoneNumberList() {
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<PhoneNumber>();
        }
        return this.phoneNumberList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("phone-number")) {
        		PhoneNumberImpl phoneNumberImpl = new PhoneNumberImpl();
    			phoneNumberImpl.init(parser);
    			getPhoneNumberList().add(phoneNumberImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "phone-numbers");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (PhoneNumber phoneNumber : getPhoneNumberList()) {
			((PhoneNumberImpl) phoneNumber).toXml(serializer);
		}
		serializer.endTag(null, "phone-numbers");
	}
}
