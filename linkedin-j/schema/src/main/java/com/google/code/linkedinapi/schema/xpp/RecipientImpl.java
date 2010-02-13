
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Recipient;

public class RecipientImpl
    extends BaseSchemaEntity
    implements Recipient
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4532326761923396639L;
	protected PersonImpl person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("person")) {
    			PersonImpl personImpl = new PersonImpl();
    			personImpl.init(parser);
    			setPerson(personImpl);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "recipient");
		if (getPerson() != null) {
			((PersonImpl) getPerson()).toXml(element);
		}
		serializer.endTag(null, "recipient");
	}
}
