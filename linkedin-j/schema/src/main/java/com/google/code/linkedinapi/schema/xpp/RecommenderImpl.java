
package com.google.code.linkedinapi.schema.xpp;

import java.io.Serializable;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Recommender;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class RecommenderImpl
	extends BaseSchemaEntity
    implements Serializable, Recommender
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
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
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setFirstName(XppUtils.getElementValueFromNode(parser, "first-name"));
		setLastName(XppUtils.getElementValueFromNode(parser, "last-name"));
		setHeadline(XppUtils.getElementValueFromNode(parser, "headline"));
		
		Element apiRequestElem = (Element) XppUtils.getChildElementByName(parser, "api-standard-profile-request");
		if (apiRequestElem != null) {
			ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
			apiRequest.init(apiRequestElem);
			setApiStandardProfileRequest(apiRequest);
		}
		Element siteRequestElem = (Element) XppUtils.getChildElementByName(parser, "site-standard-profile-request");
		if (siteRequestElem != null) {
			SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
			apiRequest.init(siteRequestElem);
			setSiteStandardProfileRequest(apiRequest);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("recommender");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "first-name", getFirstName());
		XppUtils.setElementValueToNode(element, "last-name", getLastName());
		XppUtils.setElementValueToNode(element, "headline", getHeadline());
		if (getApiStandardProfileRequest() != null) {
			element.appendChild(((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(serializer));
		}
		if (getSiteStandardProfileRequest() != null) {
			element.appendChild(((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(serializer));
		}
		return element;
	}
}
