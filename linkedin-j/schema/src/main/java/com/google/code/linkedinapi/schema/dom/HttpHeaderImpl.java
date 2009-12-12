
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.HttpHeader;

public class HttpHeaderImpl
    extends BaseSchemaEntity
    implements HttpHeader
{
    protected String name;
    protected String value;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	@Override
	public void init(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
