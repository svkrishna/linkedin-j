
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> properties = XppUtils.getChildElementsByLocalName(parser, "property");
		for (Element property : properties) {
			PropertyImpl personImpl = new PropertyImpl();
			personImpl.init(property);
			getPropertyList().add(personImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("network-stats");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Property property : getPropertyList()) {
			element.appendChild(((PropertyImpl) property).toXml(serializer));
		}
		return element;
	}
}
