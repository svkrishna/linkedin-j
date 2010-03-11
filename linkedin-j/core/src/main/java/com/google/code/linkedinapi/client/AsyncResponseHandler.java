/**
 *
 */
package com.google.code.linkedinapi.client;

import java.util.concurrent.Future;

import com.google.code.linkedinapi.schema.SchemaEntity;

/**
 * The Abstract class AsyncResponseHandler.
 *
 * @author nmukhtar
 *
 * @param <T>
 */
public abstract class AsyncResponseHandler<T extends SchemaEntity> {
	
	private Future<T> future;
	
    /**
     * Set future
     *
     * @param future the future
     */
	public void setFuture(Future<T> future) {
		this.future = future;
	}
	
    /**
     * Get a reference to the future.
     *
     */
	public Future<T> getFuture() {
		return future;
	}

    /**
     * Handle response.
     *
     * @param response the response
     */
    public abstract void handleResponse(T response);
}
