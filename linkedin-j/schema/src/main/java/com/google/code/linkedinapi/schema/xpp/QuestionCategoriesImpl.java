
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.QuestionCategories;
import com.google.code.linkedinapi.schema.QuestionCategory;

public class QuestionCategoriesImpl
	extends BaseSchemaEntity
    implements QuestionCategories
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<QuestionCategory> questionCategoryList;
    protected Long total;

    public List<QuestionCategory> getQuestionCategoryList() {
        if (questionCategoryList == null) {
            questionCategoryList = new ArrayList<QuestionCategory>();
        }
        return this.questionCategoryList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> categories = XppUtils.getChildElementsByLocalName(parser, "question-category");
		for (Element education : categories) {
			QuestionCategoryImpl categoryImpl = new QuestionCategoryImpl();
			categoryImpl.init(education);
			getQuestionCategoryList().add(categoryImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("question-categories");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (QuestionCategory category : getQuestionCategoryList()) {
			element.appendChild(((QuestionCategoryImpl) category).toXml(serializer));
		}
		return element;
	}
}
