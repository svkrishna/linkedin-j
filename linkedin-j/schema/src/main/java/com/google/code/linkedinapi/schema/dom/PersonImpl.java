
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class PersonImpl
    extends BaseSchemaEntity
    implements Person
{

    protected String id;
    protected String firstName;
    protected String lastName;
    protected String headline;
    protected LocationImpl location;
    protected String industry;
    protected ConnectionsImpl connections;
    protected String currentStatus;
    protected Long distance;
    protected Long currentStatusTimestamp;
    protected Long numRecommenders;
    protected RelationToViewerImpl relationToViewer;
    protected String summary;
    protected PositionsImpl positions;
    protected EducationsImpl educations;
    protected MemberUrlResourcesImpl memberUrlResources;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;
    protected String pictureUrl;
    protected String path;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = ((LocationImpl) value);
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String value) {
        this.industry = value;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections value) {
        this.connections = ((ConnectionsImpl) value);
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String value) {
        this.currentStatus = value;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

    public Long getCurrentStatusTimestamp() {
        return currentStatusTimestamp;
    }

    public void setCurrentStatusTimestamp(Long value) {
        this.currentStatusTimestamp = value;
    }

    public Long getNumRecommenders() {
        return numRecommenders;
    }

    public void setNumRecommenders(Long value) {
        this.numRecommenders = value;
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions value) {
        this.positions = ((PositionsImpl) value);
    }

    public Educations getEducations() {
        return educations;
    }

    public void setEducations(Educations value) {
        this.educations = ((EducationsImpl) value);
    }

    public MemberUrlResources getMemberUrlResources() {
        return memberUrlResources;
    }

    public void setMemberUrlResources(MemberUrlResources value) {
        this.memberUrlResources = ((MemberUrlResourcesImpl) value);
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String value) {
        this.pictureUrl = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

	@Override
	public void init(Element element) {
		setPath(element.getAttribute("path"));
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setFirstName(DomUtils.getElementValueFromNode(element, "first-name"));
		setLastName(DomUtils.getElementValueFromNode(element, "last-name"));
		setHeadline(DomUtils.getElementValueFromNode(element, "headline"));
		setIndustry(DomUtils.getElementValueFromNode(element, "industry"));
		setNumRecommenders(DomUtils.getElementValueAsLongFromNode(element, "num-recommenders"));
		setDistance(DomUtils.getElementValueAsLongFromNode(element, "distance"));
		setCurrentStatus(DomUtils.getElementValueFromNode(element, "current-status"));
		setCurrentStatusTimestamp(DomUtils.getElementValueAsLongFromNode(element, "current-status-timestamp"));
		setPictureUrl(DomUtils.getElementValueFromNode(element, "picture-url"));
		setSummary(DomUtils.getElementValueFromNode(element, "summary"));
		
		Element locationElem = (Element) DomUtils.getChildNode(element, "location");
		if (locationElem != null) {
			LocationImpl location = new LocationImpl();
			location.init(locationElem);
			setLocation(location);
		}
		Element connectionsElem = (Element) DomUtils.getChildNode(element, "connections");
		if (connectionsElem != null) {
			ConnectionsImpl connections = new ConnectionsImpl();
			connections.init(connectionsElem);
			setConnections(connections);
		}
		Element relationElem = (Element) DomUtils.getChildNode(element, "relation-to-viewer");
		if (relationElem != null) {
			RelationToViewerImpl relation = new RelationToViewerImpl();
			relation.init(relationElem);
			setRelationToViewer(relation);
		}
		Element positionElem = (Element) DomUtils.getChildNode(element, "positions");
		if (positionElem != null) {
			PositionsImpl position = new PositionsImpl();
			position.init(positionElem);
			setPositions(position);
		}
		Element educationsElem = (Element) DomUtils.getChildNode(element, "educations");
		if (educationsElem != null) {
			EducationsImpl educations = new EducationsImpl();
			educations.init(educationsElem);
			setEducations(educations);
		}
		Element memberUrlElem = (Element) DomUtils.getChildNode(element, "member-url-resources");
		if (memberUrlElem != null) {
			MemberUrlResourcesImpl memberUrl = new MemberUrlResourcesImpl();
			memberUrl.init(memberUrlElem);
			setMemberUrlResources(memberUrl);
		}
		Element apiRequestElem = (Element) DomUtils.getChildNode(element, "api-standard-profile-request");
		if (apiRequestElem != null) {
			ApiStandardProfileRequestImpl apiRequest = new ApiStandardProfileRequestImpl();
			apiRequest.init(apiRequestElem);
			setApiStandardProfileRequest(apiRequest);
		}
		Element siteRequestElem = (Element) DomUtils.getChildNode(element, "site-standard-profile-request");
		if (siteRequestElem != null) {
			SiteStandardProfileRequestImpl apiRequest = new SiteStandardProfileRequestImpl();
			apiRequest.init(siteRequestElem);
			setSiteStandardProfileRequest(apiRequest);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("person");
		element.setAttribute("path", getPath());
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "first-name", getFirstName());
		DomUtils.setElementValueToNode(element, "last-name", getLastName());
		DomUtils.setElementValueToNode(element, "headline", getHeadline());
		DomUtils.setElementValueToNode(element, "industry", getIndustry());
		DomUtils.setElementValueToNode(element, "num-recommenders", String.valueOf(getNumRecommenders()));
		DomUtils.setElementValueToNode(element, "distance", String.valueOf(getDistance()));
		DomUtils.setElementValueToNode(element, "current-status", getCurrentStatus());
		DomUtils.setElementValueToNode(element, "current-status-timestamp", String.valueOf(getCurrentStatusTimestamp()));
		DomUtils.setElementValueToNode(element, "picture-url", getPictureUrl());
		DomUtils.setElementValueToNode(element, "summary", getSummary());
		if (getLocation() != null) {
			element.appendChild(((LocationImpl) getLocation()).toXml(document));
		}
		if (getConnections() != null) {
			element.appendChild(((ConnectionsImpl) getConnections()).toXml(document));
		}
		if (getRelationToViewer() != null) {
			element.appendChild(((RelationToViewerImpl) getRelationToViewer()).toXml(document));
		}
		if (getPositions() != null) {
			element.appendChild(((PositionsImpl) getPositions()).toXml(document));
		}
		if (getEducations() != null) {
			element.appendChild(((EducationsImpl) getEducations()).toXml(document));
		}
		if (getMemberUrlResources() != null) {
			element.appendChild(((MemberUrlResourcesImpl) getMemberUrlResources()).toXml(document));
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
