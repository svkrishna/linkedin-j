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

import java.io.Serializable;
import com.google.code.linkedinapi.schema.Content;

public class ContentImpl
    implements Serializable, Content
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String title;
    protected String submittedUrl;
    protected String shortenedUrl;
    protected String submittedImageUrl;
    protected String thumbnailUrl;

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

    public String getSubmittedUrl() {
        return submittedUrl;
    }

    public void setSubmittedUrl(String value) {
        this.submittedUrl = value;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String value) {
        this.shortenedUrl = value;
    }

    public String getSubmittedImageUrl() {
        return submittedImageUrl;
    }

    public void setSubmittedImageUrl(String value) {
        this.submittedImageUrl = value;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String value) {
        this.thumbnailUrl = value;
    }

}
