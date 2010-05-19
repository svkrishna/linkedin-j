
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccounts;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imAccountList"
})
@XmlRootElement(name = "im-accounts")
public class ImAccountsImpl
    implements Serializable, ImAccounts
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "im-account", type = ImAccountImpl.class)
    protected ImAccountImpl imAccountList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

    public ImAccount getImAccountList() {
        return imAccountList;
    }

    public void setImAccountList(ImAccount value) {
        this.imAccountList = ((ImAccountImpl) value);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
