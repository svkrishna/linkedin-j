/*
 * Copyright 2010 Nabeel Mukhtar 
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
package com.google.code.linkedinapi.schema.dom;

import java.io.Serializable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The Class BaseSchemaEntity.
 * 
 * @author Nabeel Mukhtar
 */
public abstract class BaseSchemaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4249791194912997698L;

	/**
	 * To xml.
	 * 
	 * @param document the document
	 * 
	 * @return the element
	 */
	public abstract Element toXml(Document document);
	
	/**
	 * Inits the.
	 * 
	 * @param element the element
	 */
	public abstract void init(Element element);
	
	
}
