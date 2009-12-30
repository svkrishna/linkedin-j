
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.PersonActivities;

public class PersonActivitiesImpl
	extends BaseSchemaEntity
    implements PersonActivities
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Activity> activity;
    protected Long count;

    public List<Activity> getActivity() {
        if (activity == null) {
            activity = new ArrayList<Activity>();
        }
        return this.activity;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

	@Override
	public void init(Element element) {
		setCount(DomUtils.getAttributeValueAsLongFromNode(element, "count"));
		List<Element> activities = DomUtils.getChildElementsByLocalName(element, "activity");
		for (Element education : activities) {
			ActivityImpl activityImpl = new ActivityImpl();
			activityImpl.init(education);
			getActivity().add(activityImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("person-activities");
		DomUtils.setAttributeValueToNode(element, "count", getCount());
		for (Activity activity : getActivity()) {
			element.appendChild(((ActivityImpl) activity).toXml(document));
		}
		return element;
	}
}
