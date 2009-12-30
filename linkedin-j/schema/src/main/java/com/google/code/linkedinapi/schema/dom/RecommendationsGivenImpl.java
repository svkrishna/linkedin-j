
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Recommendation;
import com.google.code.linkedinapi.schema.RecommendationsGiven;

public class RecommendationsGivenImpl
	extends BaseSchemaEntity
    implements RecommendationsGiven
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Recommendation> recommendation;
    protected Long total;

    public List<Recommendation> getRecommendation() {
        if (recommendation == null) {
            recommendation = new ArrayList<Recommendation>();
        }
        return this.recommendation;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
