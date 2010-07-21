/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

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
	public void init(Element element) {
		setCount(DomUtils.getAttributeValueAsLongFromNode(element, "count"));
		List<Element> activities = DomUtils.getChildElementsByLocalName(element, "activity");
		for (Element education : activities) {
			ActivityImpl activityImpl = new ActivityImpl();
			activityImpl.init(education);
			getActivityList().add(activityImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("person-activities");
		DomUtils.setAttributeValueToNode(element, "count", getCount());
		for (Activity activity : getActivityList()) {
			element.appendChild(((ActivityImpl) activity).toXml(document));
		}
		return element;
	}
}
