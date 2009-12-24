
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.UpdateComment;

public class UpdateCommentImpl
	extends BaseSchemaEntity
    implements UpdateComment
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8511084386767332742L;
	protected Long sequenceNumber;
    protected String comment;
    protected PersonImpl person;

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long value) {
        this.sequenceNumber = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }
    
	@Override
	public void init(Element element) {
		setSequenceNumber(DomUtils.getElementValueAsLongFromNode(element, "sequence-number"));
		setComment(DomUtils.getElementValueFromNode(element, "comment"));
		Element personElem = DomUtils.getChildElementByName(element, "person");
		if (personElem != null) {
			PersonImpl person = new PersonImpl();
			person.init(personElem);
			setPerson(person);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("update-comment");
		DomUtils.setElementValueToNode(element, "comment", getComment());
		DomUtils.setElementValueToNode(element, "sequence-number", getSequenceNumber());
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(document));
		}
		return element;
	}
}
