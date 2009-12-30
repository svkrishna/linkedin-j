
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MemberGroups;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "memberGroup"
})
@XmlRootElement(name = "member-groups")
public class MemberGroupsImpl
    implements Serializable, MemberGroups
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "member-group", required = true, type = MemberGroupImpl.class)
    protected List<MemberGroup> memberGroup;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<MemberGroup> getMemberGroup() {
        if (memberGroup == null) {
            memberGroup = new ArrayList<MemberGroup>();
        }
        return this.memberGroup;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
