
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.SiteJobRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "url",
    "headers"
})
@XmlRootElement(name = "site-job-request")
public class SiteJobRequestImpl
    implements Serializable, SiteJobRequest
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String url;
    @XmlElement(type = HeadersImpl.class)
    protected HeadersImpl headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }

}
