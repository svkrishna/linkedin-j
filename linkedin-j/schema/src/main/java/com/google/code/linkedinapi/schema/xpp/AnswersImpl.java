
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("answer")) {
    			AnswerImpl answerImpl = new AnswerImpl();
    			answerImpl.init(parser);
    			getAnswerList().add(answerImpl);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "answers");
		XppUtils.setAttributeValueToNode(element, "count", getCount());
		for (Answer answer : getAnswerList()) {
			((AnswerImpl) answer).toXml(serializer);
		}
		element.endTag(null, "answers");
	}
}
