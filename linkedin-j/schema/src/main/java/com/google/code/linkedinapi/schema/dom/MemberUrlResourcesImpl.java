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

import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;

public class MemberUrlResourcesImpl
    extends BaseSchemaEntity
    implements MemberUrlResources
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4293798758625787079L;
    protected List<MemberUrl> memberUrlList;

    public List<MemberUrl> getMemberUrlList() {
        if (memberUrlList == null) {
            memberUrlList = new ArrayList<MemberUrl>();
        }
        return this.memberUrlList;
    }

	@Override
	public void init(Element element) {
		List<Element> memberUrlElems = DomUtils.getChildElementsByLocalName(element, "member-url");
		for (Element memberUrlElem : memberUrlElems) {
			MemberUrlImpl memberUrlImpl = new MemberUrlImpl();
			memberUrlImpl.init(memberUrlElem);
			getMemberUrlList().add(memberUrlImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("member-url-resources");
		for (MemberUrl memberUrl : getMemberUrlList()) {
			element.appendChild(((MemberUrlImpl) memberUrl).toXml(document));
		}
		return element;
	}

}
