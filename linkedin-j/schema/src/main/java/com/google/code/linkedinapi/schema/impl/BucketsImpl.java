
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
import com.google.code.linkedinapi.schema.Bucket;
import com.google.code.linkedinapi.schema.Buckets;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bucketList"
})
@XmlRootElement(name = "buckets")
public class BucketsImpl
    implements Serializable, Buckets
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "bucket", required = true, type = BucketImpl.class)
    protected List<Bucket> bucketList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<Bucket> getBucketList() {
        if (bucketList == null) {
            bucketList = new ArrayList<Bucket>();
        }
        return this.bucketList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
