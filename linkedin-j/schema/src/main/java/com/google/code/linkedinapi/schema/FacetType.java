
package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType>
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="location"/>
 *     &lt;enumeration value="industry"/>
 *     &lt;enumeration value="network"/>
 *     &lt;enumeration value="language"/>
 *     &lt;enumeration value="current-company"/>
 *     &lt;enumeration value="past-company"/>
 *     &lt;enumeration value="school"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum FacetType {

    @XmlEnumValue("location")
    LOCATION("location"),
    @XmlEnumValue("industry")
    INDUSTRY("industry"),
    @XmlEnumValue("network")
    NETWORK("network"),
    @XmlEnumValue("language")
    LANGUAGE("language"),
    @XmlEnumValue("current-company")
    CURRENT_COMPANY("current-company"),
    @XmlEnumValue("past-company")
    PAST_COMPANY("past-company"),
    @XmlEnumValue("school")
    SCHOOL("school");
    private final String value;

    FacetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FacetType fromValue(String v) {
        for (FacetType c: FacetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
