
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public void init(Element element) {
		Element requestElem = (Element) DomUtils.getChildElementByName(element, "invitation-request");
		if (requestElem != null) {
			InvitationRequestImpl requestImpl = new InvitationRequestImpl();
			requestImpl.init(requestElem);
			setInvitationRequest(requestImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("item-content");
		if (getInvitationRequest() != null) {
			element.appendChild(((InvitationRequestImpl) getInvitationRequest()).toXml(document));
		}
		return element;
	}

}
