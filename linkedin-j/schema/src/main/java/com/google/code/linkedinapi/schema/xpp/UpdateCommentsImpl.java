
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;

public class UpdateCommentsImpl
	extends BaseSchemaEntity
    implements UpdateComments
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6923754393295869466L;
	protected List<UpdateComment> updateCommentList;
    protected Long total;

    public List<UpdateComment> getUpdateCommentList() {
        if (updateCommentList == null) {
            updateCommentList = new ArrayList<UpdateComment>();
        }
        return this.updateCommentList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		List<Element> updateComments = XppUtils.getChildElementsByLocalName(parser, "update-comment");
		for (Element updateComment : updateComments) {
			UpdateCommentImpl updateCommentImpl = new UpdateCommentImpl();
			updateCommentImpl.init(updateComment);
			getUpdateCommentList().add(updateCommentImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("update-comments");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (UpdateComment updateComment : getUpdateCommentList()) {
			element.appendChild(((UpdateCommentImpl) updateComment).toXml(serializer));
		}
		return element;
	}
}
