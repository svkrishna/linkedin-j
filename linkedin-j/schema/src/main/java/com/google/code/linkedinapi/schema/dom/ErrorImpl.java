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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Error;

public class ErrorImpl
    extends BaseSchemaEntity
    implements Error
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7306088000916275288L;
	protected Long status;
    protected Long timestamp;
    protected String errorCode;
    protected String message;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long value) {
        this.status = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

	@Override
	public void init(Element element) {
		setStatus(DomUtils.getElementValueAsLongFromNode(element, "status"));
		setTimestamp(DomUtils.getElementValueAsLongFromNode(element, "timestamp"));
		setErrorCode(DomUtils.getElementValueFromNode(element, "error-code"));
		setMessage(DomUtils.getElementValueFromNode(element, "message"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("error");
		DomUtils.setElementValueToNode(element, "status", getStatus());
		DomUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		DomUtils.setElementValueToNode(element, "error-code", getErrorCode());
		DomUtils.setElementValueToNode(element, "message", getMessage());
		return element;
	}
}
