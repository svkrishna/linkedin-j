
package com.google.code.linkedinapi.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType>
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ANSW"/>
 *     &lt;enumeration value="APPM"/>
 *     &lt;enumeration value="APPS"/>
 *     &lt;enumeration value="CONN"/>
 *     &lt;enumeration value="NCON"/>
 *     &lt;enumeration value="CCEM"/>
 *     &lt;enumeration value="JOBP"/>
 *     &lt;enumeration value="JGRP"/>
 *     &lt;enumeration value="PICU"/>
 *     &lt;enumeration value="PREC"/>
 *     &lt;enumeration value="PROF"/>
 *     &lt;enumeration value="QSTN"/>
 *     &lt;enumeration value="STAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum NetworkUpdateReturnType {

    @XmlEnumValue("ANSW")
    ANSWER_UPDATE("ANSW"),
    @XmlEnumValue("APPM")
    APPLICATION_CONNECTION_UPDATE("APPM"),
    @XmlEnumValue("APPS")
    APPLICATION_TO_MEMBER_UPDATE("APPS"),
    @XmlEnumValue("CONN")
    CONNECTION_ADDED_CONNECTIONS("CONN"),
    @XmlEnumValue("NCON")
    NEW_CONNECTIONS("NCON"),
    @XmlEnumValue("CCEM")
    CONTACT_JOINED("CCEM"),
    @XmlEnumValue("JOBP")
    JOB_POSTED("JOBP"),
    @XmlEnumValue("JGRP")
    CONNECTION_JOINED_GROUP("JGRP"),
    @XmlEnumValue("PICU")
    CONNECTION_UPDATED_PICTURE("PICU"),
    @XmlEnumValue("PREC")
    CONNECTION_RECOMMENDED("PREC"),
    @XmlEnumValue("PROF")
    CONNECTION_UPDATED_PROFILE("PROF"),
    @XmlEnumValue("QSTN")
    QUESTION_UPDATED("QSTN"),
    @XmlEnumValue("STAT")
    STATUS_UPDATED("STAT");
    private final String value;

    NetworkUpdateReturnType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NetworkUpdateReturnType fromValue(String v) {
        for (NetworkUpdateReturnType c: NetworkUpdateReturnType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
