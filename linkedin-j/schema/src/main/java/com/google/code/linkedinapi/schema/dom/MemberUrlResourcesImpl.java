
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;

public class MemberUrlResourcesImpl
    extends BaseSchemaEntity
    implements MemberUrlResources
{

    protected MemberUrlImpl memberUrl;

    public MemberUrl getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(MemberUrl value) {
        this.memberUrl = ((MemberUrlImpl) value);
    }

	@Override
	public void init(Element element) {
		Element memberUrlElem = (Element) DomUtils.getChildElementByName(element, "member-url");
		if (memberUrlElem != null) {
			MemberUrlImpl memberUrlImpl = new MemberUrlImpl();
			memberUrlImpl.init(memberUrlElem);
			setMemberUrl(memberUrlImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-url-resources");
		if (getMemberUrl() != null) {
			element.appendChild(((MemberUrlImpl) getMemberUrl()).toXml(document));
		}
		return element;
	}

}
