
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MemberGroups;

public class MemberGroupsImpl
	extends BaseSchemaEntity
    implements MemberGroups
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<MemberGroup> memberGroup;
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
