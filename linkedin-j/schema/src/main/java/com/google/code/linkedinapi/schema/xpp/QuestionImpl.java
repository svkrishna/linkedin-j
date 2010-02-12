
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setTitle(XppUtils.getElementValueFromNode(parser, "title"));
		setWebUrl(XppUtils.getElementValueFromNode(parser, "web-url"));
		
		Element authorElem = (Element) XppUtils.getChildElementByName(parser, "author");
		if (authorElem != null) {
			AuthorImpl author = new AuthorImpl();
			author.init(authorElem);
			setAuthor(author);
		}
		Element categoryElem = (Element) XppUtils.getChildElementByName(parser, "question-categories");
		if (categoryElem != null) {
			QuestionCategoriesImpl categories = new QuestionCategoriesImpl();
			categories.init(categoryElem);
			setQuestionCategories(categories);
		}
		Element answersElem = (Element) XppUtils.getChildElementByName(parser, "answers");
		if (answersElem != null) {
			AnswersImpl answers = new AnswersImpl();
			answers.init(answersElem);
			setAnswers(answers);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("question");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "title", getTitle());
		XppUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getAuthor() != null) {
			element.appendChild(((AuthorImpl) getAuthor()).toXml(serializer));
		}
		if (getQuestionCategories() != null) {
			element.appendChild(((QuestionCategoriesImpl) getQuestionCategories()).toXml(serializer));
		}
		if (getAnswers() != null) {
			element.appendChild(((AnswersImpl) getAnswers()).toXml(serializer));
		}
		return element;
	}
}
