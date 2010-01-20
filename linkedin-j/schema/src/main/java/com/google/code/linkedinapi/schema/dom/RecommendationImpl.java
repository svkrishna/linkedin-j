
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationType;
import com.google.code.linkedinapi.schema.Recommendee;
import com.google.code.linkedinapi.schema.Recommender;

public class RecommendationImpl
	extends BaseSchemaEntity
    implements Recommendation
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected RecommendationType recommendationType;
    protected String recommendationSnippet;
    protected RecommendeeImpl recommendee;
    protected RecommenderImpl recommender;
    protected String webUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public RecommendationType getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(RecommendationType value) {
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

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender value) {
        this.recommender = ((RecommenderImpl) value);
    }
    
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String value) {
        this.webUrl = value;
    }
    
	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setRecommendationType(RecommendationType.fromValue(DomUtils.getElementValueFromNode(element, "recommendation-type")));
		setRecommendationSnippet(DomUtils.getElementValueFromNode(element, "recommendation-snippet"));
		setWebUrl(DomUtils.getElementValueFromNode(element, "web-url"));
		
		Element recommendeeElem = (Element) DomUtils.getChildElementByName(element, "recommendee");
		if (recommendeeElem != null) {
			RecommendeeImpl recommendee = new RecommendeeImpl();
			recommendee.init(recommendeeElem);
			setRecommendee(recommendee);
		}
		Element recommenderElem = (Element) DomUtils.getChildElementByName(element, "recommender");
		if (recommenderElem != null) {
			RecommenderImpl recommender = new RecommenderImpl();
			recommender.init(recommenderElem);
			setRecommender(recommender);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recommendation");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "recommendation-type", getRecommendationType().value());
		DomUtils.setElementValueToNode(element, "recommendation-snippet", getRecommendationSnippet());
		DomUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getRecommendee() != null) {
			element.appendChild(((RecommendeeImpl) getRecommendee()).toXml(document));
		}
		if (getRecommender() != null) {
			element.appendChild(((RecommenderImpl) getRecommender()).toXml(document));
		}
		return element;
	}
}
