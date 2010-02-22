
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("type")) {
        		setType(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("type")) {
        		setIndustry(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "company");
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "type", getType());
		XppUtils.setElementValueToNode(element, "industry", getIndustry());
		serializer.endTag(null, "company");
	}
}
