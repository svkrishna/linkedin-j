
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
 *         &lt;element ref="{}im-account-type"/>
 *         &lt;element ref="{}im-account-name"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface ImAccount
    extends SchemaEntity
{


    /**
     * Gets the value of the imAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link ImAccountType }
     *     
     */
    ImAccountType getImAccountType();

    /**
     * Sets the value of the imAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImAccountType }
     *     
     */
    void setImAccountType(ImAccountType value);

    /**
     * Gets the value of the imAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getImAccountName();

    /**
     * Sets the value of the imAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setImAccountName(String value);

}
