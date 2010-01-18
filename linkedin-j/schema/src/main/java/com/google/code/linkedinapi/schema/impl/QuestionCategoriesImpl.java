
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.QuestionCategories;
import com.google.code.linkedinapi.schema.QuestionCategory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "questionCategoryList"
})
@XmlRootElement(name = "question-categories")
public class QuestionCategoriesImpl
    implements Serializable, QuestionCategories
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "question-category", required = true, type = QuestionCategoryImpl.class)
    protected List<QuestionCategory> questionCategoryList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
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

}
