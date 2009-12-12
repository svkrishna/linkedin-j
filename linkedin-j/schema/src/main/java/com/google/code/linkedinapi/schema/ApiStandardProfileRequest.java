
package com.google.code.linkedinapi.schema;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}url">
 *       &lt;sequence>
 *         &lt;element ref="{}headers"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface ApiStandardProfileRequest
    extends Url
{


    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link Headers }
     *     
     */
    Headers getHeaders();

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Headers }
     *     
     */
    void setHeaders(Headers value);

}
