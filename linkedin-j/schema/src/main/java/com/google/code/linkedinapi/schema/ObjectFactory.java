
package com.google.code.linkedinapi.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import com.google.code.linkedinapi.schema.impl.ActivityImpl;
import com.google.code.linkedinapi.schema.impl.AnswerImpl;
import com.google.code.linkedinapi.schema.impl.AnswersImpl;
import com.google.code.linkedinapi.schema.impl.ApiStandardProfileRequestImpl;
import com.google.code.linkedinapi.schema.impl.AuthorImpl;
import com.google.code.linkedinapi.schema.impl.AuthorizationImpl;
import com.google.code.linkedinapi.schema.impl.CompanyImpl;
import com.google.code.linkedinapi.schema.impl.ConnectionsImpl;
import com.google.code.linkedinapi.schema.impl.CountryImpl;
import com.google.code.linkedinapi.schema.impl.EducationImpl;
import com.google.code.linkedinapi.schema.impl.EducationsImpl;
import com.google.code.linkedinapi.schema.impl.EndDateImpl;
import com.google.code.linkedinapi.schema.impl.ErrorImpl;
import com.google.code.linkedinapi.schema.impl.HeadersImpl;
import com.google.code.linkedinapi.schema.impl.HttpHeaderImpl;
import com.google.code.linkedinapi.schema.impl.InvitationRequestImpl;
import com.google.code.linkedinapi.schema.impl.ItemContentImpl;
import com.google.code.linkedinapi.schema.impl.JobImpl;
import com.google.code.linkedinapi.schema.impl.JobPosterImpl;
import com.google.code.linkedinapi.schema.impl.LocationImpl;
import com.google.code.linkedinapi.schema.impl.MailboxItemImpl;
import com.google.code.linkedinapi.schema.impl.MemberGroupImpl;
import com.google.code.linkedinapi.schema.impl.MemberGroupsImpl;
import com.google.code.linkedinapi.schema.impl.MemberUrlImpl;
import com.google.code.linkedinapi.schema.impl.MemberUrlResourcesImpl;
import com.google.code.linkedinapi.schema.impl.NetworkImpl;
import com.google.code.linkedinapi.schema.impl.NetworkStatsImpl;
import com.google.code.linkedinapi.schema.impl.PeopleImpl;
import com.google.code.linkedinapi.schema.impl.PersonActivitiesImpl;
import com.google.code.linkedinapi.schema.impl.PersonImpl;
import com.google.code.linkedinapi.schema.impl.PositionImpl;
import com.google.code.linkedinapi.schema.impl.PositionsImpl;
import com.google.code.linkedinapi.schema.impl.PropertyImpl;
import com.google.code.linkedinapi.schema.impl.QuestionCategoriesImpl;
import com.google.code.linkedinapi.schema.impl.QuestionCategoryImpl;
import com.google.code.linkedinapi.schema.impl.QuestionImpl;
import com.google.code.linkedinapi.schema.impl.RecipientImpl;
import com.google.code.linkedinapi.schema.impl.RecipientsImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationsGivenImpl;
import com.google.code.linkedinapi.schema.impl.RecommendationsReceivedImpl;
import com.google.code.linkedinapi.schema.impl.RecommendeeImpl;
import com.google.code.linkedinapi.schema.impl.RecommenderImpl;
import com.google.code.linkedinapi.schema.impl.RelationToViewerImpl;
import com.google.code.linkedinapi.schema.impl.SiteGroupRequestImpl;
import com.google.code.linkedinapi.schema.impl.SiteJobRequestImpl;
import com.google.code.linkedinapi.schema.impl.SiteStandardProfileRequestImpl;
import com.google.code.linkedinapi.schema.impl.StartDateImpl;
import com.google.code.linkedinapi.schema.impl.UpdateCommentImpl;
import com.google.code.linkedinapi.schema.impl.UpdateCommentsImpl;
import com.google.code.linkedinapi.schema.impl.UpdateContentImpl;
import com.google.code.linkedinapi.schema.impl.UpdateImpl;
import com.google.code.linkedinapi.schema.impl.UpdatesImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.google.code.linkedinapi.schema package. 
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

    private final static Void _useJAXBProperties = null;
    private final static QName _ContentType_QNAME = new QName("", "content-type");
    private final static QName _RecommendationType_QNAME = new QName("", "recommendation-type");
    private final static QName _Headline_QNAME = new QName("", "headline");
    private final static QName _Summary_QNAME = new QName("", "summary");
    private final static QName _Body_QNAME = new QName("", "body");
    private final static QName _Honors_QNAME = new QName("", "honors");
    private final static QName _Interests_QNAME = new QName("", "interests");
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
    private final static QName _Specialties_QNAME = new QName("", "specialties");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Value_QNAME = new QName("", "value");
    private final static QName _WebUrl_QNAME = new QName("", "web-url");
    private final static QName _RecommendationSnippet_QNAME = new QName("", "recommendation-snippet");
    private final static QName _Year_QNAME = new QName("", "year");
    private final static QName _AppId_QNAME = new QName("", "app-id");
    private final static QName _LastName_QNAME = new QName("", "last-name");
    private final static QName _Industry_QNAME = new QName("", "industry");
    private final static QName _SchoolName_QNAME = new QName("", "school-name");
    private final static QName _UpdateType_QNAME = new QName("", "update-type");
    private final static QName _Status_QNAME = new QName("", "status");
    private final static QName _Code_QNAME = new QName("", "code");
    private final static QName _Url_QNAME = new QName("", "url");
    private final static QName _UpdateKey_QNAME = new QName("", "update-key");
    private final static QName _Message_QNAME = new QName("", "message");
    private final static QName _Degree_QNAME = new QName("", "degree");
    private final static QName _FirstName_QNAME = new QName("", "first-name");
    private final static QName _Associations_QNAME = new QName("", "associations");
    private final static QName _Month_QNAME = new QName("", "month");
    private final static QName _SequenceNumber_QNAME = new QName("", "sequence-number");
    private final static QName _Comment_QNAME = new QName("", "comment");
    private final static QName _PictureUrl_QNAME = new QName("", "picture-url");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.google.code.linkedinapi.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MailboxItem }
     * 
     */
    public MailboxItem createMailboxItem() {
        return new MailboxItemImpl();
    }

    /**
     * Create an instance of {@link RecommendationsReceived }
     * 
     */
    public RecommendationsReceived createRecommendationsReceived() {
        return new RecommendationsReceivedImpl();
    }

    /**
     * Create an instance of {@link QuestionCategory }
     * 
     */
    public QuestionCategory createQuestionCategory() {
        return new QuestionCategoryImpl();
    }

    /**
     * Create an instance of {@link HttpHeader }
     * 
     */
    public HttpHeader createHttpHeader() {
        return new HttpHeaderImpl();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new LocationImpl();
    }

    /**
     * Create an instance of {@link UpdateComments }
     * 
     */
    public UpdateComments createUpdateComments() {
        return new UpdateCommentsImpl();
    }

    /**
     * Create an instance of {@link EndDate }
     * 
     */
    public EndDate createEndDate() {
        return new EndDateImpl();
    }

    /**
     * Create an instance of {@link SiteStandardProfileRequest }
     * 
     */
    public SiteStandardProfileRequest createSiteStandardProfileRequest() {
        return new SiteStandardProfileRequestImpl();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new QuestionImpl();
    }

    /**
     * Create an instance of {@link SiteGroupRequest }
     * 
     */
    public SiteGroupRequest createSiteGroupRequest() {
        return new SiteGroupRequestImpl();
    }

    /**
     * Create an instance of {@link MemberGroups }
     * 
     */
    public MemberGroups createMemberGroups() {
        return new MemberGroupsImpl();
    }

    /**
     * Create an instance of {@link RecommendationsGiven }
     * 
     */
    public RecommendationsGiven createRecommendationsGiven() {
        return new RecommendationsGivenImpl();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new PersonImpl();
    }

    /**
     * Create an instance of {@link Positions }
     * 
     */
    public Positions createPositions() {
        return new PositionsImpl();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new AuthorImpl();
    }

    /**
     * Create an instance of {@link Education }
     * 
     */
    public Education createEducation() {
        return new EducationImpl();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new CompanyImpl();
    }

    /**
     * Create an instance of {@link SiteJobRequest }
     * 
     */
    public SiteJobRequest createSiteJobRequest() {
        return new SiteJobRequestImpl();
    }

    /**
     * Create an instance of {@link Recipients }
     * 
     */
    public Recipients createRecipients() {
        return new RecipientsImpl();
    }

    /**
     * Create an instance of {@link Educations }
     * 
     */
    public Educations createEducations() {
        return new EducationsImpl();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new PositionImpl();
    }

    /**
     * Create an instance of {@link UpdateComment }
     * 
     */
    public UpdateComment createUpdateComment() {
        return new UpdateCommentImpl();
    }

    /**
     * Create an instance of {@link Recommendee }
     * 
     */
    public Recommendee createRecommendee() {
        return new RecommendeeImpl();
    }

    /**
     * Create an instance of {@link Recommendation }
     * 
     */
    public Recommendation createRecommendation() {
        return new RecommendationImpl();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new JobImpl();
    }

    /**
     * Create an instance of {@link MemberGroup }
     * 
     */
    public MemberGroup createMemberGroup() {
        return new MemberGroupImpl();
    }

    /**
     * Create an instance of {@link InvitationRequest }
     * 
     */
    public InvitationRequest createInvitationRequest() {
        return new InvitationRequestImpl();
    }

    /**
     * Create an instance of {@link ApiStandardProfileRequest }
     * 
     */
    public ApiStandardProfileRequest createApiStandardProfileRequest() {
        return new ApiStandardProfileRequestImpl();
    }

    /**
     * Create an instance of {@link Recommender }
     * 
     */
    public Recommender createRecommender() {
        return new RecommenderImpl();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new AnswerImpl();
    }

    /**
     * Create an instance of {@link ItemContent }
     * 
     */
    public ItemContent createItemContent() {
        return new ItemContentImpl();
    }

    /**
     * Create an instance of {@link QuestionCategories }
     * 
     */
    public QuestionCategories createQuestionCategories() {
        return new QuestionCategoriesImpl();
    }

    /**
     * Create an instance of {@link Network }
     * 
     */
    public Network createNetwork() {
        return new NetworkImpl();
    }

    /**
     * Create an instance of {@link People }
     * 
     */
    public People createPeople() {
        return new PeopleImpl();
    }

    /**
     * Create an instance of {@link Recipient }
     * 
     */
    public Recipient createRecipient() {
        return new RecipientImpl();
    }

    /**
     * Create an instance of {@link RelationToViewer }
     * 
     */
    public RelationToViewer createRelationToViewer() {
        return new RelationToViewerImpl();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new CountryImpl();
    }

    /**
     * Create an instance of {@link Updates }
     * 
     */
    public Updates createUpdates() {
        return new UpdatesImpl();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new ErrorImpl();
    }

    /**
     * Create an instance of {@link Headers }
     * 
     */
    public Headers createHeaders() {
        return new HeadersImpl();
    }

    /**
     * Create an instance of {@link MemberUrlResources }
     * 
     */
    public MemberUrlResources createMemberUrlResources() {
        return new MemberUrlResourcesImpl();
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public Authorization createAuthorization() {
        return new AuthorizationImpl();
    }

    /**
     * Create an instance of {@link NetworkStats }
     * 
     */
    public NetworkStats createNetworkStats() {
        return new NetworkStatsImpl();
    }

    /**
     * Create an instance of {@link MemberUrl }
     * 
     */
    public MemberUrl createMemberUrl() {
        return new MemberUrlImpl();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new UpdateImpl();
    }

    /**
     * Create an instance of {@link JobPoster }
     * 
     */
    public JobPoster createJobPoster() {
        return new JobPosterImpl();
    }

    /**
     * Create an instance of {@link Answers }
     * 
     */
    public Answers createAnswers() {
        return new AnswersImpl();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new PropertyImpl();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new ActivityImpl();
    }

    /**
     * Create an instance of {@link UpdateContent }
     * 
     */
    public UpdateContent createUpdateContent() {
        return new UpdateContentImpl();
    }

    /**
     * Create an instance of {@link PersonActivities }
     * 
     */
    public PersonActivities createPersonActivities() {
        return new PersonActivitiesImpl();
    }

    /**
     * Create an instance of {@link StartDate }
     * 
     */
    public StartDate createStartDate() {
        return new StartDateImpl();
    }

    /**
     * Create an instance of {@link Connections }
     * 
     */
    public Connections createConnections() {
        return new ConnectionsImpl();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RecommendationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recommendation-type")
    public JAXBElement<RecommendationType> createRecommendationType(RecommendationType value) {
        return new JAXBElement<RecommendationType>(_RecommendationType_QNAME, RecommendationType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "honors")
    public JAXBElement<String> createHonors(String value) {
        return new JAXBElement<String>(_Honors_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "interests")
    public JAXBElement<String> createInterests(String value) {
        return new JAXBElement<String>(_Interests_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "specialties")
    public JAXBElement<String> createSpecialties(String value) {
        return new JAXBElement<String>(_Specialties_QNAME, String.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "web-url")
    public JAXBElement<String> createWebUrl(String value) {
        return new JAXBElement<String>(_WebUrl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recommendation-snippet")
    public JAXBElement<String> createRecommendationSnippet(String value) {
        return new JAXBElement<String>(_RecommendationSnippet_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "app-id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAppId(String value) {
        return new JAXBElement<String>(_AppId_QNAME, String.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "associations")
    public JAXBElement<String> createAssociations(String value) {
        return new JAXBElement<String>(_Associations_QNAME, String.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sequence-number")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Long> createSequenceNumber(Long value) {
        return new JAXBElement<Long>(_SequenceNumber_QNAME, Long.class, null, value);
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
