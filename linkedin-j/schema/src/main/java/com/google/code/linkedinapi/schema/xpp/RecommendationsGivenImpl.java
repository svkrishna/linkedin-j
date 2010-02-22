
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("recommendation")) {
    			RecommendationImpl recommendationImpl = new RecommendationImpl();
    			recommendationImpl.init(parser);
    			getRecommendationList().add(recommendationImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "recommendations-given");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Recommendation recommendation : getRecommendationList()) {
			((RecommendationImpl) recommendation).toXml(serializer);
		}
		serializer.endTag(null, "recommendations-given");
	}
}
