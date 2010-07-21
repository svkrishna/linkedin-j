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

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobPoster;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.SiteJobRequest;

public class JobImpl
	extends BaseSchemaEntity
    implements Job
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected PositionImpl position;
    protected CompanyImpl company;
    protected JobPosterImpl jobPoster;
    protected SiteJobRequestImpl siteJobRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position value) {
        this.position = ((PositionImpl) value);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

    public JobPoster getJobPoster() {
        return jobPoster;
    }

    public void setJobPoster(JobPoster value) {
        this.jobPoster = ((JobPosterImpl) value);
    }

    public SiteJobRequest getSiteJobRequest() {
        return siteJobRequest;
    }

    public void setSiteJobRequest(SiteJobRequest value) {
        this.siteJobRequest = ((SiteJobRequestImpl) value);
    }
    
	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		
		Element positionElem = (Element) DomUtils.getChildElementByName(element, "position");
		if (positionElem != null) {
			PositionImpl position = new PositionImpl();
			position.init(positionElem);
			setPosition(position);
		}
		Element companyElem = (Element) DomUtils.getChildElementByName(element, "company");
		if (companyElem != null) {
			CompanyImpl company = new CompanyImpl();
			company.init(companyElem);
			setCompany(company);
		}
		Element jobPosterElem = (Element) DomUtils.getChildElementByName(element, "job-poster");
		if (jobPosterElem != null) {
			JobPosterImpl jobPoster = new JobPosterImpl();
			jobPoster.init(jobPosterElem);
			setJobPoster(jobPoster);
		}
		Element siteRequestElem = (Element) DomUtils.getChildElementByName(element, "site-job-request");
		if (siteRequestElem != null) {
			SiteJobRequestImpl apiRequest = new SiteJobRequestImpl();
			apiRequest.init(siteRequestElem);
			setSiteJobRequest(apiRequest);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("job");
		DomUtils.setElementValueToNode(element, "id", getId());
		if (getPosition() != null) {
			element.appendChild(((PositionImpl) getPosition()).toXml(document));
		}
		if (getCompany() != null) {
			element.appendChild(((CompanyImpl) getCompany()).toXml(document));
		}
		if (getJobPoster() != null) {
			element.appendChild(((JobPosterImpl) getJobPoster()).toXml(document));
		}
		if (getSiteJobRequest() != null) {
			element.appendChild(((SiteJobRequestImpl) getSiteJobRequest()).toXml(document));
		}
		return element;
	}
}
