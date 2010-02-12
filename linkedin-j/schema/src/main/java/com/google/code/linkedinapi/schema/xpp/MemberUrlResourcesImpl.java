
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	protected MemberUrlImpl memberUrl;

    public MemberUrl getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(MemberUrl value) {
        this.memberUrl = ((MemberUrlImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		Element memberUrlElem = (Element) XppUtils.getChildElementByName(parser, "member-url");
		if (memberUrlElem != null) {
			MemberUrlImpl memberUrlImpl = new MemberUrlImpl();
			memberUrlImpl.init(memberUrlElem);
			setMemberUrl(memberUrlImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("member-url-resources");
		if (getMemberUrl() != null) {
			element.appendChild(((MemberUrlImpl) getMemberUrl()).toXml(serializer));
		}
		return element;
	}

}
