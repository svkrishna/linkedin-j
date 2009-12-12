
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.Url;

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
    protected UrlImpl siteStandardProfileRequest;
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

    public Url getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    public void setSiteStandardProfileRequest(Url value) {
        this.siteStandardProfileRequest = ((UrlImpl) value);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
