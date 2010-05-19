
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.PhoneNumber;
import com.google.code.linkedinapi.schema.PhoneNumbers;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "phoneNumberList"
})
@XmlRootElement(name = "phone-numbers")
public class PhoneNumbersImpl
    implements Serializable, PhoneNumbers
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "phone-number", type = PhoneNumberImpl.class)
    protected List<PhoneNumber> phoneNumberList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<PhoneNumber> getPhoneNumberList() {
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<PhoneNumber>();
        }
        return this.phoneNumberList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
