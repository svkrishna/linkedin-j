
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.QuestionCategories;
import com.google.code.linkedinapi.schema.QuestionCategory;

public class QuestionCategoriesImpl
	extends BaseSchemaEntity
    implements QuestionCategories
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<QuestionCategory> questionCategory;
    protected Long total;

    public List<QuestionCategory> getQuestionCategory() {
        if (questionCategory == null) {
            questionCategory = new ArrayList<QuestionCategory>();
        }
        return this.questionCategory;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
