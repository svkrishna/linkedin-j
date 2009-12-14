
package com.google.code.linkedinapi.schema.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Education;
import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.EndDate;
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
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;
import com.google.code.linkedinapi.schema.StartDate;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateContent;
import com.google.code.linkedinapi.schema.Updates;

/**
 * A factory for creating DomElement objects.
 */
public class DomElementFactory implements SchemaElementFactory<Element> {
	
	private final static DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
	
    /** The Constant _ContentType_QNAME. */
    private final static String _ContentType_QNAME = "content-type";
    
    /** The Constant _Headline_QNAME. */
    private final static String _Headline_QNAME = "headline";
    
    /** The Constant _Summary_QNAME. */
    private final static String _Summary_QNAME = "summary";
    
    /** The Constant _Body_QNAME. */
    private final static String _Body_QNAME = "body";
    
    /** The Constant _Subject_QNAME. */
    private final static String _Subject_QNAME = "subject";
    
    /** The Constant _CurrentStatus_QNAME. */
    private final static String _CurrentStatus_QNAME = "current-status";
    
    /** The Constant _IsCommentable_QNAME. */
    private final static String _IsCommentable_QNAME = "is-commentable";
    
    /** The Constant _ErrorCode_QNAME. */
    private final static String _ErrorCode_QNAME = "error-code";
    
    /** The Constant _CurrentStatusTimestamp_QNAME. */
    private final static String _CurrentStatusTimestamp_QNAME = "current-status-timestamp";
    
    /** The Constant _Type_QNAME. */
    private final static String _Type_QNAME = "type";
    
    /** The Constant _NumRecommenders_QNAME. */
    private final static String _NumRecommenders_QNAME = "num-recommenders";
    
    /** The Constant _IsCurrent_QNAME. */
    private final static String _IsCurrent_QNAME = "is-current";
    
    /** The Constant _Timestamp_QNAME. */
    private final static String _Timestamp_QNAME = "timestamp";
    
    /** The Constant _Id_QNAME. */
    private final static String _Id_QNAME = "id";
    
    /** The Constant _ConnectType_QNAME. */
    private final static String _ConnectType_QNAME = "connect-type";
    
    /** The Constant _Distance_QNAME. */
    private final static String _Distance_QNAME = "distance";
    
    /** The Constant _Title_QNAME. */
    private final static String _Title_QNAME = "title";
    
    /** The Constant _Name_QNAME. */
    private final static String _Name_QNAME = "name";
    
    /** The Constant _Value_QNAME. */
    private final static String _Value_QNAME = "value";
    
    /** The Constant _Year_QNAME. */
    private final static String _Year_QNAME = "year";
    
    /** The Constant _LastName_QNAME. */
    private final static String _LastName_QNAME = "last-name";
    
    /** The Constant _Industry_QNAME. */
    private final static String _Industry_QNAME = "industry";
    
    /** The Constant _SchoolName_QNAME. */
    private final static String _SchoolName_QNAME = "school-name";
    
    /** The Constant _UpdateType_QNAME. */
    private final static String _UpdateType_QNAME = "update-type";
    
    /** The Constant _Status_QNAME. */
    private final static String _Status_QNAME = "status";
    
    /** The Constant _Code_QNAME. */
    private final static String _Code_QNAME = "code";
    
    /** The Constant _Url_QNAME. */
    private final static String _Url_QNAME = "url";
    
    /** The Constant _UpdateKey_QNAME. */
    private final static String _UpdateKey_QNAME = "update-key";
    
    /** The Constant _Message_QNAME. */
    private final static String _Message_QNAME = "message";
    
    /** The Constant _Degree_QNAME. */
    private final static String _Degree_QNAME = "degree";
    
    /** The Constant _FirstName_QNAME. */
    private final static String _FirstName_QNAME = "first-name";
    
    /** The Constant _Month_QNAME. */
    private final static String _Month_QNAME = "month";
    
    /** The Constant _Comment_QNAME. */
    private final static String _Comment_QNAME = "comment";
    
    /** The Constant _PictureUrl_QNAME. */
    private final static String _PictureUrl_QNAME = "picture-url";
    
    private Document document;
	
    /**
     * Instantiates a new dom element factory.
     */
    public DomElementFactory() {
    	try {
			DocumentBuilder docBuilder = DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
			document = docBuilder.newDocument(); 
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createAuthorization()
     */
    public Authorization createAuthorization() {
        return new AuthorizationImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createCompany()
     */
    public Company createCompany() {
        return new CompanyImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRecipient()
     */
    public Recipient createRecipient() {
        return new RecipientImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPeople()
     */
    public People createPeople() {
        return new PeopleImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMailboxItem()
     */
    public MailboxItem createMailboxItem() {
        return new MailboxItemImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createActivity()
     */
    public Activity createActivity() {
        return new ActivityImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPosition()
     */
    public Position createPosition() {
        return new PositionImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createCountry()
     */
    public Country createCountry() {
        return new CountryImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMemberUrlResources()
     */
    public MemberUrlResources createMemberUrlResources() {
        return new MemberUrlResourcesImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createApiStandardProfileRequest()
     */
    public ApiStandardProfileRequest createApiStandardProfileRequest() {
        return new ApiStandardProfileRequestImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createLocation()
     */
    public Location createLocation() {
        return new LocationImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createInvitationRequest()
     */
    public InvitationRequest createInvitationRequest() {
        return new InvitationRequestImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdate()
     */
    public Update createUpdate() {
        return new UpdateImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdateContent()
     */
    public UpdateContent createUpdateContent() {
        return new UpdateContentImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createMemberUrl()
     */
    public MemberUrl createMemberUrl() {
        return new MemberUrlImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createNetwork()
     */
    public Network createNetwork() {
        return new NetworkImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createHeaders()
     */
    public Headers createHeaders() {
        return new HeadersImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPerson()
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createNetworkStats()
     */
    public NetworkStats createNetworkStats() {
        return new NetworkStatsImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createProperty()
     */
    public Property createProperty() {
        return new PropertyImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createPositions()
     */
    public Positions createPositions() {
        return new PositionsImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEducation()
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdateComment()
     */
    public UpdateComment createUpdateComment() {
        return new UpdateCommentImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createUpdates()
     */
    public Updates createUpdates() {
        return new UpdatesImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createError()
     */
    public Error createError() {
        return new ErrorImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createConnections()
     */
    public Connections createConnections() {
        return new ConnectionsImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createItemContent()
     */
    public ItemContent createItemContent() {
        return new ItemContentImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRecipients()
     */
    public Recipients createRecipients() {
        return new RecipientsImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createStartDate()
     */
    public StartDate createStartDate() {
        return new StartDateImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createRelationToViewer()
     */
    public RelationToViewer createRelationToViewer() {
        return new RelationToViewerImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createHttpHeader()
     */
    public HttpHeader createHttpHeader() {
        return new HttpHeaderImpl();
    }

    /* (non-Javadoc)
     * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEducations()
     */
    public Educations createEducations() {
        return new EducationsImpl();
    }
    
	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createEndDate()
	 */
	@Override
	public EndDate createEndDate() {
		return new EndDateImpl();
	}

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.SchemaElementFactory#createSiteStandardProfileRequest()
	 */
	@Override
	public SiteStandardProfileRequest createSiteStandardProfileRequest() {
		return new SiteStandardProfileRequestImpl();
	}
    
    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createContentType(com.google.code.linkedinapi.schema.NetworkUpdateContentType)
	 */
    public Element createContentType(NetworkUpdateContentType value) {
        return createElement(_ContentType_QNAME, NetworkUpdateContentType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeadline(java.lang.String)
	 */
    public Element createHeadline(String value) {
        return createElement(_Headline_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSummary(java.lang.String)
	 */
    public Element createSummary(String value) {
        return createElement(_Summary_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createBody(java.lang.String)
	 */
    public Element createBody(String value) {
        return createElement(_Body_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSubject(java.lang.String)
	 */
    public Element createSubject(String value) {
        return createElement(_Subject_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatus(java.lang.String)
	 */
    public Element createCurrentStatus(String value) {
        return createElement(_CurrentStatus_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCommentable(java.lang.Boolean)
	 */
    public Element createIsCommentable(Boolean value) {
        return createElement(_IsCommentable_QNAME, Boolean.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createErrorCode(java.lang.String)
	 */
    public Element createErrorCode(String value) {
        return createElement(_ErrorCode_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCurrentStatusTimestamp(java.lang.Long)
	 */
    public Element createCurrentStatusTimestamp(Long value) {
        return createElement(_CurrentStatusTimestamp_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createType(java.lang.String)
	 */
    public Element createType(String value) {
        return createElement(_Type_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNumRecommenders(java.lang.Long)
	 */
    public Element createNumRecommenders(Long value) {
        return createElement(_NumRecommenders_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIsCurrent(java.lang.Boolean)
	 */
    public Element createIsCurrent(Boolean value) {
        return createElement(_IsCurrent_QNAME, Boolean.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTimestamp(java.lang.Long)
	 */
    public Element createTimestamp(Long value) {
        return createElement(_Timestamp_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createId(java.lang.String)
	 */
    public Element createId(String value) {
        return createElement(_Id_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnectType(com.google.code.linkedinapi.schema.InviteConnectType)
	 */
    public Element createConnectType(InviteConnectType value) {
        return createElement(_ConnectType_QNAME, InviteConnectType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDistance(java.lang.Long)
	 */
    public Element createDistance(Long value) {
        return createElement(_Distance_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createTitle(java.lang.String)
	 */
    public Element createTitle(String value) {
        return createElement(_Title_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createName(java.lang.String)
	 */
    public Element createName(String value) {
        return createElement(_Name_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createValue(java.lang.String)
	 */
    public Element createValue(String value) {
        return createElement(_Value_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear(java.lang.Long)
	 */
    public Element createYear(Long value) {
        return createElement(_Year_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLastName(java.lang.String)
	 */
    public Element createLastName(String value) {
        return createElement(_LastName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createIndustry(java.lang.String)
	 */
    public Element createIndustry(String value) {
        return createElement(_Industry_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createSchoolName(java.lang.String)
	 */
    public Element createSchoolName(String value) {
        return createElement(_SchoolName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateType(com.google.code.linkedinapi.schema.NetworkUpdateReturnType)
	 */
    public Element createUpdateType(NetworkUpdateReturnType value) {
        return createElement(_UpdateType_QNAME, NetworkUpdateReturnType.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createStatus(java.lang.Long)
	 */
    public Element createStatus(Long value) {
        return createElement(_Status_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCode(java.lang.String)
	 */
    public Element createCode(String value) {
        return createElement(_Code_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl(java.lang.String)
	 */
    public Element createUrl(String value) {
        return createElement(_Url_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateKey(java.lang.String)
	 */
    public Element createUpdateKey(String value) {
        return createElement(_UpdateKey_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMessage(java.lang.String)
	 */
    public Element createMessage(String value) {
        return createElement(_Message_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createDegree(java.lang.String)
	 */
    public Element createDegree(String value) {
        return createElement(_Degree_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createFirstName(java.lang.String)
	 */
    public Element createFirstName(String value) {
        return createElement(_FirstName_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMonth(java.lang.Long)
	 */
    public Element createMonth(Long value) {
        return createElement(_Month_QNAME, Long.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createComment(java.lang.String)
	 */
    public Element createComment(String value) {
        return createElement(_Comment_QNAME, String.class, null, value);
    }

    /* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPictureUrl(java.lang.String)
	 */
    public Element createPictureUrl(String value) {
        return createElement(_PictureUrl_QNAME, String.class, null, value);
    }
    
    /**
     * Creates a new DomElement object.
     * 
     * @param contentType_QNAME the content type_ qname
     * @param class1 the class1
     * @param object the object
     * @param value the value
     * 
     * @return the element
     */
    private Element createElement(String contentType_QNAME, Class<?> class1, Object object, Object value) {
    	if (value != null) {
    		Element element = (Element) DomUtils.createNodeForType(document, Node.ELEMENT_NODE, contentType_QNAME);
    		if (class1.equals(InviteConnectType.class)) {
        		DomUtils.setElementValue(element, ((InviteConnectType) value).value());
    		} else if (class1.equals(NetworkUpdateReturnType.class)) {
        		DomUtils.setElementValue(element, ((NetworkUpdateReturnType) value).value());
    		} else if (class1.equals(NetworkUpdateContentType.class)) {
        		DomUtils.setElementValue(element, ((NetworkUpdateContentType) value).value());
    		} else {
        		DomUtils.setElementValue(element, String.valueOf(value));
    		}
    		return element;
    	} else {
    		return null;
    	}
	}
}
