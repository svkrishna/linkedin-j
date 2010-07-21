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

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Author;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class AuthorImpl
	extends BaseSchemaEntity
    implements Author
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
    protected RelationToViewerImpl relationToViewer;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String value) {
        this.headline = value;
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public ApiStandardProfileRequest getApiStandardProfileRequest() {
        return apiStandardProfileRequest;
    }

    public void setApiStandardProfileRequest(ApiStandardProfileRequest value) {
        this.apiStandardProfileRequest = ((ApiStandardProfileRequestImpl) value);
    }

    public SiteStandardProfileRequest getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    public void setSiteStandardProfileRequest(SiteStandardProfileRequest value) {
        this.siteStandardProfileRequest = ((SiteStandardProfileRequestImpl) value);
    }
    
	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setFirstName(DomUtils.getElementValueFromNode(element, "first-name"));
		setLastName(DomUtils.getElementValueFromNode(element, "last-name"));
		setHeadline(DomUtils.getElementValueFromNode(element, "headline"));
		
		Element relationElem = (Element) DomUtils.getChildElementByName(element, "relation-to-viewer");
		if (relationElem != null) {
			RelationToViewerImpl relation = new RelationToViewerImpl();
			relation.init(relationElem);
			setRelationToViewer(relation);
		}
		Element apiRequestElem = (Element) DomUtils.getChildElementByName(element, "api-standard-profile-request");
		if (apiRequestElem != null) {
			ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
			apiRequest.init(apiRequestElem);
			setApiStandardProfileRequest(apiRequest);
		}
		Element siteRequestElem = (Element) DomUtils.getChildElementByName(element, "site-standard-profile-request");
		if (siteRequestElem != null) {
			SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
			apiRequest.init(siteRequestElem);
			setSiteStandardProfileRequest(apiRequest);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("author");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "first-name", getFirstName());
		DomUtils.setElementValueToNode(element, "last-name", getLastName());
		DomUtils.setElementValueToNode(element, "headline", getHeadline());
		if (getRelationToViewer() != null) {
			element.appendChild(((RelationToViewerImpl) getRelationToViewer()).toXml(document));
		}
		if (getApiStandardProfileRequest() != null) {
			element.appendChild(((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(document));
		}
		if (getSiteStandardProfileRequest() != null) {
			element.appendChild(((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(document));
		}
		return element;
	}
}
