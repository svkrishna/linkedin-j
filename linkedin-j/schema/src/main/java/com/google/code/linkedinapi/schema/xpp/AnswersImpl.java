
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));
		List<Element> answers = XppUtils.getChildElementsByLocalName(parser, "answer");
		for (Element answer : answers) {
			AnswerImpl answerImpl = new AnswerImpl();
			answerImpl.init(answer);
			getAnswerList().add(answerImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("answers");
		XppUtils.setAttributeValueToNode(element, "count", getCount());
		for (Answer answer : getAnswerList()) {
			element.appendChild(((AnswerImpl) answer).toXml(serializer));
		}
		return element;
	}
}
