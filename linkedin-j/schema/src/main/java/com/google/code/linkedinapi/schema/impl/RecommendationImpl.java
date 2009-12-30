
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.Recommendee;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "recommendationType",
    "recommendationSnippet",
    "recommendee",
    "webUrl"
})
@XmlRootElement(name = "recommendation")
public class RecommendationImpl
    implements Serializable, Recommendation
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "recommendation-type", required = true)
    protected String recommendationType;
    @XmlElement(name = "recommendation-snippet", required = true)
    protected String recommendationSnippet;
    @XmlElement(required = true, type = RecommendeeImpl.class)
    protected RecommendeeImpl recommendee;
    @XmlElement(name = "web-url", required = true)
    protected String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(String value) {
        this.recommendationType = value;
    }

    public String getRecommendationSnippet() {
        return recommendationSnippet;
    }

    public void setRecommendationSnippet(String value) {
        this.recommendationSnippet = value;
    }

    public Recommendee getRecommendee() {
        return recommendee;
    }

    public void setRecommendee(Recommendee value) {
        this.recommendee = ((RecommendeeImpl) value);
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }

}
