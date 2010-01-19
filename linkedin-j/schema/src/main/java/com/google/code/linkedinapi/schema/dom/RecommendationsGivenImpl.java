
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationsGiven;

public class RecommendationsGivenImpl
	extends BaseSchemaEntity
    implements RecommendationsGiven
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Recommendation> recommendationList;
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

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> recommendations = DomUtils.getChildElementsByLocalName(element, "recommendation");
		for (Element recommendation : recommendations) {
			RecommendationImpl recommendationImpl = new RecommendationImpl();
			recommendationImpl.init(recommendation);
			getRecommendationList().add(recommendationImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("recommendations-given");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Recommendation recommendation : getRecommendationList()) {
			element.appendChild(((RecommendationImpl) recommendation).toXml(document));
		}
		return element;
	}
}
