
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.HttpHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "httpHeaderList"
})
@XmlRootElement(name = "headers")
public class HeadersImpl
    implements Serializable, Headers
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "http-header", required = true, type = HttpHeaderImpl.class)
    protected List<HttpHeader> httpHeaderList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public List<HttpHeader> getHttpHeaderList() {
        if (httpHeaderList == null) {
            httpHeaderList = new ArrayList<HttpHeader>();
        }
        return this.httpHeaderList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
