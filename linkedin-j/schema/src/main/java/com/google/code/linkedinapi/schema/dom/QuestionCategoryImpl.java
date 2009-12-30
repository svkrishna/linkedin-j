
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		setKey(DomUtils.getAttributeValueAsLongFromNode(element, "key"));
		setCode(DomUtils.getElementValueFromNode(element, "code"));
		setName(DomUtils.getElementValueFromNode(element, "name"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("question-category");
		DomUtils.setAttributeValueToNode(element, "key", getKey());
		DomUtils.setElementValueToNode(element, "code", getCode());
		DomUtils.setElementValueToNode(element, "name", getName());
		return element;
	}
}
