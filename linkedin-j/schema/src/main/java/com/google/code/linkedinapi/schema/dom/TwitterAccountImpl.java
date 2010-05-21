
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.TwitterAccount;

public class TwitterAccountImpl
	extends BaseSchemaEntity
    implements Serializable, TwitterAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long providerAccountId;
    protected String providerAccountName;

    public Long getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(Long value) {
        this.providerAccountId = value;
    }

    public String getProviderAccountName() {
        return providerAccountName;
    }

    public void setProviderAccountName(String value) {
        this.providerAccountName = value;
    }
	@Override
	public void init(Element element) {
		setProviderAccountName(DomUtils.getElementValueFromNode(element, "provider-account-name"));
		setProviderAccountId(DomUtils.getElementValueAsLongFromNode(element, "provider-account-id"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("twitter-account");
		DomUtils.setElementValueToNode(element, "provider-account-name", getProviderAccountName());
		DomUtils.setElementValueToNode(element, "provider-account-id", getProviderAccountId());
		return element;
	}
}
