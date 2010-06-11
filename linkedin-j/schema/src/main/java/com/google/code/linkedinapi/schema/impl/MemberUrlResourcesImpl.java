
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "memberUrlList"
})
@XmlRootElement(name = "member-url-resources")
public class MemberUrlResourcesImpl
    implements Serializable, MemberUrlResources
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "member-url", required = true, type = MemberUrlImpl.class)
    protected List<MemberUrl> memberUrlList;

    public List<MemberUrl> getMemberUrlList() {
        if (memberUrlList == null) {
            memberUrlList = new ArrayList<MemberUrl>();
        }
        return this.memberUrlList;
    }

}
