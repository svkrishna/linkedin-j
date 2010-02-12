
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Person;

public class ConnectionsImpl
    extends BaseSchemaEntity
    implements Connections
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8957482129134944707L;
	protected List<Person> personList;
    protected Long count;
    protected Long start;
    protected Long total;

    public List<Person> getPersonList() {
        if (personList == null) {
            personList = new ArrayList<Person>();
        }
        return this.personList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
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
    
	@Override
	public void init(XmlPullParser parser) {
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
		setStart(XppUtils.getAttributeValueAsLongFromNode(parser, "start"));
		setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));
		List<Element> persons = XppUtils.getChildElementsByLocalName(parser, "person");
		for (Element person : persons) {
			PersonImpl personImpl = new PersonImpl();
			personImpl.init(person);
			getPersonList().add(personImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("connections");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		XppUtils.setAttributeValueToNode(element, "start", getStart());
		XppUtils.setAttributeValueToNode(element, "count", getCount());
		for (Person person : getPersonList()) {
			element.appendChild(((PersonImpl) person).toXml(serializer));
		}
		return element;
	}
}
