//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.12.10 at 07:27:01 PM GMT+05:00 
//


package com.google.code.linkedinapi.schema;

import java.math.BigInteger;


/**
 * <p>Java class for year complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="year">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}year"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Year {


    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    BigInteger getYear();

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    void setYear(BigInteger value);

}
