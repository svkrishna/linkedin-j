
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccountType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imAccountType",
    "imAccountName"
})
@XmlRootElement(name = "im-account")
public class ImAccountImpl
    implements Serializable, ImAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "im-account-type", required = true)
    protected ImAccountType imAccountType;
    @XmlElement(name = "im-account-name", required = true)
    protected String imAccountName;

    public ImAccountType getImAccountType() {
        return imAccountType;
    }

    public void setImAccountType(ImAccountType value) {
        this.imAccountType = value;
    }

    public String getImAccountName() {
        return imAccountName;
    }

    public void setImAccountName(String value) {
        this.imAccountName = value;
    }

}
