
package com.google.code.linkedinapi.schema.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Recipient;
import com.google.code.linkedinapi.schema.Recipients;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recipient"
})
@XmlRootElement(name = "recipients")
public class RecipientsImpl
    extends BaseSchemaEntity
    implements Recipients
{

    @XmlElement(required = true, type = RecipientImpl.class)
    protected List<Recipient> recipient;

    public List<Recipient> getRecipient() {
        if (recipient == null) {
            recipient = new ArrayList<Recipient>();
        }
        return this.recipient;
    }

}
