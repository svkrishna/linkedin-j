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
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setWebUrl(DomUtils.getElementValueFromNode(element, "web-url"));
		
		Element authorElem = (Element) DomUtils.getChildElementByName(element, "author");
		if (authorElem != null) {
			AuthorImpl author = new AuthorImpl();
			author.init(authorElem);
			setAuthor(author);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("answer");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getAuthor() != null) {
			element.appendChild(((AuthorImpl) getAuthor()).toXml(document));
		}
		return element;
	}
}
