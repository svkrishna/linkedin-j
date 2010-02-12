
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Answer;
import com.google.code.linkedinapi.schema.Author;

public class AnswerImpl
	extends BaseSchemaEntity
    implements Answer
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String webUrl;
    protected AuthorImpl author;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author value) {
        this.author = ((AuthorImpl) value);
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setWebUrl(XppUtils.getElementValueFromNode(parser, "web-url"));
		
		Element authorElem = (Element) XppUtils.getChildElementByName(parser, "author");
		if (authorElem != null) {
			AuthorImpl author = new AuthorImpl();
			author.init(authorElem);
			setAuthor(author);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("answer");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getAuthor() != null) {
			element.appendChild(((AuthorImpl) getAuthor()).toXml(serializer));
		}
		return element;
	}
}
