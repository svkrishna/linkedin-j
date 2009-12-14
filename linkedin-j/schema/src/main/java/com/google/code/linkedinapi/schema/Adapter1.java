
package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Long>
{


    public Long unmarshal(String value) {
        return new Long(value);
    }

    public String marshal(Long value) {
        return value.toString();
    }

}
