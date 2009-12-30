
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    
	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setRecommendationType(DomUtils.getElementValueFromNode(element, "recommendation-type"));
		setRecommendationSnippet(DomUtils.getElementValueFromNode(element, "recommendation-snippet"));
		setWebUrl(DomUtils.getElementValueFromNode(element, "web-url"));
		
		Element recommendeeElem = (Element) DomUtils.getChildElementByName(element, "recommendee");
		if (recommendeeElem != null) {
			RecommendeeImpl recommendee = new RecommendeeImpl();
			recommendee.init(recommendeeElem);
			setRecommendee(recommendee);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recommendation");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "recommendation-type", getRecommendationType());
		DomUtils.setElementValueToNode(element, "recommendation-snippet", getRecommendationSnippet());
		DomUtils.setElementValueToNode(element, "web-url", getWebUrl());
		if (getRecommendee() != null) {
			element.appendChild(((RecommendeeImpl) getRecommendee()).toXml(document));
		}
		return element;
	}
}
