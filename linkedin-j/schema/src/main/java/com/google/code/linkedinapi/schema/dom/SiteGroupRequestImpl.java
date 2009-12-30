
package com.google.code.linkedinapi.schema.dom;

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.SiteGroupRequest;

public class SiteGroupRequestImpl
	extends BaseSchemaEntity
    implements SiteGroupRequest
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String url;
    protected HeadersImpl headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }

}
