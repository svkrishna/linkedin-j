/**
 *
 */
package com.google.code.linkedinapi.schema.xml;

import java.io.IOException;
import java.util.Properties;

/**
 * @author nmukhtar
 *
 */
public final class TestXMLFiles {
    public static final String TEST_XML_FILES = "com/google/code/linkedinapi/schema/xml/TestXMLFiles.properties";

    private static final Properties testXmlFiles = new Properties();

    static {
    	try {
			testXmlFiles.load(TestXMLFiles.class.getClassLoader().getResourceAsStream(TEST_XML_FILES));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private TestXMLFiles() {}

	public static final String LINKED_IN_SCHEMA_CONNECTIONS_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.connections");
	public static final String LINKED_IN_SCHEMA_NETWORK_UPDATES_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.networkUpdates");
	public static final String LINKED_IN_SCHEMA_PROFILE_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.profile");
	public static final String LINKED_IN_SCHEMA_UPDATE_STATUS_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateCurrentStatus");
	public static final String LINKED_IN_SCHEMA_UPDATE_NETWORK_UPDATE_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateNetworkUpdate");
	public static final String LINKED_IN_SCHEMA_UPDATE_COMMENT_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateComment");
	public static final String LINKED_IN_SCHEMA_SEARCH_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.search");
	public static final String LINKED_IN_SCHEMA_SEND_MESSAGE_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.sendMessage");
	public static final String LINKED_IN_SCHEMA_SEND_INVITE_XML = testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.sendInvite");
}
