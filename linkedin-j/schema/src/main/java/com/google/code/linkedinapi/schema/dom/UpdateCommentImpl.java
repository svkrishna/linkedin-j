
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.UpdateComment;

public class UpdateCommentImpl
    extends BaseSchemaEntity
    implements UpdateComment
{

    protected String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

	@Override
	public void init(Element element) {
		setComment(DomUtils.getElementValueFromNode(element, "comment"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("update-comment");
		DomUtils.setElementValueToNode(element, "comment", getComment());
		return element;
	}
}
