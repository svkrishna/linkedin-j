//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.12.03 at 03:51:06 PM GMT+05:00 
//


package com.google.code.linkedinapi.schema.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Person;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "person"
})
@XmlRootElement(name = "connections")
public class ConnectionsImpl implements Connections
{

    @XmlElement(type = PersonImpl.class)
    protected List<Person> person;
    @XmlAttribute(required = true)
    protected BigInteger total;

    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<Person>();
        }
        return this.person;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger value) {
        this.total = value;
    }

}
