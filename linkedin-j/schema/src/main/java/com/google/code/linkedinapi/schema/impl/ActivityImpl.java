
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.NetworkUpdateContentType;
import org.w3._2001.xmlschema.Adapter1;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "timestamp",
    "contentType",
    "body"
})
@XmlRootElement(name = "activity")
public class ActivityImpl
    extends BaseSchemaEntity
    implements Activity
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "integer")
    protected Long timestamp;
    @XmlElement(name = "content-type", required = true)
    protected NetworkUpdateContentType contentType;
    @XmlElement(required = true)
    protected String body;
    @XmlAttribute(required = true)
    protected String locale;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public NetworkUpdateContentType getContentType() {
        return contentType;
    }

    public void setContentType(NetworkUpdateContentType value) {
        this.contentType = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String value) {
        this.locale = value;
    }

}
