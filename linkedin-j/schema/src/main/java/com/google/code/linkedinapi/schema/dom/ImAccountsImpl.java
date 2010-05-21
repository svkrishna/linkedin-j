
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccounts;

public class ImAccountsImpl
	extends BaseSchemaEntity
    implements Serializable, ImAccounts
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<ImAccount> imAccountList;
    protected Long total;

    public List<ImAccount> getImAccountList() {
        if (imAccountList == null) {
        	imAccountList = new ArrayList<ImAccount>();
        }
        return imAccountList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> imAccountElems = DomUtils.getChildElementsByLocalName(element, "im-account");
		for (Element accountElem : imAccountElems) {
			ImAccountImpl accountImpl = new ImAccountImpl();
			accountImpl.init(accountElem);
			getImAccountList().add(accountImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("im-accounts");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (ImAccount account : getImAccountList()) {
			element.appendChild(((ImAccountImpl) account).toXml(document));
		}
		return element;
	}
}
