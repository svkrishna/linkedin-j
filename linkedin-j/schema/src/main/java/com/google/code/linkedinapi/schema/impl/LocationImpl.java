
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "country"
})
@XmlRootElement(name = "location")
public class LocationImpl
    extends BaseSchemaEntity
    implements Location
{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(type = CountryImpl.class)
    protected CountryImpl country;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = ((CountryImpl) value);
    }

}
