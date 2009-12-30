
package com.google.code.linkedinapi.schema.dom;

import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.Recommendee;

public class RecommendationImpl
	extends BaseSchemaEntity
    implements Recommendation
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String recommendationType;
    protected String recommendationSnippet;
    protected RecommendeeImpl recommendee;
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
