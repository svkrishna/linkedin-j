
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.UpdateContent;

public class UpdateImpl
	extends BaseSchemaEntity
    implements Update
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 298287987891947325L;
	protected Long timestamp;
    protected String updateKey;
    protected NetworkUpdateReturnType updateType;
    protected UpdateContentImpl updateContent;
    protected boolean isCommentable;
    protected UpdateCommentsImpl updateComments;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String value) {
        this.updateKey = value;
    }

    public NetworkUpdateReturnType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(NetworkUpdateReturnType value) {
        this.updateType = value;
    }

    public UpdateContent getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(UpdateContent value) {
        this.updateContent = ((UpdateContentImpl) value);
    }

    public boolean isIsCommentable() {
        return isCommentable;
    }

    public void setIsCommentable(boolean value) {
        this.isCommentable = value;
    }

    public UpdateComments getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(UpdateComments value) {
        this.updateComments = ((UpdateCommentsImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser, "timestamp"));
		setUpdateKey(XppUtils.getElementValueFromNode(parser, "update-key"));
		setUpdateType(NetworkUpdateReturnType.fromValue(XppUtils.getElementValueFromNode(parser, "update-type")));
		setIsCommentable(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser, "is-commentable")));
		Element contentElem = (Element) XppUtils.getChildElementByName(parser, "update-content");
		if (contentElem != null) {
			UpdateContentImpl contentImpl = new UpdateContentImpl();
			contentImpl.init(contentElem);
			setUpdateContent(contentImpl);
		}

		Element commentElem = (Element) XppUtils.getChildElementByName(parser, "update-comments");
		if (commentElem != null) {
			UpdateCommentsImpl commentImpl = new UpdateCommentsImpl();
			commentImpl.init(commentElem);
			setUpdateComments(commentImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("update");
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "update-key", getUpdateKey());
		XppUtils.setElementValueToNode(element, "update-type", getUpdateType().value());
		XppUtils.setElementValueToNode(element, "is-commentable", String.valueOf(isIsCommentable()));
		
		if (getUpdateContent() != null) {
			element.appendChild(((UpdateContentImpl) getUpdateContent()).toXml(serializer));
		}
		if (getUpdateComments() != null) {
			element.appendChild(((UpdateCommentsImpl) getUpdateComments()).toXml(serializer));
		}
		return element;
	}
}
