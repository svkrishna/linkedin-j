
package com.google.code.linkedinapi.schema.dom;

import com.google.code.linkedinapi.schema.MemberUrl;

public class MemberUrlImpl
    extends UrlImpl
    implements MemberUrl
{

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
