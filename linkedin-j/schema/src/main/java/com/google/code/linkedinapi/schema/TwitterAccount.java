
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
 *         &lt;element ref="{}provider-account-id"/>
 *         &lt;element ref="{}provider-account-name"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface TwitterAccount
    extends SchemaEntity
{


    /**
     * Gets the value of the providerAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getProviderAccountId();

    /**
     * Sets the value of the providerAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setProviderAccountId(Long value);

    /**
     * Gets the value of the providerAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getProviderAccountName();

    /**
     * Sets the value of the providerAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setProviderAccountName(String value);

}
