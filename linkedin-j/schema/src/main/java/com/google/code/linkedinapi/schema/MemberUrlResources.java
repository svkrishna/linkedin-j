
package com.google.code.linkedinapi.schema;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}member-url"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface MemberUrlResources
    extends SchemaEntity
{


    /**
     * Gets the value of the memberUrl property.
     * 
     * @return
     *     possible object is
     *     {@link MemberUrl }
     *     
     */
    MemberUrl getMemberUrl();

    /**
     * Sets the value of the memberUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberUrl }
     *     
     */
    void setMemberUrl(MemberUrl value);

}
