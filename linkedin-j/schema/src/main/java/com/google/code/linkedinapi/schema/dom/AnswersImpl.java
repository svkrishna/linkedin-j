
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Answer;
import com.google.code.linkedinapi.schema.Answers;

public class AnswersImpl
	extends BaseSchemaEntity
    implements Answers
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Answer> answerList;
    protected Long count;

    public List<Answer> getAnswerList() {
        if (answerList == null) {
            answerList = new ArrayList<Answer>();
        }
        return this.answerList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }
    
	@Override
	public void init(Element element) {
		setCount(DomUtils.getAttributeValueAsLongFromNode(element, "count"));
		List<Element> answers = DomUtils.getChildElementsByLocalName(element, "answer");
		for (Element answer : answers) {
			AnswerImpl answerImpl = new AnswerImpl();
			answerImpl.init(answer);
			getAnswerList().add(answerImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("answers");
		DomUtils.setAttributeValueToNode(element, "count", getCount());
		for (Answer answer : getAnswerList()) {
			element.appendChild(((AnswerImpl) answer).toXml(document));
		}
		return element;
	}
}
