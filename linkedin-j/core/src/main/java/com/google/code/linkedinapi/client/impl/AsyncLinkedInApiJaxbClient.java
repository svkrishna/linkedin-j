/**
 *
 */
package com.google.code.linkedinapi.client.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.code.linkedinapi.client.AsyncLinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClient;

/**
 * @author nmukhtar
 *
 */
public class AsyncLinkedInApiJaxbClient implements AsyncLinkedInApiClient {

    /** Field description */
    private ExecutorService taskExecutor;

    /** Field description */
    private LinkedInApiClient client;

    public AsyncLinkedInApiJaxbClient(LinkedInApiClient client) {
    	this.client = client;

    	taskExecutor = Executors.newCachedThreadPool();
    }

    /**
     * Method description
     *
     *
     * @param task
     *
     * @return
     */
    protected Future<?> execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Method description
     *
     *
     * @param task
     * @param <T>
     *
     * @return
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
    }
}
