package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author    Nabeel Mukhtar
 * @created   June 27, 2001
 * @version   1.0
 */
public class DomUtils {

    /**
     * Sets the ElementValueToNode attribute of the XMLUtils class
     *
     * @param node          The new ElementValueToNode value
     * @param elementName   The new ElementValueToNode value
     * @param elementValue  The new ElementValueToNode value
     */
    public static void setElementValueToNode(Node node, String elementName, String elementValue) {
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node child = nodeList.item(i);

            if (child.getNodeName().equals(elementName)) {
                child.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, elementValue));

                return;
            }
        }

        Node element = createNodeForType(node.getOwnerDocument(), Node.ELEMENT_NODE, elementName);

        element.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, elementValue));
        node.appendChild(element);
    }

    /**
     * Sets the ElementValueToNode attribute of the XMLUtils class
     *
     * @param node          The new ElementValueToNode value
     * @param elementName   The new ElementValueToNode value
     * @param elementValue  The new ElementValueToNode value
     */
    public static void setElementValue(Element node, String elementValue) {
    	node.appendChild(createNodeForType(node.getOwnerDocument(), Node.TEXT_NODE, elementValue));
    }
    
    /**
     * Gets the ChildElements attribute of the XMLUtils object
     *
     * @param parent  Description of Parameter
     * @return        The ChildElements value
     */
    public static List<Element> getChildElements(Node parent) {
        ArrayList<Element>   children = new ArrayList<Element>();
        NodeList list     = parent.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                children.add((Element) list.item(i));
            }
        }

        return children;
    }

    /**
     * Gets the NodeByName attribute of the XMLUtils class
     *
     * @param nodeList  Description of Parameter
     * @param nodeName  Description of Parameter
     * @return          The NodeByName value
     */
    public static Node getNodeByName(NodeList nodeList, String nodeName) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(nodeName)) {
                return nodeList.item(i);
            }
        }

        return null;
    }

    /**
     * Gets the nodeByLocalName attribute of the XMLUtils class
     *
     * @param nodeList  Description of Parameter
     * @param nodeName  Description of Parameter
     * @return          The nodeByLocalName value
     */
    public static Node getNodeByLocalName(NodeList nodeList, String nodeName) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeName.equals(nodeList.item(i).getLocalName())) {
                return nodeList.item(i);
            }
        }

        return null;
    }

    /**
     * Gets the ChildrenByTagName attribute of the XMLUtils class
     *
     * @param node     Description of Parameter
     * @param tagName  Description of Parameter
     * @return         The ChildrenByTagName value
     */
    public static List<Node> getChildrenByTagName(Node node, String tagName) {
        NodeList nodeList = node.getChildNodes();
        ArrayList<Node>   nodes    = new ArrayList<Node>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(tagName)) {
                nodes.add(nodeList.item(i));
            }
        }

        return nodes;
    }

    /**
     * Gets the childrenByLocalName attribute of the XMLUtils class
     *
     * @param node       Description of Parameter
     * @param localName  Description of Parameter
     * @return           The childrenByLocalName value
     */
    public static List<Node> getChildrenByLocalName(Node node, String localName) {
        NodeList nodeList = node.getChildNodes();
        ArrayList<Node>   nodes    = new ArrayList<Node>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (localName.equals(nodeList.item(i).getLocalName())) {
                nodes.add(nodeList.item(i));
            }
        }

        return nodes;
    }

    public static List<Element> getChildElementsByLocalName(Node node, String localName) {
        NodeList nodeList = node.getChildNodes();
        ArrayList<Element>   nodes    = new ArrayList<Element>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (localName.equals(nodeList.item(i).getLocalName()) && nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                nodes.add((Element) nodeList.item(i));
            }
        }

        return nodes;
    }
    
    /**
     * Gets the ElementValue attribute of the XMLUtils class
     *
     * @param element  Description of Parameter
     * @return         The ElementValue value
     */
    public static String getElementValue(Element element) {
        String nodeValue = null;

        if (element.hasChildNodes()) {
            nodeValue = element.getFirstChild().getNodeValue();
        }

        return nodeValue;
    }

    /**
     * Gets the ValueFromNode attribute of the DBInterfaceImpl object
     *
     * @param node       Description of Parameter
     * @param valueName  Description of Parameter
     * @return           The ValueFromNode value
     */
    public static String getElementValueFromNode(Node node, String valueName) {
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

    public static Long getElementValueAsLongFromNode(Node node, String valueName) {
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
     * Gets the nodeValue attribute of the XMLUtils class
     *
     * @param node  Description of Parameter
     * @return      The nodeValue value
     */
    public static String getNodeValue(Node node) {
        if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
            return node.getNodeValue();
        } else if (node.getNodeType() == Node.ELEMENT_NODE) {
            return (node.hasChildNodes())
                   ? node.getFirstChild().getNodeValue()
                   : "";
        }

        return "";
    }

    /**
     * Gets the AncestorByName attribute of the XMLUtils class
     *
     * @param node          Description of Parameter
     * @param ancestorName  Description of Parameter
     * @return              The AncestorByName value
     */
    public static Node getAncestorByName(Node node, String ancestorName) {
        Node ancestorNode = node.getParentNode();

        while ((ancestorNode != null) && (ancestorNode.getNodeName().equals(ancestorName) == false)) {
            ancestorNode = ancestorNode.getParentNode();
        }

        return ancestorNode;
    }

    /**
     * This method returns a Child Node associated with a Node.
     *
     * @param n          - parent node
     * @param childName  - name of child node.
     * @return           - child node specified by name
     * @see
     */
    public static Node getChildNode(Node n, String childName) {
        NodeList children = n.getChildNodes();
        Node     node   = null;

        for (int i = 0; i < children.getLength(); i++) {
            node = children.item(i);

            if (node.getNodeName().equals(childName)) {
                return node;
            }
        }

        return null;
    }

    /**
     * Description of the Method
     *
     * @param document  Description of Parameter
     * @param type      Description of Parameter
     * @param nodeName  Description of Parameter
     * @return          Description of the Returned Value
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
}
