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

import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.SiteGroupRequest;

public class MemberGroupImpl
	extends BaseSchemaEntity
    implements MemberGroup
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected SiteGroupRequestImpl siteGroupRequest;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public SiteGroupRequest getSiteGroupRequest() {
        return siteGroupRequest;
    }

    public void setSiteGroupRequest(SiteGroupRequest value) {
        this.siteGroupRequest = ((SiteGroupRequestImpl) value);
    }
    
	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setName(DomUtils.getElementValueFromNode(element, "name"));
		
		Element siteGroupElem = (Element) DomUtils.getChildElementByName(element, "site-group-request");
		if (siteGroupElem != null) {
			SiteGroupRequestImpl siteGroup = new SiteGroupRequestImpl();
			siteGroup.init(siteGroupElem);
			setSiteGroupRequest(siteGroup);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-group");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "name", getName());
		if (getSiteGroupRequest() != null) {
			element.appendChild(((SiteGroupRequestImpl) getSiteGroupRequest()).toXml(document));
		}
		return element;
	}
}
