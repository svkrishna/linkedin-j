
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Adapter1;
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

}
