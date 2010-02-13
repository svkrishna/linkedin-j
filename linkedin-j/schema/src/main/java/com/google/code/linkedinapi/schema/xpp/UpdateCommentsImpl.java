
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
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
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("update-comment")) {
    			UpdateCommentImpl updateCommentImpl = new UpdateCommentImpl();
    			updateCommentImpl.init(parser);
    			getUpdateCommentList().add(updateCommentImpl);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "update-comments");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (UpdateComment updateComment : getUpdateCommentList()) {
			((UpdateCommentImpl) updateComment).toXml(serializer);
		}
		serializer.endTag(null, "update-comments");
	}
}
