
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		
		Element positionElem = (Element) XppUtils.getChildElementByName(parser, "position");
		if (positionElem != null) {
			PositionImpl position = new PositionImpl();
			position.init(positionElem);
			setPosition(position);
		}
		Element companyElem = (Element) XppUtils.getChildElementByName(parser, "company");
		if (companyElem != null) {
			CompanyImpl company = new CompanyImpl();
			company.init(companyElem);
			setCompany(company);
		}
		Element jobPosterElem = (Element) XppUtils.getChildElementByName(parser, "job-poster");
		if (jobPosterElem != null) {
			JobPosterImpl jobPoster = new JobPosterImpl();
			jobPoster.init(jobPosterElem);
			setJobPoster(jobPoster);
		}
		Element siteRequestElem = (Element) XppUtils.getChildElementByName(parser, "site-job-request");
		if (siteRequestElem != null) {
			SiteJobRequestImpl apiRequest = new SiteJobRequestImpl();
			apiRequest.init(siteRequestElem);
			setSiteJobRequest(apiRequest);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("job");
		XppUtils.setElementValueToNode(element, "id", getId());
		if (getPosition() != null) {
			element.appendChild(((PositionImpl) getPosition()).toXml(serializer));
		}
		if (getCompany() != null) {
			element.appendChild(((CompanyImpl) getCompany()).toXml(serializer));
		}
		if (getJobPoster() != null) {
			element.appendChild(((JobPosterImpl) getJobPoster()).toXml(serializer));
		}
		if (getSiteJobRequest() != null) {
			element.appendChild(((SiteJobRequestImpl) getSiteJobRequest()).toXml(serializer));
		}
		return element;
	}
}
