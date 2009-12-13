
package com.google.code.linkedinapi.schema.sax;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Headers;

public class ApiStandardProfileRequestImpl
    extends UrlImpl
    implements ApiStandardProfileRequest
{
    protected HeadersImpl headers;

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }

}
