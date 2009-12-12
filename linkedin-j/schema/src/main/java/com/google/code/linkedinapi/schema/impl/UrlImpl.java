
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Url;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "url", propOrder = {
    "url"
})
@XmlSeeAlso({
    ApiStandardProfileRequestImpl.class,
    MemberUrlImpl.class
})
public class UrlImpl
    extends BaseSchemaEntity
    implements Url
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

}
