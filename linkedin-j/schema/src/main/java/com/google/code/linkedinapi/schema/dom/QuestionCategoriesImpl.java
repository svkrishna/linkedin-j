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

import com.google.code.linkedinapi.schema.QuestionCategories;
import com.google.code.linkedinapi.schema.QuestionCategory;

public class QuestionCategoriesImpl
	extends BaseSchemaEntity
    implements QuestionCategories
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<QuestionCategory> questionCategoryList;
    protected Long total;

    public List<QuestionCategory> getQuestionCategoryList() {
        if (questionCategoryList == null) {
            questionCategoryList = new ArrayList<QuestionCategory>();
        }
        return this.questionCategoryList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }
    
	@Override
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		List<Element> categories = DomUtils.getChildElementsByLocalName(element, "question-category");
		for (Element education : categories) {
			QuestionCategoryImpl categoryImpl = new QuestionCategoryImpl();
			categoryImpl.init(education);
			getQuestionCategoryList().add(categoryImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("question-categories");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		for (QuestionCategory category : getQuestionCategoryList()) {
			element.appendChild(((QuestionCategoryImpl) category).toXml(document));
		}
		return element;
	}
}
