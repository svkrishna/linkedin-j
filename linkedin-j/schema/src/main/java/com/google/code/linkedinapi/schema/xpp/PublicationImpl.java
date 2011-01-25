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

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Authors;
import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.Publication;
import com.google.code.linkedinapi.schema.Publisher;

public class PublicationImpl
	extends BaseSchemaEntity
    implements Publication
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected DateImpl date;
    protected String id;
    protected String summary;
    protected String title;
    protected String url;
    protected AuthorsImpl authors;
    protected PublisherImpl publisher;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = ((DateImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors value) {
        this.authors = ((AuthorsImpl) value);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher value) {
        this.publisher = ((PublisherImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
