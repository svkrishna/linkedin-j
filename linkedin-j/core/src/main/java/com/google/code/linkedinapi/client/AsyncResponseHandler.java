/**
 *
 */
package com.google.code.linkedinapi.client;

import com.google.code.linkedinapi.schema.SchemaEntity;

/**
 * The Interface AsyncResponseHandler.
 *
 * @author nmukhtar
 *
 * @param <T>
 */
public interface AsyncResponseHandler<T extends SchemaEntity> {

    /**
     * Handle response.
     *
     * @param response the response
     */
    public void handleResponse(T response);
}
