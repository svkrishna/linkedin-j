
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.PersonActivities;

public class PersonActivitiesImpl
	extends BaseSchemaEntity
    implements PersonActivities
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Activity> activityList;
    protected Long count;

    public List<Activity> getActivityList() {
        if (activityList == null) {
            activityList = new ArrayList<Activity>();
        }
        return this.activityList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));
		List<Element> activities = XppUtils.getChildElementsByLocalName(parser, "activity");
		for (Element education : activities) {
			ActivityImpl activityImpl = new ActivityImpl();
			activityImpl.init(education);
			getActivityList().add(activityImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("person-activities");
		XppUtils.setAttributeValueToNode(element, "count", getCount());
		for (Activity activity : getActivityList()) {
			element.appendChild(((ActivityImpl) activity).toXml(serializer));
		}
		return element;
	}
}
