
package com.google.code.linkedinapi.schema.sax;

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
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateContent;
import com.google.code.linkedinapi.schema.Updates;
import com.google.code.linkedinapi.schema.Url;
import com.google.code.linkedinapi.schema.Year;

public class SaxElementFactory implements SchemaElementFactory<String> {
	
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.google.code.linkedinapi.schema
     * 
     */
    public SaxElementFactory() {
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createAuthorization()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createAuthorization()
	 */
    public Authorization createAuthorization() {
        return new AuthorizationImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCompany()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCompany()
	 */
    public Company createCompany() {
        return new CompanyImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipient()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipient()
	 */
    public Recipient createRecipient() {
        return new RecipientImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPeople()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPeople()
	 */
    public People createPeople() {
        return new PeopleImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMailboxItem()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMailboxItem()
	 */
    public MailboxItem createMailboxItem() {
        return new MailboxItemImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createActivity()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createActivity()
	 */
    public Activity createActivity() {
        return new ActivityImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPosition()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPosition()
	 */
    public Position createPosition() {
        return new PositionImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear()
	 */
    public Year createYear() {
        return new YearImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCountry()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCountry()
	 */
    public Country createCountry() {
        return new CountryImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrlResources()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrlResources()
	 */
    public MemberUrlResources createMemberUrlResources() {
        return new MemberUrlResourcesImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createApiStandardProfileRequest()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createApiStandardProfileRequest()
	 */
    public ApiStandardProfileRequest createApiStandardProfileRequest() {
        return new ApiStandardProfileRequestImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLocation()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLocation()
	 */
    public Location createLocation() {
        return new LocationImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createInvitationRequest()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createInvitationRequest()
	 */
    public InvitationRequest createInvitationRequest() {
        return new InvitationRequestImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdate()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdate()
	 */
    public Update createUpdate() {
        return new UpdateImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateContent()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateContent()
	 */
    public UpdateContent createUpdateContent() {
        return new UpdateContentImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrl()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrl()
	 */
    public MemberUrl createMemberUrl() {
        return new MemberUrlImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetwork()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetwork()
	 */
    public Network createNetwork() {
        return new NetworkImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeaders()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeaders()
	 */
    public Headers createHeaders() {
        return new HeadersImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPerson()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPerson()
	 */
    public Person createPerson() {
        return new PersonImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl()
	 */
    public Url createUrl() {
        return new UrlImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetworkStats()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetworkStats()
	 */
    public NetworkStats createNetworkStats() {
        return new NetworkStatsImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createProperty()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createProperty()
	 */
    public Property createProperty() {
        return new PropertyImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPositions()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPositions()
	 */
    public Positions createPositions() {
        return new PositionsImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducation()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducation()
	 */
    public Education createEducation() {
        return new EducationImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateComment()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateComment()
	 */
    public UpdateComment createUpdateComment() {
        return new UpdateCommentImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdates()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdates()
	 */
    public Updates createUpdates() {
        return new UpdatesImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createError()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createError()
	 */
    public Error createError() {
        return new ErrorImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnections()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnections()
	 */
    public Connections createConnections() {
        return new ConnectionsImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createItemContent()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createItemContent()
	 */
    public ItemContent createItemContent() {
        return new ItemContentImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipients()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipients()
	 */
    public Recipients createRecipients() {
        return new RecipientsImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createStartDate()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createStartDate()
	 */
    public StartDate createStartDate() {
        return new StartDateImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRelationToViewer()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRelationToViewer()
	 */
    public RelationToViewer createRelationToViewer() {
        return new RelationToViewerImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHttpHeader()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHttpHeader()
	 */
    public HttpHeader createHttpHeader() {
        return new HttpHeaderImpl();
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducations()
	 */
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducations()
	 */
    public Educations createEducations() {
        return new EducationsImpl();
    }
    
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createContentType(com.google.code.linkedinapi.schema.NetworkUpdateContentType)
	 */
    public String createContentType(NetworkUpdateContentType value) {
        return createElement(_ContentType_QNAME, NetworkUpdateContentType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeadline(java.lang.String)
	 */
    public String createHeadline(String value) {
        return createElement(_Headline_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSummary(java.lang.String)
	 */
    public String createSummary(String value) {
        return createElement(_Summary_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createBody(java.lang.String)
	 */
    public String createBody(String value) {
        return createElement(_Body_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSiteStandardProfileRequest(com.google.code.linkedinapi.schema.Url)
	 */
    public String createSiteStandardProfileRequest(Url value) {
        return createElement(_SiteStandardProfileRequest_QNAME, UrlImpl.class, null, ((UrlImpl) value));
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSubject(java.lang.String)
	 */
    public String createSubject(String value) {
        return createElement(_Subject_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatus(java.lang.String)
	 */
    public String createCurrentStatus(String value) {
        return createElement(_CurrentStatus_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCommentable(java.lang.Boolean)
	 */
    public String createIsCommentable(Boolean value) {
        return createElement(_IsCommentable_QNAME, Boolean.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createErrorCode(java.lang.String)
	 */
    public String createErrorCode(String value) {
        return createElement(_ErrorCode_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatusTimestamp(java.lang.Long)
	 */
    public String createCurrentStatusTimestamp(Long value) {
        return createElement(_CurrentStatusTimestamp_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createType(java.lang.String)
	 */
    public String createType(String value) {
        return createElement(_Type_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNumRecommenders(java.lang.Long)
	 */
    public String createNumRecommenders(Long value) {
        return createElement(_NumRecommenders_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCurrent(java.lang.Boolean)
	 */
    public String createIsCurrent(Boolean value) {
        return createElement(_IsCurrent_QNAME, Boolean.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTimestamp(java.lang.Long)
	 */
    public String createTimestamp(Long value) {
        return createElement(_Timestamp_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createId(java.lang.String)
	 */
    public String createId(String value) {
        return createElement(_Id_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnectType(com.google.code.linkedinapi.schema.InviteConnectType)
	 */
    public String createConnectType(InviteConnectType value) {
        return createElement(_ConnectType_QNAME, InviteConnectType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDistance(java.lang.Long)
	 */
    public String createDistance(Long value) {
        return createElement(_Distance_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTitle(java.lang.String)
	 */
    public String createTitle(String value) {
        return createElement(_Title_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createName(java.lang.String)
	 */
    public String createName(String value) {
        return createElement(_Name_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createValue(java.lang.String)
	 */
    public String createValue(String value) {
        return createElement(_Value_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear(java.lang.Long)
	 */
    public String createYear(Long value) {
        return createElement(_Year_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLastName(java.lang.String)
	 */
    public String createLastName(String value) {
        return createElement(_LastName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIndustry(java.lang.String)
	 */
    public String createIndustry(String value) {
        return createElement(_Industry_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSchoolName(java.lang.String)
	 */
    public String createSchoolName(String value) {
        return createElement(_SchoolName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEndDate(com.google.code.linkedinapi.schema.Year)
	 */
    public String createEndDate(Year value) {
        return createElement(_EndDate_QNAME, YearImpl.class, null, ((YearImpl) value));
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateType(com.google.code.linkedinapi.schema.NetworkUpdateReturnType)
	 */
    public String createUpdateType(NetworkUpdateReturnType value) {
        return createElement(_UpdateType_QNAME, NetworkUpdateReturnType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createStatus(java.lang.Long)
	 */
    public String createStatus(Long value) {
        return createElement(_Status_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCode(java.lang.String)
	 */
    public String createCode(String value) {
        return createElement(_Code_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl(java.lang.String)
	 */
    public String createUrl(String value) {
        return createElement(_Url_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateKey(java.lang.String)
	 */
    public String createUpdateKey(String value) {
        return createElement(_UpdateKey_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMessage(java.lang.String)
	 */
    public String createMessage(String value) {
        return createElement(_Message_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDegree(java.lang.String)
	 */
    public String createDegree(String value) {
        return createElement(_Degree_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createFirstName(java.lang.String)
	 */
    public String createFirstName(String value) {
        return createElement(_FirstName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMonth(java.lang.Long)
	 */
    public String createMonth(Long value) {
        return createElement(_Month_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createComment(java.lang.String)
	 */
    public String createComment(String value) {
        return createElement(_Comment_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPictureUrl(java.lang.String)
	 */
    public String createPictureUrl(String value) {
        return createElement(_PictureUrl_QNAME, String.class, null, value);
    }
    
    private String createElement(QName contentType_QNAME,
			Class<?> class1, Object object,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}
