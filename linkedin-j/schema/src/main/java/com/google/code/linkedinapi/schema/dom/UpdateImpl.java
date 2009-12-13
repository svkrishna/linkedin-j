
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.NetworkUpdateReturnType;
import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.UpdateContent;

public class UpdateImpl
    extends BaseSchemaEntity
    implements Update
{

    protected Long timestamp;
    protected String updateKey;
    protected NetworkUpdateReturnType updateType;
    protected UpdateContentImpl updateContent;
    protected boolean isCommentable;

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

	@Override
	public void init(Element element) {
		setTimestamp(DomUtils.getElementValueAsLongFromNode(element, "timestamp"));
		setUpdateKey(DomUtils.getElementValueFromNode(element, "update-key"));
		setUpdateType(NetworkUpdateReturnType.valueOf(DomUtils.getElementValueFromNode(element, "update-type")));
		setIsCommentable(Boolean.parseBoolean(DomUtils.getElementValueFromNode(element, "is-commentable")));
		Element contentElem = (Element) DomUtils.getChildNode(element, "update-content");
		if (contentElem != null) {
			UpdateContentImpl contentImpl = new UpdateContentImpl();
			contentImpl.init(contentElem);
			setUpdateContent(contentImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("update");
		DomUtils.setElementValueToNode(element, "timestamp", String.valueOf(getTimestamp()));
		DomUtils.setElementValueToNode(element, "update-key", getUpdateKey());
		DomUtils.setElementValueToNode(element, "update-type", getUpdateType().value());
		DomUtils.setElementValueToNode(element, "is-commentable", String.valueOf(isIsCommentable()));
		
		if (getUpdateContent() != null) {
			element.appendChild(((UpdateContentImpl) getUpdateContent()).toXml(document));
		}
		return element;
	}

}
