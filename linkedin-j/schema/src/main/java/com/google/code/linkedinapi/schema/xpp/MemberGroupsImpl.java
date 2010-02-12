
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> memberGroups = XppUtils.getChildElementsByLocalName(parser, "member-group");
		for (Element education : memberGroups) {
			MemberGroupImpl memberGroupImpl = new MemberGroupImpl();
			memberGroupImpl.init(education);
			getMemberGroupList().add(memberGroupImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("member-groups");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (MemberGroup memberGroup : getMemberGroupList()) {
			element.appendChild(((MemberGroupImpl) memberGroup).toXml(serializer));
		}
		return element;
	}
}
