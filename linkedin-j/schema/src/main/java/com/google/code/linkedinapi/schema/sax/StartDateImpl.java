
package com.google.code.linkedinapi.schema.sax;

import com.google.code.linkedinapi.schema.StartDate;

public class StartDateImpl
    extends YearImpl
    implements StartDate
{

    protected Long month;

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }

}
