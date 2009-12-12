
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
 *         &lt;element ref="{}invitation-request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface ItemContent
    extends SchemaEntity
{


    /**
     * Gets the value of the invitationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InvitationRequest }
     *     
     */
    InvitationRequest getInvitationRequest();

    /**
     * Sets the value of the invitationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvitationRequest }
     *     
     */
    void setInvitationRequest(InvitationRequest value);

}
