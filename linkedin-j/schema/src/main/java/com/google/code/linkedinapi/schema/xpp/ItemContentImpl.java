
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
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
	public void init(XmlPullParser parser) {
		Element requestElem = (Element) XppUtils.getChildElementByName(parser, "invitation-request");
		if (requestElem != null) {
			InvitationRequestImpl requestImpl = new InvitationRequestImpl();
			requestImpl.init(requestElem);
			setInvitationRequest(requestImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("item-content");
		if (getInvitationRequest() != null) {
			element.appendChild(((InvitationRequestImpl) getInvitationRequest()).toXml(serializer));
		}
		return element;
	}

}
