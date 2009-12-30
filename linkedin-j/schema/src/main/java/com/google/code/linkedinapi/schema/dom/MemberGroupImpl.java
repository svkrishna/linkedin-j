
package com.google.code.linkedinapi.schema.dom;

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

}
