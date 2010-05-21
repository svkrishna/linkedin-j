
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.DateOfBirth;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.ImAccounts;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MemberGroups;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.PersonActivities;
import com.google.code.linkedinapi.schema.PhoneNumbers;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.RecommendationsGiven;
import com.google.code.linkedinapi.schema.RecommendationsReceived;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;
import com.google.code.linkedinapi.schema.ThreeCurrentPositions;
import com.google.code.linkedinapi.schema.ThreePastPositions;
import com.google.code.linkedinapi.schema.TwitterAccounts;

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
    protected ThreeCurrentPositionsImpl threeCurrentPositions;
    protected ThreePastPositionsImpl threePastPositions;
    protected PositionsImpl positions;
    protected EducationsImpl educations;
    protected MemberUrlResourcesImpl memberUrlResources;
    protected ApiStandardProfileRequestImpl apiStandardProfileRequest;
    protected SiteStandardProfileRequestImpl siteStandardProfileRequest;
    protected RecommendationsGivenImpl recommendationsGiven;
    protected RecommendationsReceivedImpl recommendationsReceived;
    protected MemberGroupsImpl memberGroups;
    protected PersonActivitiesImpl personActivities;
    protected ImAccountsImpl imAccounts;
    protected TwitterAccountsImpl twitterAccounts;
    protected DateOfBirthImpl dateOfBirth;
    protected String mainAddress;
    protected PhoneNumbersImpl phoneNumbers;
    
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

    public ThreeCurrentPositions getThreeCurrentPositions() {
        return threeCurrentPositions;
    }

    public void setThreeCurrentPositions(ThreeCurrentPositions value) {
        this.threeCurrentPositions = ((ThreeCurrentPositionsImpl) value);
    }

    public ThreePastPositions getThreePastPositions() {
        return threePastPositions;
    }

    public void setThreePastPositions(ThreePastPositions value) {
        this.threePastPositions = ((ThreePastPositionsImpl) value);
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
    
    public ImAccounts getImAccounts() {
        return imAccounts;
    }

    public void setImAccounts(ImAccounts value) {
        this.imAccounts = ((ImAccountsImpl) value);
    }

    public TwitterAccounts getTwitterAccounts() {
        return twitterAccounts;
    }

    public void setTwitterAccounts(TwitterAccounts value) {
        this.twitterAccounts = ((TwitterAccountsImpl) value);
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth value) {
        this.dateOfBirth = ((DateOfBirthImpl) value);
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String value) {
        this.mainAddress = value;
    }

    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumbers value) {
        this.phoneNumbers = ((PhoneNumbersImpl) value);
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
		setPublicProfileUrl(DomUtils.getElementValueFromNode(element, "public-profile-url"));
		setInterests(DomUtils.getElementValueFromNode(element, "interests"));
		setAssociations(DomUtils.getElementValueFromNode(element, "associations"));
		setHonors(DomUtils.getElementValueFromNode(element, "honors"));
		setSpecialties(DomUtils.getElementValueFromNode(element, "specialties"));
		setMainAddress(DomUtils.getElementValueFromNode(element, "main-address"));
		
		Element locationElem = (Element) DomUtils.getChildElementByName(element, "location");
		if (locationElem != null) {
			LocationImpl location = new LocationImpl();
			location.init(locationElem);
			setLocation(location);
		}
		Element connectionsElem = (Element) DomUtils.getChildElementByName(element, "connections");
		if (connectionsElem != null) {
			ConnectionsImpl connections = new ConnectionsImpl();
			connections.init(connectionsElem);
			setConnections(connections);
		}
		Element relationElem = (Element) DomUtils.getChildElementByName(element, "relation-to-viewer");
		if (relationElem != null) {
			RelationToViewerImpl relation = new RelationToViewerImpl();
			relation.init(relationElem);
			setRelationToViewer(relation);
		}
		Element positionElem = (Element) DomUtils.getChildElementByName(element, "positions");
		if (positionElem != null) {
			PositionsImpl position = new PositionsImpl();
			position.init(positionElem);
			setPositions(position);
		}
		Element currentPositionElem = (Element) DomUtils.getChildElementByName(element, "three-current-positions");
		if (currentPositionElem != null) {
			ThreeCurrentPositionsImpl position = new ThreeCurrentPositionsImpl();
			position.init(currentPositionElem);
			setThreeCurrentPositions(position);
		}
		Element pastPositionElem = (Element) DomUtils.getChildElementByName(element, "three-past-positions");
		if (pastPositionElem != null) {
			ThreePastPositionsImpl position = new ThreePastPositionsImpl();
			position.init(pastPositionElem);
			setThreePastPositions(position);
		}
		Element educationsElem = (Element) DomUtils.getChildElementByName(element, "educations");
		if (educationsElem != null) {
			EducationsImpl educations = new EducationsImpl();
			educations.init(educationsElem);
			setEducations(educations);
		}
		Element memberUrlElem = (Element) DomUtils.getChildElementByName(element, "member-url-resources");
		if (memberUrlElem != null) {
			MemberUrlResourcesImpl memberUrl = new MemberUrlResourcesImpl();
			memberUrl.init(memberUrlElem);
			setMemberUrlResources(memberUrl);
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
		Element recommendationsGivenElem = (Element) DomUtils.getChildElementByName(element, "recommendations-given");
		if (recommendationsGivenElem != null) {
			RecommendationsGivenImpl recommendation = new RecommendationsGivenImpl();
			recommendation.init(recommendationsGivenElem);
			setRecommendationsGiven(recommendation);
		}
		Element recommendationsReceivedElem = (Element) DomUtils.getChildElementByName(element, "recommendations-received");
		if (recommendationsReceivedElem != null) {
			RecommendationsReceivedImpl recommendation = new RecommendationsReceivedImpl();
			recommendation.init(recommendationsReceivedElem);
			setRecommendationsReceived(recommendation);
		}
		Element memberGroupsElem = (Element) DomUtils.getChildElementByName(element, "member-groups");
		if (memberGroupsElem != null) {
			MemberGroupsImpl memberGroups = new MemberGroupsImpl();
			memberGroups.init(memberGroupsElem);
			setMemberGroups(memberGroups);
		}

		Element activitiesElem = (Element) DomUtils.getChildElementByName(element, "person-activities");
		if (activitiesElem != null) {
			PersonActivitiesImpl activities = new PersonActivitiesImpl();
			activities.init(activitiesElem);
			setPersonActivities(activities);
		}
		Element imAccountsElem = (Element) DomUtils.getChildElementByName(element, "im-accounts");
		if (imAccountsElem != null) {
			ImAccountsImpl accounts = new ImAccountsImpl();
			accounts.init(imAccountsElem);
			setImAccounts(accounts);
		}
		Element twitterAccountsElem = (Element) DomUtils.getChildElementByName(element, "twitter-accounts");
		if (twitterAccountsElem != null) {
			TwitterAccountsImpl accounts = new TwitterAccountsImpl();
			accounts.init(twitterAccountsElem);
			setTwitterAccounts(accounts);
		}
		Element phoneNumbersElem = (Element) DomUtils.getChildElementByName(element, "phone-numbers");
		if (phoneNumbersElem != null) {
			PhoneNumbersImpl activities = new PhoneNumbersImpl();
			activities.init(phoneNumbersElem);
			setPhoneNumbers(activities);
		}
		Element dateOfBirthElem = (Element) DomUtils.getChildElementByName(element, "date-of-birth");
		if (dateOfBirthElem != null) {
			DateOfBirthImpl activities = new DateOfBirthImpl();
			activities.init(dateOfBirthElem);
			setDateOfBirth(activities);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("person");
		DomUtils.setAttributeValueToNode(element, "path", getPath());
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "first-name", getFirstName());
		DomUtils.setElementValueToNode(element, "last-name", getLastName());
		DomUtils.setElementValueToNode(element, "headline", getHeadline());
		DomUtils.setElementValueToNode(element, "industry", getIndustry());
		DomUtils.setElementValueToNode(element, "num-recommenders", getNumRecommenders());
		DomUtils.setElementValueToNode(element, "distance", getDistance());
		DomUtils.setElementValueToNode(element, "current-status", getCurrentStatus());
		DomUtils.setElementValueToNode(element, "current-status-timestamp", getCurrentStatusTimestamp());
		DomUtils.setElementValueToNode(element, "picture-url", getPictureUrl());
		DomUtils.setElementValueToNode(element, "summary", getSummary());
		DomUtils.setElementValueToNode(element, "public-profile-url", getPublicProfileUrl());
		DomUtils.setElementValueToNode(element, "interests", getInterests());
		DomUtils.setElementValueToNode(element, "associations", getAssociations());
		DomUtils.setElementValueToNode(element, "honors", getHonors());
		DomUtils.setElementValueToNode(element, "specialties", getSpecialties());
		DomUtils.setElementValueToNode(element, "main-address", getMainAddress());
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
		if (getThreeCurrentPositions() != null) {
			element.appendChild(((ThreeCurrentPositionsImpl) getThreeCurrentPositions()).toXml(document));
		}
		if (getThreePastPositions() != null) {
			element.appendChild(((ThreePastPositionsImpl) getThreePastPositions()).toXml(document));
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
		if (getRecommendationsGiven() != null) {
			element.appendChild(((RecommendationsGivenImpl) getRecommendationsGiven()).toXml(document));
		}
		if (getRecommendationsReceived() != null) {
			element.appendChild(((RecommendationsReceivedImpl) getRecommendationsReceived()).toXml(document));
		}
		if (getMemberGroups() != null) {
			element.appendChild(((MemberGroupsImpl) getMemberGroups()).toXml(document));
		}
		if (getPersonActivities() != null) {
			element.appendChild(((PersonActivitiesImpl) getPersonActivities()).toXml(document));
		}
		if (getImAccounts() != null) {
			element.appendChild(((ImAccountsImpl) getImAccounts()).toXml(document));
		}
		if (getTwitterAccounts() != null) {
			element.appendChild(((TwitterAccountsImpl) getTwitterAccounts()).toXml(document));
		}
		if (getDateOfBirth() != null) {
			element.appendChild(((DateOfBirthImpl) getDateOfBirth()).toXml(document));
		}
		if (getPhoneNumbers() != null) {
			element.appendChild(((PhoneNumbersImpl) getPhoneNumbers()).toXml(document));
		}
		
		return element;
	}
}
