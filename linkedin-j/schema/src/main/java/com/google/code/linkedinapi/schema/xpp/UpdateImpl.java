
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("timestamp")) {
        		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("update-key")) {
        		setUpdateKey(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("update-type")) {
        		setUpdateType(NetworkUpdateReturnType.fromValue(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("is-commentable")) {
        		setIsCommentable(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("update-content")) {
    			UpdateContentImpl contentImpl = new UpdateContentImpl();
    			contentImpl.init(parser);
    			setUpdateContent(contentImpl);
        	} else if (name.equals("update-comments")) {
    			UpdateCommentsImpl commentImpl = new UpdateCommentsImpl();
    			commentImpl.init(parser);
    			setUpdateComments(commentImpl);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "update");
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "update-key", getUpdateKey());
		XppUtils.setElementValueToNode(element, "update-type", getUpdateType().value());
		XppUtils.setElementValueToNode(element, "is-commentable", String.valueOf(isIsCommentable()));
		
		if (getUpdateContent() != null) {
			((UpdateContentImpl) getUpdateContent()).toXml(serializer);
		}
		if (getUpdateComments() != null) {
			((UpdateCommentsImpl) getUpdateComments()).toXml(serializer);
		}
		serializer.endTag(null, "update");
	}
}
