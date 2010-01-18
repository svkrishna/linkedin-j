
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
import com.google.code.linkedinapi.schema.Answer;
import com.google.code.linkedinapi.schema.Answers;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "answerList"
})
@XmlRootElement(name = "answers")
public class AnswersImpl
    implements Serializable, Answers
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "answer", required = true, type = AnswerImpl.class)
    protected List<Answer> answerList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long count;

    public List<Answer> getAnswerList() {
        if (answerList == null) {
            answerList = new ArrayList<Answer>();
        }
        return this.answerList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

}
