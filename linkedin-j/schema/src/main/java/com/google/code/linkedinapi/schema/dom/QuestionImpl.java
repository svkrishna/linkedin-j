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

import com.google.code.linkedinapi.schema.Answers;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.Question;
import com.google.code.linkedinapi.schema.QuestionCategories;

public class QuestionImpl
	extends BaseSchemaEntity
    implements Question
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String title;
    protected AuthorImpl author;
    protected QuestionCategoriesImpl questionCategories;
    protected String webUrl;
    protected AnswersImpl answers;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = ((AuthorImpl) value);
    }

    public QuestionCategories getQuestionCategories() {
        return questionCategories;
    }

    public void setQuestionCategories(QuestionCategories value) {
        this.questionCategories = ((QuestionCategoriesImpl) value);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers value) {
        this.answers = ((AnswersImpl) value);
    }

	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setTitle(DomUtils.getElementValueFromNode(element, "title"));
		setWebUrl(DomUtils.getElementValueFromNode(element, "web-url"));
		
		Element authorElem = (Element) DomUtils.getChildElementByName(element, "author");
		if (authorElem != null) {
			AuthorImpl author = new AuthorImpl();
			author.init(authorElem);
			setAuthor(author);
		}
		Element categoryElem = (Element) DomUtils.getChildElementByName(element, "question-categories");
		if (categoryElem != null) {
			QuestionCategoriesImpl categories = new QuestionCategoriesImpl();
			categories.init(categoryElem);
			setQuestionCategories(categories);
		}
		Element answersElem = (Element) DomUtils.getChildElementByName(element, "answers");
		if (answersElem != null) {
			AnswersImpl answers = new AnswersImpl();
			answers.init(answersElem);
			setAnswers(answers);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("question");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "title", getTitle());
		DomUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getAuthor() != null) {
			element.appendChild(((AuthorImpl) getAuthor()).toXml(document));
		}
		if (getQuestionCategories() != null) {
			element.appendChild(((QuestionCategoriesImpl) getQuestionCategories()).toXml(document));
		}
		if (getAnswers() != null) {
			element.appendChild(((AnswersImpl) getAnswers()).toXml(document));
		}
		return element;
	}
}
