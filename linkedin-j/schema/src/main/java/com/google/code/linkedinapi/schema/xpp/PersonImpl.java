
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MemberGroups;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.PersonActivities;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.RecommendationsGiven;
import com.google.code.linkedinapi.schema.RecommendationsReceived;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class PersonImpl
    extends BaseSchemaEntity
    implements Person
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1783387499401345056L;
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
    protected String publicProfileUrl;
    protected String interests;
    protected String associations;
    protected String honors;
    protected String specialties;
    protected PositionsImpl positions;
    protected EducationsImpl educations;
    protected MemberUrlResourcesImpl memberUrlResources;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;
    protected RecommendationsGivenImpl recommendationsGiven;
    protected RecommendationsReceivedImpl recommendationsReceived;
    protected MemberGroupsImpl memberGroups;
    protected PersonActivitiesImpl personActivities;
    
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
    
    public String getPublicProfileUrl() {
        return publicProfileUrl;
    }

    public void setPublicProfileUrl(String value) {
        this.publicProfileUrl = value;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String value) {
        this.interests = value;
    }

    public String getAssociations() {
        return associations;
    }

    public void setAssociations(String value) {
        this.associations = value;
    }

    public String getHonors() {
        return honors;
    }

    public void setHonors(String value) {
        this.honors = value;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String value) {
        this.specialties = value;
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
    
    public RecommendationsGiven getRecommendationsGiven() {
        return recommendationsGiven;
    }

    public void setRecommendationsGiven(RecommendationsGiven value) {
        this.recommendationsGiven = ((RecommendationsGivenImpl) value);
    }
    
    public RecommendationsReceived getRecommendationsReceived() {
        return recommendationsReceived;
    }

    public void setRecommendationsReceived(RecommendationsReceived value) {
        this.recommendationsReceived = ((RecommendationsReceivedImpl) value);
    }

    public MemberGroups getMemberGroups() {
        return memberGroups;
    }

    public void setMemberGroups(MemberGroups value) {
        this.memberGroups = ((MemberGroupsImpl) value);
    }

    public PersonActivities getPersonActivities() {
        return personActivities;
    }

    public void setPersonActivities(PersonActivities value) {
        this.personActivities = ((PersonActivitiesImpl) value);
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
	public void init(XmlPullParser parser) {
		setPath(parser.getAttribute("path"));
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setFirstName(XppUtils.getElementValueFromNode(parser, "first-name"));
		setLastName(XppUtils.getElementValueFromNode(parser, "last-name"));
		setHeadline(XppUtils.getElementValueFromNode(parser, "headline"));
		setIndustry(XppUtils.getElementValueFromNode(parser, "industry"));
		setNumRecommenders(XppUtils.getElementValueAsLongFromNode(parser, "num-recommenders"));
		setDistance(XppUtils.getElementValueAsLongFromNode(parser, "distance"));
		setCurrentStatus(XppUtils.getElementValueFromNode(parser, "current-status"));
		setCurrentStatusTimestamp(XppUtils.getElementValueAsLongFromNode(parser, "current-status-timestamp"));
		setPictureUrl(XppUtils.getElementValueFromNode(parser, "picture-url"));
		setSummary(XppUtils.getElementValueFromNode(parser, "summary"));
		setPublicProfileUrl(XppUtils.getElementValueFromNode(parser, "public-profile-url"));
		setInterests(XppUtils.getElementValueFromNode(parser, "interests"));
		setAssociations(XppUtils.getElementValueFromNode(parser, "associations"));
		setHonors(XppUtils.getElementValueFromNode(parser, "honors"));
		setSpecialties(XppUtils.getElementValueFromNode(parser, "specialties"));
		
		Element locationElem = (Element) XppUtils.getChildElementByName(parser, "location");
		if (locationElem != null) {
			LocationImpl location = new LocationImpl();
			location.init(locationElem);
			setLocation(location);
		}
		Element connectionsElem = (Element) XppUtils.getChildElementByName(parser, "connections");
		if (connectionsElem != null) {
			ConnectionsImpl connections = new ConnectionsImpl();
			connections.init(connectionsElem);
			setConnections(connections);
		}
		Element relationElem = (Element) XppUtils.getChildElementByName(parser, "relation-to-viewer");
		if (relationElem != null) {
			RelationToViewerImpl relation = new RelationToViewerImpl();
			relation.init(relationElem);
			setRelationToViewer(relation);
		}
		Element positionElem = (Element) XppUtils.getChildElementByName(parser, "positions");
		if (positionElem != null) {
			PositionsImpl position = new PositionsImpl();
			position.init(positionElem);
			setPositions(position);
		}
		Element educationsElem = (Element) XppUtils.getChildElementByName(parser, "educations");
		if (educationsElem != null) {
			EducationsImpl educations = new EducationsImpl();
			educations.init(educationsElem);
			setEducations(educations);
		}
		Element memberUrlElem = (Element) XppUtils.getChildElementByName(parser, "member-url-resources");
		if (memberUrlElem != null) {
			MemberUrlResourcesImpl memberUrl = new MemberUrlResourcesImpl();
			memberUrl.init(memberUrlElem);
			setMemberUrlResources(memberUrl);
		}
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
		Element recommendationsGivenElem = (Element) XppUtils.getChildElementByName(parser, "recommendations-given");
		if (recommendationsGivenElem != null) {
			RecommendationsGivenImpl recommendation = new RecommendationsGivenImpl();
			recommendation.init(recommendationsGivenElem);
			setRecommendationsGiven(recommendation);
		}
		Element recommendationsReceivedElem = (Element) XppUtils.getChildElementByName(parser, "recommendations-received");
		if (recommendationsReceivedElem != null) {
			RecommendationsReceivedImpl recommendation = new RecommendationsReceivedImpl();
			recommendation.init(recommendationsReceivedElem);
			setRecommendationsReceived(recommendation);
		}
		Element memberGroupsElem = (Element) XppUtils.getChildElementByName(parser, "member-groups");
		if (memberGroupsElem != null) {
			MemberGroupsImpl memberGroups = new MemberGroupsImpl();
			memberGroups.init(memberGroupsElem);
			setMemberGroups(memberGroups);
		}

		Element activitiesElem = (Element) XppUtils.getChildElementByName(parser, "person-activities");
		if (activitiesElem != null) {
			PersonActivitiesImpl activities = new PersonActivitiesImpl();
			activities.init(activitiesElem);
			setPersonActivities(activities);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("person");
		XppUtils.setAttributeValueToNode(element, "path", getPath());
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "first-name", getFirstName());
		XppUtils.setElementValueToNode(element, "last-name", getLastName());
		XppUtils.setElementValueToNode(element, "headline", getHeadline());
		XppUtils.setElementValueToNode(element, "industry", getIndustry());
		XppUtils.setElementValueToNode(element, "num-recommenders", getNumRecommenders());
		XppUtils.setElementValueToNode(element, "distance", getDistance());
		XppUtils.setElementValueToNode(element, "current-status", getCurrentStatus());
		XppUtils.setElementValueToNode(element, "current-status-timestamp", getCurrentStatusTimestamp());
		XppUtils.setElementValueToNode(element, "picture-url", getPictureUrl());
		XppUtils.setElementValueToNode(element, "summary", getSummary());
		XppUtils.setElementValueToNode(element, "public-profile-url", getPublicProfileUrl());
		XppUtils.setElementValueToNode(element, "interests", getInterests());
		XppUtils.setElementValueToNode(element, "associations", getAssociations());
		XppUtils.setElementValueToNode(element, "honors", getHonors());
		XppUtils.setElementValueToNode(element, "specialties", getSpecialties());
		if (getLocation() != null) {
			element.appendChild(((LocationImpl) getLocation()).toXml(serializer));
		}
		if (getConnections() != null) {
			element.appendChild(((ConnectionsImpl) getConnections()).toXml(serializer));
		}
		if (getRelationToViewer() != null) {
			element.appendChild(((RelationToViewerImpl) getRelationToViewer()).toXml(serializer));
		}
		if (getPositions() != null) {
			element.appendChild(((PositionsImpl) getPositions()).toXml(serializer));
		}
		if (getEducations() != null) {
			element.appendChild(((EducationsImpl) getEducations()).toXml(serializer));
		}
		if (getMemberUrlResources() != null) {
			element.appendChild(((MemberUrlResourcesImpl) getMemberUrlResources()).toXml(serializer));
		}
		if (getApiStandardProfileRequest() != null) {
			element.appendChild(((ApiStandardProfileRequestImpl) getApiStandardProfileRequest()).toXml(serializer));
		}
		if (getSiteStandardProfileRequest() != null) {
			element.appendChild(((SiteStandardProfileRequestImpl) getSiteStandardProfileRequest()).toXml(serializer));
		}
		if (getRecommendationsGiven() != null) {
			element.appendChild(((RecommendationsGivenImpl) getRecommendationsGiven()).toXml(serializer));
		}
		if (getRecommendationsReceived() != null) {
			element.appendChild(((RecommendationsReceivedImpl) getRecommendationsReceived()).toXml(serializer));
		}
		if (getMemberGroups() != null) {
			element.appendChild(((MemberGroupsImpl) getMemberGroups()).toXml(serializer));
		}
		if (getPersonActivities() != null) {
			element.appendChild(((PersonActivitiesImpl) getPersonActivities()).toXml(serializer));
		}
		
		return element;
	}
}
