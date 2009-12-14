
package com.google.code.linkedinapi.schema.dom;

import com.google.code.linkedinapi.schema.Headers;
import com.google.code.linkedinapi.schema.SiteStandardProfileRequest;

public class SiteStandardProfileRequestImpl
    implements SiteStandardProfileRequest
{

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
