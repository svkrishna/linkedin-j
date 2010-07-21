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

import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.Location;

public class LocationImpl
    extends BaseSchemaEntity
    implements Location
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8469907482652062050L;
	protected String name;
    protected CountryImpl country;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = ((CountryImpl) value);
    }

	@Override
	public void init(Element element) {
		Element countryElem = (Element) DomUtils.getChildElementByName(element, "country");
		if (countryElem != null) {
			CountryImpl countryImpl = new CountryImpl();
			countryImpl.init(countryElem);
			setCountry(countryImpl);
		}
		setName(DomUtils.getElementValueFromNode(element, "name"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("location");
		DomUtils.setElementValueToNode(element, "name", getName());
		
		if (getCountry() != null) {
			element.appendChild(((CountryImpl) getCountry()).toXml(document));
		}
		return element;
	}
}
