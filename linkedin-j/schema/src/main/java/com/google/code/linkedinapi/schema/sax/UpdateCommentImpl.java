
package com.google.code.linkedinapi.schema.sax;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

}
