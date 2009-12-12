
package com.google.code.linkedinapi.schema.dom;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
