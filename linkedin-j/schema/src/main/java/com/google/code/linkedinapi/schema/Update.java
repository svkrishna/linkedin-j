
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
 *         &lt;element ref="{}timestamp"/>
 *         &lt;element ref="{}update-key"/>
 *         &lt;element ref="{}update-type"/>
 *         &lt;element ref="{}update-content"/>
 *         &lt;element ref="{}is-commentable"/>
 *         &lt;element ref="{}update-comments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Update
    extends SchemaEntity
{


    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getTimestamp();

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setTimestamp(Long value);

    /**
     * Gets the value of the updateKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getUpdateKey();

    /**
     * Sets the value of the updateKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setUpdateKey(String value);

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkUpdateReturnType }
     *     
     */
    NetworkUpdateReturnType getUpdateType();

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkUpdateReturnType }
     *     
     */
    void setUpdateType(NetworkUpdateReturnType value);

    /**
     * Gets the value of the updateContent property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateContent }
     *     
     */
    UpdateContent getUpdateContent();

    /**
     * Sets the value of the updateContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateContent }
     *     
     */
    void setUpdateContent(UpdateContent value);

    /**
     * Gets the value of the isCommentable property.
     * 
     */
    boolean isIsCommentable();

    /**
     * Sets the value of the isCommentable property.
     * 
     */
    void setIsCommentable(boolean value);

    /**
     * Gets the value of the updateComments property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateComments }
     *     
     */
    UpdateComments getUpdateComments();

    /**
     * Sets the value of the updateComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateComments }
     *     
     */
    void setUpdateComments(UpdateComments value);

}
