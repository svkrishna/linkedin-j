
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MemberGroups;

public class MemberGroupsImpl
	extends BaseSchemaEntity
    implements MemberGroups
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<MemberGroup> memberGroupList;
    protected Long total;

    public List<MemberGroup> getMemberGroupList() {
        if (memberGroupList == null) {
            memberGroupList = new ArrayList<MemberGroup>();
        }
        return this.memberGroupList;
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
		List<Element> memberGroups = DomUtils.getChildElementsByLocalName(element, "member-group");
		for (Element education : memberGroups) {
			MemberGroupImpl memberGroupImpl = new MemberGroupImpl();
			memberGroupImpl.init(education);
			getMemberGroupList().add(memberGroupImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-groups");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (MemberGroup memberGroup : getMemberGroupList()) {
			element.appendChild(((MemberGroupImpl) memberGroup).toXml(document));
		}
		return element;
	}
}
