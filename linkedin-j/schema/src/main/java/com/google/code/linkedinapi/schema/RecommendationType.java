
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
 *     &lt;enumeration value="COL"/>
 *     &lt;enumeration value="BSP"/>
 *     &lt;enumeration value="SPR"/>
 *     &lt;enumeration value="STU"/>
 *     &lt;enumeration value="EDU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum RecommendationType {

    @XmlEnumValue("COL")
    COLLEAGUE("COL"),
    @XmlEnumValue("BSP")
    BUSINESS_PARTNER("BSP"),
    @XmlEnumValue("SPR")
    SERVICE_PROVIDER("SPR"),
    @XmlEnumValue("STU")
    STUDENT("STU"),
    @XmlEnumValue("EDU")
    EDUCATION("EDU");
    private final String value;

    RecommendationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecommendationType fromValue(String v) {
        for (RecommendationType c: RecommendationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
