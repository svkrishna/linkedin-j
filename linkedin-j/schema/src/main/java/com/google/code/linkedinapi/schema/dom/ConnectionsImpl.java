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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Person;

public class ConnectionsImpl
    extends BaseSchemaEntity
    implements Connections
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8957482129134944707L;
	protected List<Person> personList;
    protected Long count;
    protected Long start;
    protected Long total;

    public List<Person> getPersonList() {
        if (personList == null) {
            personList = new ArrayList<Person>();
        }
        return this.personList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }
    
    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long value) {
        this.start = value;
    }
    
	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		setStart(DomUtils.getAttributeValueAsLongFromNode(element, "start"));
		setCount(DomUtils.getAttributeValueAsLongFromNode(element, "count"));
		List<Element> persons = DomUtils.getChildElementsByLocalName(element, "person");
		for (Element person : persons) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(person);
			getPersonList().add(personImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("connections");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		DomUtils.setAttributeValueToNode(element, "start", getStart());
		DomUtils.setAttributeValueToNode(element, "count", getCount());
		for (Person person : getPersonList()) {
			element.appendChild(((PersonImpl) person).toXml(document));
		}
		return element;
	}
}
