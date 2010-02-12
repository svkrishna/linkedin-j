
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setRecommendationType(RecommendationType.fromValue(XppUtils.getElementValueFromNode(parser, "recommendation-type")));
		setRecommendationSnippet(XppUtils.getElementValueFromNode(parser, "recommendation-snippet"));
		setWebUrl(XppUtils.getElementValueFromNode(parser, "web-url"));
		
		Element recommendeeElem = (Element) XppUtils.getChildElementByName(parser, "recommendee");
		if (recommendeeElem != null) {
			RecommendeeImpl recommendee = new RecommendeeImpl();
			recommendee.init(recommendeeElem);
			setRecommendee(recommendee);
		}
		Element recommenderElem = (Element) XppUtils.getChildElementByName(parser, "recommender");
		if (recommenderElem != null) {
			RecommenderImpl recommender = new RecommenderImpl();
			recommender.init(recommenderElem);
			setRecommender(recommender);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("recommendation");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "recommendation-type", getRecommendationType().value());
		XppUtils.setElementValueToNode(element, "recommendation-snippet", getRecommendationSnippet());
		XppUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getRecommendee() != null) {
			element.appendChild(((RecommendeeImpl) getRecommendee()).toXml(serializer));
		}
		if (getRecommender() != null) {
			element.appendChild(((RecommenderImpl) getRecommender()).toXml(serializer));
		}
		return element;
	}
}
