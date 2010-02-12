
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
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
	public void init(XmlPullParser parser) {
		setKey(XppUtils.getAttributeValueAsLongFromNode(parser, "key"));
		setCode(XppUtils.getElementValueFromNode(parser, "code"));
		setName(XppUtils.getElementValueFromNode(parser, "name"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("question-category");
		XppUtils.setAttributeValueToNode(element, "key", getKey());
		XppUtils.setElementValueToNode(element, "code", getCode());
		XppUtils.setElementValueToNode(element, "name", getName());
		return element;
	}
}
