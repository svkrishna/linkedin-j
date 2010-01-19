
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.Property;

public class NetworkStatsImpl
    extends BaseSchemaEntity
    implements NetworkStats
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5888495492447011822L;
	protected List<Property> propertyList;
    protected Long total;

    public List<Property> getPropertyList() {
        if (propertyList == null) {
            propertyList = new ArrayList<Property>();
        }
        return this.propertyList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> properties = DomUtils.getChildElementsByLocalName(element, "property");
		for (Element property : properties) {
			PropertyImpl personImpl = new PropertyImpl();
			personImpl.init(property);
			getPropertyList().add(personImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("network-stats");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Property property : getPropertyList()) {
			element.appendChild(((PropertyImpl) property).toXml(document));
		}
		return element;
	}
}
