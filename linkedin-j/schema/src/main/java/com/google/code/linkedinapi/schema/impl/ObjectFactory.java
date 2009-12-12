
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;
import com.google.code.linkedinapi.schema.ItemContent;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.Property;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.Recipients;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateContent;
import com.google.code.linkedinapi.schema.Updates;
import com.google.code.linkedinapi.schema.Url;
import com.google.code.linkedinapi.schema.Year;
import org.w3._2001.xmlschema.Adapter1;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.google.code.linkedinapi.schema.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ContentType_QNAME = new QName("", "content-type");
    private final static QName _Headline_QNAME = new QName("", "headline");
    private final static QName _Summary_QNAME = new QName("", "summary");
    private final static QName _Body_QNAME = new QName("", "body");
    private final static QName _SiteStandardProfileRequest_QNAME = new QName("", "site-standard-profile-request");
    private final static QName _Subject_QNAME = new QName("", "subject");
    private final static QName _CurrentStatus_QNAME = new QName("", "current-status");
    private final static QName _IsCommentable_QNAME = new QName("", "is-commentable");
    private final static QName _ErrorCode_QNAME = new QName("", "error-code");
    private final static QName _CurrentStatusTimestamp_QNAME = new QName("", "current-status-timestamp");
    private final static QName _Type_QNAME = new QName("", "type");
    private final static QName _NumRecommenders_QNAME = new QName("", "num-recommenders");
    private final static QName _IsCurrent_QNAME = new QName("", "is-current");
    private final static QName _Timestamp_QNAME = new QName("", "timestamp");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _ConnectType_QNAME = new QName("", "connect-type");
    private final static QName _Distance_QNAME = new QName("", "distance");
    private final static QName _Title_QNAME = new QName("", "title");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Value_QNAME = new QName("", "value");
    private final static QName _Year_QNAME = new QName("", "year");
    private final static QName _LastName_QNAME = new QName("", "last-name");
    private final static QName _Industry_QNAME = new QName("", "industry");
    private final static QName _SchoolName_QNAME = new QName("", "school-name");
    private final static QName _EndDate_QNAME = new QName("", "end-date");
    private final static QName _UpdateType_QNAME = new QName("", "update-type");
    private final static QName _Status_QNAME = new QName("", "status");
    private final static QName _Code_QNAME = new QName("", "code");
    private final static QName _Url_QNAME = new QName("", "url");
    private final static QName _UpdateKey_QNAME = new QName("", "update-key");
    private final static QName _Message_QNAME = new QName("", "message");
    private final static QName _Degree_QNAME = new QName("", "degree");
    private final static QName _FirstName_QNAME = new QName("", "first-name");
    private final static QName _Month_QNAME = new QName("", "month");
    private final static QName _Comment_QNAME = new QName("", "comment");
    private final static QName _PictureUrl_QNAME = new QName("", "picture-url");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.google.code.linkedinapi.schema.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public AuthorizationImpl createAuthorization() {
        return new AuthorizationImpl();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public CompanyImpl createCompany() {
        return new CompanyImpl();
    }

    /**
     * Create an instance of {@link Recipient }
     * 
     */
    public RecipientImpl createRecipient() {
        return new RecipientImpl();
    }

    /**
     * Create an instance of {@link People }
     * 
     */
    public PeopleImpl createPeople() {
        return new PeopleImpl();
    }

    /**
     * Create an instance of {@link MailboxItem }
     * 
     */
    public MailboxItemImpl createMailboxItem() {
        return new MailboxItemImpl();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public ActivityImpl createActivity() {
        return new ActivityImpl();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public PositionImpl createPosition() {
        return new PositionImpl();
    }

    /**
     * Create an instance of {@link Year }
     * 
     */
    public YearImpl createYear() {
        return new YearImpl();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public CountryImpl createCountry() {
        return new CountryImpl();
    }

    /**
     * Create an instance of {@link MemberUrlResources }
     * 
     */
    public MemberUrlResourcesImpl createMemberUrlResources() {
        return new MemberUrlResourcesImpl();
    }

    /**
     * Create an instance of {@link ApiStandardProfileRequest }
     * 
     */
    public ApiStandardProfileRequestImpl createApiStandardProfileRequest() {
        return new ApiStandardProfileRequestImpl();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public LocationImpl createLocation() {
        return new LocationImpl();
    }

    /**
     * Create an instance of {@link InvitationRequest }
     * 
     */
    public InvitationRequestImpl createInvitationRequest() {
        return new InvitationRequestImpl();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public UpdateImpl createUpdate() {
        return new UpdateImpl();
    }

    /**
     * Create an instance of {@link UpdateContent }
     * 
     */
    public UpdateContentImpl createUpdateContent() {
        return new UpdateContentImpl();
    }

    /**
     * Create an instance of {@link MemberUrl }
     * 
     */
    public MemberUrlImpl createMemberUrl() {
        return new MemberUrlImpl();
    }

    /**
     * Create an instance of {@link Network }
     * 
     */
    public NetworkImpl createNetwork() {
        return new NetworkImpl();
    }

    /**
     * Create an instance of {@link Headers }
     * 
     */
    public HeadersImpl createHeaders() {
        return new HeadersImpl();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public PersonImpl createPerson() {
        return new PersonImpl();
    }

    /**
     * Create an instance of {@link Url }
     * 
     */
    public UrlImpl createUrl() {
        return new UrlImpl();
    }

    /**
     * Create an instance of {@link NetworkStats }
     * 
     */
    public NetworkStatsImpl createNetworkStats() {
        return new NetworkStatsImpl();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public PropertyImpl createProperty() {
        return new PropertyImpl();
    }

    /**
     * Create an instance of {@link Positions }
     * 
     */
    public PositionsImpl createPositions() {
        return new PositionsImpl();
    }

    /**
     * Create an instance of {@link Education }
     * 
     */
    public EducationImpl createEducation() {
        return new EducationImpl();
    }

    /**
     * Create an instance of {@link UpdateComment }
     * 
     */
    public UpdateCommentImpl createUpdateComment() {
        return new UpdateCommentImpl();
    }

    /**
     * Create an instance of {@link Updates }
     * 
     */
    public UpdatesImpl createUpdates() {
        return new UpdatesImpl();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public ErrorImpl createError() {
        return new ErrorImpl();
    }

    /**
     * Create an instance of {@link Connections }
     * 
     */
    public ConnectionsImpl createConnections() {
        return new ConnectionsImpl();
    }

    /**
     * Create an instance of {@link ItemContent }
     * 
     */
    public ItemContentImpl createItemContent() {
        return new ItemContentImpl();
    }

    /**
     * Create an instance of {@link Recipients }
     * 
     */
    public RecipientsImpl createRecipients() {
        return new RecipientsImpl();
    }

    /**
     * Create an instance of {@link StartDate }
     * 
     */
    public StartDateImpl createStartDate() {
        return new StartDateImpl();
    }

    /**
     * Create an instance of {@link RelationToViewer }
     * 
     */
    public RelationToViewerImpl createRelationToViewer() {
        return new RelationToViewerImpl();
    }

    /**
     * Create an instance of {@link HttpHeader }
     * 
     */
    public HttpHeaderImpl createHttpHeader() {
        return new HttpHeaderImpl();
    }

    /**
     * Create an instance of {@link Educations }
     * 
     */
    public EducationsImpl createEducations() {
        return new EducationsImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkUpdateContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "content-type")
    public JAXBElement<NetworkUpdateContentType> createContentType(NetworkUpdateContentType value) {
        return new JAXBElement<NetworkUpdateContentType>(_ContentType_QNAME, NetworkUpdateContentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "headline")
    public JAXBElement<String> createHeadline(String value) {
        return new JAXBElement<String>(_Headline_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "summary")
    public JAXBElement<String> createSummary(String value) {
        return new JAXBElement<String>(_Summary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "body")
    public JAXBElement<String> createBody(String value) {
        return new JAXBElement<String>(_Body_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UrlImpl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "site-standard-profile-request")
    public JAXBElement<UrlImpl> createSiteStandardProfileRequest(UrlImpl value) {
        return new JAXBElement<UrlImpl>(_SiteStandardProfileRequest_QNAME, UrlImpl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subject")
    public JAXBElement<String> createSubject(String value) {
        return new JAXBElement<String>(_Subject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "current-status")
    public JAXBElement<String> createCurrentStatus(String value) {
        return new JAXBElement<String>(_CurrentStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-commentable")
    public JAXBElement<Boolean> createIsCommentable(Boolean value) {
        return new JAXBElement<Boolean>(_IsCommentable_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "error-code")
    public JAXBElement<String> createErrorCode(String value) {
        return new JAXBElement<String>(_ErrorCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "current-status-timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createCurrentStatusTimestamp(Long value) {
        return new JAXBElement<Long>(_CurrentStatusTimestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type")
    public JAXBElement<String> createType(String value) {
        return new JAXBElement<String>(_Type_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "num-recommenders")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createNumRecommenders(Long value) {
        return new JAXBElement<Long>(_NumRecommenders_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is-current")
    public JAXBElement<Boolean> createIsCurrent(Boolean value) {
        return new JAXBElement<Boolean>(_IsCurrent_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "timestamp")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createTimestamp(Long value) {
        return new JAXBElement<Long>(_Timestamp_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InviteConnectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "connect-type")
    public JAXBElement<InviteConnectType> createConnectType(InviteConnectType value) {
        return new JAXBElement<InviteConnectType>(_ConnectType_QNAME, InviteConnectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "distance")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createDistance(Long value) {
        return new JAXBElement<Long>(_Distance_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title")
    public JAXBElement<String> createTitle(String value) {
        return new JAXBElement<String>(_Title_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createValue(String value) {
        return new JAXBElement<String>(_Value_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "year")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createYear(Long value) {
        return new JAXBElement<Long>(_Year_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "last-name")
    public JAXBElement<String> createLastName(String value) {
        return new JAXBElement<String>(_LastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "industry")
    public JAXBElement<String> createIndustry(String value) {
        return new JAXBElement<String>(_Industry_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "school-name")
    public JAXBElement<String> createSchoolName(String value) {
        return new JAXBElement<String>(_SchoolName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YearImpl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "end-date")
    public JAXBElement<YearImpl> createEndDate(YearImpl value) {
        return new JAXBElement<YearImpl>(_EndDate_QNAME, YearImpl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkUpdateReturnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "update-type")
    public JAXBElement<NetworkUpdateReturnType> createUpdateType(NetworkUpdateReturnType value) {
        return new JAXBElement<NetworkUpdateReturnType>(_UpdateType_QNAME, NetworkUpdateReturnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createStatus(Long value) {
        return new JAXBElement<Long>(_Status_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "url")
    public JAXBElement<String> createUrl(String value) {
        return new JAXBElement<String>(_Url_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "update-key")
    public JAXBElement<String> createUpdateKey(String value) {
        return new JAXBElement<String>(_UpdateKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "degree")
    public JAXBElement<String> createDegree(String value) {
        return new JAXBElement<String>(_Degree_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "first-name")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "month")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createMonth(Long value) {
        return new JAXBElement<Long>(_Month_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "comment")
    public JAXBElement<String> createComment(String value) {
        return new JAXBElement<String>(_Comment_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "picture-url")
    public JAXBElement<String> createPictureUrl(String value) {
        return new JAXBElement<String>(_PictureUrl_QNAME, String.class, null, value);
    }

}
