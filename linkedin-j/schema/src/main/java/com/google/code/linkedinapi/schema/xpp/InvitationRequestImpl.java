
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Authorization;
import com.google.code.linkedinapi.schema.InvitationRequest;
import com.google.code.linkedinapi.schema.InviteConnectType;

public class InvitationRequestImpl
    extends BaseSchemaEntity
    implements InvitationRequest
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4777671180159209124L;
	protected InviteConnectType connectType;
    protected AuthorizationImpl authorization;

    public InviteConnectType getConnectType() {
        return connectType;
    }

    public void setConnectType(InviteConnectType value) {
        this.connectType = value;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization value) {
        this.authorization = ((AuthorizationImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		Element authElem = (Element) XppUtils.getChildElementByName(parser, "authorization");
		if (authElem != null) {
			AuthorizationImpl authImpl = new AuthorizationImpl();
			authImpl.init(authElem);
			setAuthorization(authImpl);
		}
		String connectTypeStr = XppUtils.getElementValueFromNode(parser, "connect-type");
		if (connectTypeStr != null) {
			setConnectType(InviteConnectType.fromValue(connectTypeStr));
		}
		
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("invitation-request");
		if (getConnectType() != null) {
			XppUtils.setElementValueToNode(element, "connect-type", getConnectType().value());
		}
		
		if (getAuthorization() != null) {
			element.appendChild(((AuthorizationImpl) getAuthorization()).toXml(serializer));
		}
		return element;
	}
}
