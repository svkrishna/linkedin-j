
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
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.Updates;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "updateList"
})
@XmlRootElement(name = "updates")
public class UpdatesImpl
    implements Serializable, Updates
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "update", required = true, type = UpdateImpl.class)
    protected List<Update> updateList;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long count;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long start;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<Update> getUpdateList() {
        if (updateList == null) {
            updateList = new ArrayList<Update>();
        }
        return this.updateList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long value) {
        this.start = value;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
