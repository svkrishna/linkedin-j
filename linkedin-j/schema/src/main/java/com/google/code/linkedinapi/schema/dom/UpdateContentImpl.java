/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		Element personElem = (Element) DomUtils.getChildElementByName(element, "person");
		if (personElem != null) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(personElem);
			setPerson(personImpl);
		}
		Element jobElem = (Element) DomUtils.getChildElementByName(element, "job");
		if (jobElem != null) {
			JobImpl jobImpl = new JobImpl();
			jobImpl.init(jobElem);
			setJob(jobImpl);
		}
		Element questionElem = (Element) DomUtils.getChildElementByName(element, "question");
		if (questionElem != null) {
			QuestionImpl questionImpl = new QuestionImpl();
			questionImpl.init(questionElem);
			setQuestion(questionImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("update-content");
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(document));
		}
		if (getJob() != null) {
			element.appendChild(((JobImpl) getJob()).toXml(document));
		}
		if (getQuestion() != null) {
			element.appendChild(((QuestionImpl) getQuestion()).toXml(document));
		}
		return element;
	}
}
