
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

public class PeopleImpl
    extends BaseSchemaEntity
    implements People
{

    protected List<Person> person;
    protected Long count;
    protected Long start;
    protected Long total;

    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<Person>();
        }
        return this.person;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		setTotal(Long.valueOf(element.getAttribute("total")));
		setStart(Long.valueOf(element.getAttribute("start")));
		setCount(Long.valueOf(element.getAttribute("count")));
		List<Element> persons = DomUtils.getChildElementsByLocalName(element, "person");
		for (Element person : persons) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(person);
			getPerson().add(personImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("people");
		element.setAttribute("total", String.valueOf(getTotal()));
		element.setAttribute("start", String.valueOf(getStart()));
		element.setAttribute("count", String.valueOf(getCount()));
		for (Person person : getPerson()) {
			element.appendChild(((PersonImpl) person).toXml(document));
		}
		return element;
	}
}
