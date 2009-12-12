package com.google.code.linkedinapi.schema;

public interface SchemaElementFactory<T> {

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createAuthorization()
	 */
	public Authorization createAuthorization();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCompany()
	 */
	public Company createCompany();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipient()
	 */
	public Recipient createRecipient();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPeople()
	 */
	public People createPeople();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMailboxItem()
	 */
	public MailboxItem createMailboxItem();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createActivity()
	 */
	public Activity createActivity();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPosition()
	 */
	public Position createPosition();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createYear()
	 */
	public Year createYear();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createCountry()
	 */
	public Country createCountry();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrlResources()
	 */
	public MemberUrlResources createMemberUrlResources();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createApiStandardProfileRequest()
	 */
	public ApiStandardProfileRequest createApiStandardProfileRequest();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createLocation()
	 */
	public Location createLocation();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createInvitationRequest()
	 */
	public InvitationRequest createInvitationRequest();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdate()
	 */
	public Update createUpdate();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateContent()
	 */
	public UpdateContent createUpdateContent();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createMemberUrl()
	 */
	public MemberUrl createMemberUrl();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetwork()
	 */
	public Network createNetwork();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHeaders()
	 */
	public Headers createHeaders();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPerson()
	 */
	public Person createPerson();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUrl()
	 */
	public Url createUrl();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createNetworkStats()
	 */
	public NetworkStats createNetworkStats();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createProperty()
	 */
	public Property createProperty();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createPositions()
	 */
	public Positions createPositions();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducation()
	 */
	public Education createEducation();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdateComment()
	 */
	public UpdateComment createUpdateComment();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createUpdates()
	 */
	public Updates createUpdates();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createError()
	 */
	public Error createError();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createConnections()
	 */
	public Connections createConnections();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createItemContent()
	 */
	public ItemContent createItemContent();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRecipients()
	 */
	public Recipients createRecipients();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createStartDate()
	 */
	public StartDate createStartDate();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createRelationToViewer()
	 */
	public RelationToViewer createRelationToViewer();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createHttpHeader()
	 */
	public HttpHeader createHttpHeader();

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.schema.dom.SchemaElementFactory#createEducations()
	 */
	public Educations createEducations();

	public T createContentType(NetworkUpdateContentType value);

	public T createHeadline(String value);

	public T createSummary(String value);

	public T createBody(String value);

	public T createSiteStandardProfileRequest(Url value);

	public T createSubject(String value);

	public T createCurrentStatus(String value);

	public T createIsCommentable(Boolean value);

	public T createErrorCode(String value);

	public T createCurrentStatusTimestamp(Long value);

	public T createType(String value);

	public T createNumRecommenders(Long value);

	public T createIsCurrent(Boolean value);

	public T createTimestamp(Long value);

	public T createId(String value);

	public T createConnectType(InviteConnectType value);

	public T createDistance(Long value);

	public T createTitle(String value);

	public T createName(String value);

	public T createValue(String value);

	public T createYear(Long value);

	public T createLastName(String value);

	public T createIndustry(String value);

	public T createSchoolName(String value);

	public T createEndDate(Year value);

	public T createUpdateType(NetworkUpdateReturnType value);

	public T createStatus(Long value);

	public T createCode(String value);

	public T createUrl(String value);

	public T createUpdateKey(String value);

	public T createMessage(String value);

	public T createDegree(String value);

	public T createFirstName(String value);

	public T createMonth(Long value);

	public T createComment(String value);

	public T createPictureUrl(String value);

}