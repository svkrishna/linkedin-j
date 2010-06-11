
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;

public class MemberUrlResourcesImpl
    extends BaseSchemaEntity
    implements MemberUrlResources
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4293798758625787079L;
    protected List<MemberUrl> memberUrlList;

    public List<MemberUrl> getMemberUrlList() {
        if (memberUrlList == null) {
            memberUrlList = new ArrayList<MemberUrl>();
        }
        return this.memberUrlList;
    }

	@Override
	public void init(Element element) {
		List<Element> memberUrlElems = DomUtils.getChildElementsByLocalName(element, "member-url");
		for (Element memberUrlElem : memberUrlElems) {
			MemberUrlImpl memberUrlImpl = new MemberUrlImpl();
			memberUrlImpl.init(memberUrlElem);
			getMemberUrlList().add(memberUrlImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-url-resources");
		for (MemberUrl memberUrl : getMemberUrlList()) {
			element.appendChild(((MemberUrlImpl) memberUrl).toXml(document));
		}
		return element;
	}

}
