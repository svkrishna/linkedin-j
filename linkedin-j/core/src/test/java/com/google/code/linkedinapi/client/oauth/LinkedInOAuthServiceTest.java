/**
 * 
 */
package com.google.code.linkedinapi.client.oauth;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.code.linkedinapi.client.constant.TestConstants;

/**
 * @author nmukhtar
 *
 */
public class LinkedInOAuthServiceTest extends TestCase {
	
    /** Field description */
    protected LinkedInOAuthService service;

	/** Field description */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file."; 

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Key"), TestConstants.LINKED_IN_TEST_CONSUMER_KEY);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Secret"), TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
		LinkedInOAuthServiceFactory factory = LinkedInOAuthServiceFactory.getInstance();
		service = factory.createLinkedInOAuthService(TestConstants.LINKED_IN_TEST_CONSUMER_KEY,
                TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthAccessToken(com.google.code.linkedinapi.client.oauth.LinkedInRequestToken, java.lang.String)}.
	 */
	@Test
	public void testGetOAuthAccessToken() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthRequestToken()}.
	 */
	@Test
	public void testGetOAuthRequestToken() {
		LinkedInRequestToken requestToken = service.getOAuthRequestToken();
		assertNotNull("Request token should not be null.", requestToken);
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#getOAuthRequestToken(java.lang.String)}.
	 */
	@Test
	public void testGetOAuthRequestTokenString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceImpl#signRequestWithToken(java.net.HttpURLConnection, com.google.code.linkedinapi.client.oauth.LinkedInAccessToken)}.
	 */
	@Test
	public void testSignRequestWithToken() {
		fail("Not yet implemented");
	}

	/**
	 * 
	 */
	protected void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
}
