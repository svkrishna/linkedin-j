
package com.google.code.linkedinapi.schema.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.Updates;
import org.w3._2001.xmlschema.Adapter1;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "update"
})
@XmlRootElement(name = "updates")
public class UpdatesImpl
    extends BaseSchemaEntity
    implements Updates
{

    @XmlElement(required = true, type = UpdateImpl.class)
    protected List<Update> update;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "integer")
    protected Long total;

    public List<Update> getUpdate() {
        if (update == null) {
            update = new ArrayList<Update>();
        }
        return this.update;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
