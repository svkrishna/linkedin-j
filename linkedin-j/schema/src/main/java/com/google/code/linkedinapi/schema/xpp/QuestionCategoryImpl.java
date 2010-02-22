
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.QuestionCategory;

public class QuestionCategoryImpl
	extends BaseSchemaEntity
    implements QuestionCategory
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String code;
    protected String name;
    protected Long key;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long value) {
        this.key = value;
    }
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setKey(XppUtils.getAttributeValueAsLongFromNode(parser, "key"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("code")) {
        		setCode(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "question-category");
		XppUtils.setAttributeValueToNode(element, "key", getKey());
		XppUtils.setElementValueToNode(element, "code", getCode());
		XppUtils.setElementValueToNode(element, "name", getName());
		serializer.endTag(null, "question-category");
	}
}
