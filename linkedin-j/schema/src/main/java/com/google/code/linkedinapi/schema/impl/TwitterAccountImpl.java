
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.TwitterAccount;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "providerAccountId",
    "providerAccountName"
})
@XmlRootElement(name = "twitter-account")
public class TwitterAccountImpl
    implements Serializable, TwitterAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "provider-account-id", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long providerAccountId;
    @XmlElement(name = "provider-account-name", required = true)
    protected String providerAccountName;

    public Long getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(Long value) {
        this.providerAccountId = value;
    }

    public String getProviderAccountName() {
        return providerAccountName;
    }

    public void setProviderAccountName(String value) {
        this.providerAccountName = value;
    }

}
