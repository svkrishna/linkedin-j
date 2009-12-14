
package com.google.code.linkedinapi.schema.dom;
import com.google.code.linkedinapi.schema.EndDate;

public class EndDateImpl
    implements EndDate
{

    protected Long year;
    protected Long month;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }

}
