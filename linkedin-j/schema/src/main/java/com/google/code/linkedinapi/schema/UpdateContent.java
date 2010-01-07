
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
 *       &lt;choice>
 *         &lt;element ref="{}person"/>
 *         &lt;element ref="{}job"/>
 *         &lt;element ref="{}question"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface UpdateContent
    extends SchemaEntity
{


    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    Person getPerson();

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    void setPerson(Person value);

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link Job }
     *     
     */
    Job getJob();

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link Job }
     *     
     */
    void setJob(Job value);

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link Question }
     *     
     */
    Question getQuestion();

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link Question }
     *     
     */
    void setQuestion(Question value);

}
