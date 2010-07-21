/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		setTimestamp(DomUtils.getElementValueAsLongFromNode(element, "timestamp"));
		setUpdateKey(DomUtils.getElementValueFromNode(element, "update-key"));
		setUpdateType(NetworkUpdateReturnType.fromValue(DomUtils.getElementValueFromNode(element, "update-type")));
		setIsCommentable(Boolean.parseBoolean(DomUtils.getElementValueFromNode(element, "is-commentable")));
		Element contentElem = (Element) DomUtils.getChildElementByName(element, "update-content");
		if (contentElem != null) {
			UpdateContentImpl contentImpl = new UpdateContentImpl();
			contentImpl.init(contentElem);
			setUpdateContent(contentImpl);
		}

		Element commentElem = (Element) DomUtils.getChildElementByName(element, "update-comments");
		if (commentElem != null) {
			UpdateCommentsImpl commentImpl = new UpdateCommentsImpl();
			commentImpl.init(commentElem);
			setUpdateComments(commentImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("update");
		DomUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		DomUtils.setElementValueToNode(element, "update-key", getUpdateKey());
		DomUtils.setElementValueToNode(element, "update-type", getUpdateType().value());
		DomUtils.setElementValueToNode(element, "is-commentable", String.valueOf(isIsCommentable()));
		
		if (getUpdateContent() != null) {
			element.appendChild(((UpdateContentImpl) getUpdateContent()).toXml(document));
		}
		if (getUpdateComments() != null) {
			element.appendChild(((UpdateCommentsImpl) getUpdateComments()).toXml(document));
		}
		return element;
	}
}
