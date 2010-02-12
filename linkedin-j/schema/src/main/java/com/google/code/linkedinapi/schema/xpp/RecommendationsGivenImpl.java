
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> recommendations = XppUtils.getChildElementsByLocalName(parser, "recommendation");
		for (Element recommendation : recommendations) {
			RecommendationImpl recommendationImpl = new RecommendationImpl();
			recommendationImpl.init(recommendation);
			getRecommendationList().add(recommendationImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("recommendations-given");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Recommendation recommendation : getRecommendationList()) {
			element.appendChild(((RecommendationImpl) recommendation).toXml(serializer));
		}
		return element;
	}
}
