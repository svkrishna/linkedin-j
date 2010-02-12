
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
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
	public void init(XmlPullParser parser) {
		Element personElem = (Element) XppUtils.getChildElementByName(parser, "person");
		if (personElem != null) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(personElem);
			setPerson(personImpl);
		}
		Element jobElem = (Element) XppUtils.getChildElementByName(parser, "job");
		if (jobElem != null) {
			JobImpl jobImpl = new JobImpl();
			jobImpl.init(jobElem);
			setJob(jobImpl);
		}
		Element questionElem = (Element) XppUtils.getChildElementByName(parser, "question");
		if (questionElem != null) {
			QuestionImpl questionImpl = new QuestionImpl();
			questionImpl.init(questionElem);
			setQuestion(questionImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("update-content");
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(serializer));
		}
		if (getJob() != null) {
			element.appendChild(((JobImpl) getJob()).toXml(serializer));
		}
		if (getQuestion() != null) {
			element.appendChild(((QuestionImpl) getQuestion()).toXml(serializer));
		}
		return element;
	}
}
