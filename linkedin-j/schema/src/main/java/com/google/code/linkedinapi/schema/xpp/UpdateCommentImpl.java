
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
    protected String id;
	protected Long sequenceNumber;
    protected String comment;
    protected PersonImpl person;
    protected Long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }
    
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
    
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }
    
	@Override
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setSequenceNumber(XppUtils.getElementValueAsLongFromNode(parser, "sequence-number"));
		setComment(XppUtils.getElementValueFromNode(parser, "comment"));
		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser, "timestamp"));
		Element personElem = XppUtils.getChildElementByName(parser, "person");
		if (personElem != null) {
			PersonImpl person = new PersonImpl();
			person.init(personElem);
			setPerson(person);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("update-comment");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "comment", getComment());
		XppUtils.setElementValueToNode(element, "sequence-number", getSequenceNumber());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		if (getPerson() != null) {
			element.appendChild(((PersonImpl) getPerson()).toXml(serializer));
		}
		return element;
	}
}
