
package com.google.code.linkedinapi.schema.dom;

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

}
