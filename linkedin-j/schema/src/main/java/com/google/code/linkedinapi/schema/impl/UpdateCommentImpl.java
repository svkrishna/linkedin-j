
package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.UpdateComment;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "comment"
})
@XmlRootElement(name = "update-comment")
public class UpdateCommentImpl
    extends BaseSchemaEntity
    implements UpdateComment
{

    @XmlElement(required = true)
    protected String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

}
