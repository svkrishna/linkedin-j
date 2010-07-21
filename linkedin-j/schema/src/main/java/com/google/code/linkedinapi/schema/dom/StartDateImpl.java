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

import com.google.code.linkedinapi.schema.StartDate;

public class StartDateImpl
	extends BaseSchemaEntity
    implements StartDate
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3332888832061238011L;
	protected Long year;
    protected Long month;

    public Long getYear() {
        return year;
    }

    public void setYear(Long value) {
        this.year = value;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long value) {
        this.month = value;
    }
    
	@Override
	public void init(Element element) {
		setYear(DomUtils.getElementValueAsLongFromNode(element, "year"));
		setMonth(DomUtils.getElementValueAsLongFromNode(element, "month"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("start-date");
		DomUtils.setElementValueToNode(element, "month", getMonth());
		DomUtils.setElementValueToNode(element, "year", getYear());
		return element;
	}
}
