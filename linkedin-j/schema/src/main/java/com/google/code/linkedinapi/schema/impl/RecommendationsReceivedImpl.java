
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
import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationsReceived;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recommendationList"
})
@XmlRootElement(name = "recommendations-received")
public class RecommendationsReceivedImpl
    implements Serializable, RecommendationsReceived
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "recommendation", required = true, type = RecommendationImpl.class)
    protected List<Recommendation> recommendationList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<Recommendation> getRecommendationList() {
        if (recommendationList == null) {
            recommendationList = new ArrayList<Recommendation>();
        }
        return this.recommendationList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
