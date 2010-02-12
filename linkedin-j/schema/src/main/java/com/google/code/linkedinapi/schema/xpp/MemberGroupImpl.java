
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.SiteGroupRequest;

public class MemberGroupImpl
	extends BaseSchemaEntity
    implements MemberGroup
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected SiteGroupRequestImpl siteGroupRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public SiteGroupRequest getSiteGroupRequest() {
        return siteGroupRequest;
    }

    public void setSiteGroupRequest(SiteGroupRequest value) {
        this.siteGroupRequest = ((SiteGroupRequestImpl) value);
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setName(XppUtils.getElementValueFromNode(parser, "name"));
		
		Element siteGroupElem = (Element) XppUtils.getChildElementByName(parser, "site-group-request");
		if (siteGroupElem != null) {
			SiteGroupRequestImpl siteGroup = new SiteGroupRequestImpl();
			siteGroup.init(siteGroupElem);
			setSiteGroupRequest(siteGroup);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("member-group");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "name", getName());
		if (getSiteGroupRequest() != null) {
			element.appendChild(((SiteGroupRequestImpl) getSiteGroupRequest()).toXml(serializer));
		}
		return element;
	}
}
