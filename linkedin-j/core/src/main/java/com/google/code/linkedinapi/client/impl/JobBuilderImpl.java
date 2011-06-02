/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.impl;

import com.google.code.linkedinapi.client.JobsApiClient.JobBuilder;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.SchemaElementFactory;

/**
 * @author nmukhtar
 *
 */
public class JobBuilderImpl implements JobBuilder {
	private final SchemaElementFactory<?> factory;
	private Job job;
	
	JobBuilderImpl(SchemaElementFactory<?> factory) {
		this.factory = factory;
		job = this.factory.createJob();
	}

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.client.JobsApiClient.JobBuilder#build()
	 */
	@Override
	public Job build() {
		return job;
	}
}
