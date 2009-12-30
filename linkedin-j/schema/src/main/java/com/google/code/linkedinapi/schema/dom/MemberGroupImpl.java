
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setName(DomUtils.getElementValueFromNode(element, "name"));
		
		Element siteGroupElem = (Element) DomUtils.getChildElementByName(element, "site-group-request");
		if (siteGroupElem != null) {
			SiteGroupRequestImpl siteGroup = new SiteGroupRequestImpl();
			siteGroup.init(siteGroupElem);
			setSiteGroupRequest(siteGroup);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-group");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "name", getName());
		if (getSiteGroupRequest() != null) {
			element.appendChild(((SiteGroupRequestImpl) getSiteGroupRequest()).toXml(document));
		}
		return element;
	}
}
