package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The Class DomUtils.
 * 
 * @author    Nabeel Mukhtar
 * @created   June 27, 2001
 * @version   1.0
 */
public class DomUtils {

    /**
     * Sets the element value to node.
     * 
     * @param node the node
     * @param elementName the element name
     * @param elementValue the element value
     */
    public static void setElementValueToNode(Element node, String elementName, Object elementValue) {
    	if (elementValue != null) {
            NodeList nodeList = node.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node child = nodeList.item(i);

                if (child.getNodeName().equals(elementName)) {
                    child.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, String.valueOf(elementValue)));

                    return;
                }
            }

            Node element = createNodeForType(node.getOwnerDocument(), Node.ELEMENT_NODE, elementName);

            element.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, String.valueOf(elementValue)));
            node.appendChild(element);
    	}
    }

    /**
     * Sets the element value.
     * 
     * @param node the node
     * @param elementValue the element value
     */
    public static void setElementValue(Element node, Object elementValue) {
    	if (elementValue != null) {
        	node.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, String.valueOf(elementValue)));
    	}
    }
    
    /**
     * Sets the attribute value to node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * @param attributeValue the attribute value
     */
    public static void setAttributeValueToNode(Element node, String attributeName, Object attributeValue) {
    	if (attributeValue != null) {
        	node.setAttribute(attributeName, String.valueOf(attributeValue));
    	}
    }
    
    /**
     * Gets the child elements by local name.
     * 
     * @param node the node
     * @param localName the local name
     * 
     * @return the child elements by local name
     */
    public static List<Element> getChildElementsByLocalName(Element node, String localName) {
        NodeList nodeList = node.getChildNodes();
        ArrayList<Element>   nodes    = new ArrayList<Element>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (localName.equals(nodeList.item(i).getNodeName()) && nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                nodes.add((Element) nodeList.item(i));
            }
        }

        return nodes;
    }
    
    /**
     * Gets the element value.
     * 
     * @param element the element
     * 
     * @return the element value
     */
    public static String getElementValue(Element element) {
        String nodeValue = null;

        if (element.hasChildNodes()) {
            nodeValue = element.getFirstChild().getNodeValue();
        }

        return nodeValue;
    }

    /**
     * Gets the element value from node.
     * 
     * @param node the node
     * @param valueName the value name
     * 
     * @return the element value from node
     */
    public static String getElementValueFromNode(Element node, String valueName) {
        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeName().equals(valueName)) {
                if (child.hasChildNodes()) {
                    return child.getFirstChild().getNodeValue();
                }
            }
        }

        return null;
    }

    /**
     * Gets the element value as long from node.
     * 
     * @param node the node
     * @param valueName the value name
     * 
     * @return the element value as long from node
     */
    public static Long getElementValueAsLongFromNode(Element node, String valueName) {
        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            if (child.getNodeName().equals(valueName)) {
                if (child.hasChildNodes()) {
                	String value = child.getFirstChild().getNodeValue();
                	if (value != null) {
                        return Long.valueOf(value);
                	} else {
                		return null;
                	}
                }
            }
        }

        return null;
    }
    

    /**
     * Gets the attribute value from node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * 
     * @return the attribute value from node
     */
    public static String getAttributeValueFromNode(Element node, String attributeName) {
        return node.getAttribute(attributeName);
    }

    /**
     * Gets the attribute value as long from node.
     * 
     * @param node the node
     * @param attributeName the attribute name
     * 
     * @return the attribute value as long from node
     */
    public static Long getAttributeValueAsLongFromNode(Element node, String attributeName) {
    	String attribute = node.getAttribute(attributeName);
    	if (isNullOrEmpty(attribute)) {
    		return null;
    	} else {
    		return Long.valueOf(attribute);
    	}
    }
    
    /**
     * Gets the child element by name.
     * 
     * @param parent the parent
     * @param childName the child name
     * 
     * @return the child element by name
     */
    public static Element getChildElementByName(Element parent, String childName) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
        	Node     node   = children.item(i);

            if (node.getNodeName().equals(childName) && node.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) node;
            }
        }

        return null;
    }

    /**
     * Creates the node for type.
     * 
     * @param document the document
     * @param type the type
     * @param nodeName the node name
     * 
     * @return the node
     */
    public static Node createNodeForType(Document document, short type, String nodeName) {
        switch (type) {
        case Node.ATTRIBUTE_NODE : {
            return document.createAttribute(nodeName);
        }

        case Node.ELEMENT_NODE : {
            return document.createElement(nodeName);
        }

        case Node.TEXT_NODE : {
            return document.createTextNode(nodeName);
        }

        case Node.CDATA_SECTION_NODE : {
            return document.createCDATASection(nodeName);
        }

        case Node.COMMENT_NODE : {
            return document.createComment(nodeName);
        }

        default : {
            return null;
        }
        }
    }
    
    /**
     * Dom to string.
     * 
     * @param node the node
     * 
     * @return the string
     */
    public static String domToString(Node node) {
    	StringBuilder builder = new StringBuilder();
    	// TODO-NM: Implement this method..
    	return builder.toString();
    }
    
    /**
     * Checks if is null or empty.
     * 
     * @param string the string
     * 
     * @return true, if is null or empty
     */
    private static boolean isNullOrEmpty(String string) {
    	return (string == null || string.isEmpty());
    }
}
