
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.ItemContent;

public class ItemContentImpl
    extends BaseSchemaEntity
    implements ItemContent
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7058461180502985977L;
	protected InvitationRequestImpl invitationRequest;

    public InvitationRequest getInvitationRequest() {
        return invitationRequest;
    }

    public void setInvitationRequest(InvitationRequest value) {
        this.invitationRequest = ((InvitationRequestImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("invitation-request")) {
    			InvitationRequestImpl requestImpl = new InvitationRequestImpl();
    			requestImpl.init(parser);
    			setInvitationRequest(requestImpl);
        	}
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "item-content");
		if (getInvitationRequest() != null) {
			((InvitationRequestImpl) getInvitationRequest()).toXml(element);
		}
		serializer.endTag(null, "item-content");
	}
}
