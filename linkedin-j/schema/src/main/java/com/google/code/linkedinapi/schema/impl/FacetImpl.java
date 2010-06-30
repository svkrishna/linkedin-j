
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Buckets;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "code",
    "buckets"
})
@XmlRootElement(name = "facet")
public class FacetImpl
    implements Serializable, Facet
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected FacetType code;
    @XmlElement(type = BucketsImpl.class)
    protected BucketsImpl buckets;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public FacetType getCode() {
        return code;
    }

    public void setCode(FacetType value) {
        this.code = value;
    }

    public Buckets getBuckets() {
        return buckets;
    }

    public void setBuckets(Buckets value) {
        this.buckets = ((BucketsImpl) value);
    }

}
