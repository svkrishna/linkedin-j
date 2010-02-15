
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.UpdateContent;

public class UpdateContentImpl
    extends BaseSchemaEntity
    implements UpdateContent
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8557807037014197165L;
	protected PersonImpl person;
    protected JobImpl job;
	protected QuestionImpl question;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }
    
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question value) {
        this.question = ((QuestionImpl) value);
    }
    
    public Job getJob() {
        return job;
    }

    public void setJob(Job value) {
        this.job = ((JobImpl) value);
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
        	} else if (name.equals("job")) {
    			JobImpl jobImpl = new JobImpl();
    			jobImpl.init(parser);
    			setJob(jobImpl);
        	} else if (name.equals("question")) {
    			QuestionImpl questionImpl = new QuestionImpl();
    			questionImpl.init(parser);
    			setQuestion(questionImpl);
            } else {
                // Consume something we don't understand.
            	System.err.println(getClass().getName() + ":Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "update-content");
		if (getPerson() != null) {
			((PersonImpl) getPerson()).toXml(element);
		}
		if (getJob() != null) {
			((JobImpl) getJob()).toXml(element);
		}
		if (getQuestion() != null) {
			((QuestionImpl) getQuestion()).toXml(element);
		}
		serializer.endTag(null, "update-content");
	}
}
