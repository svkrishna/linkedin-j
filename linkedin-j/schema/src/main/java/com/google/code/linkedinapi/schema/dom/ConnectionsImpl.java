
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Person;

public class ConnectionsImpl
    extends BaseSchemaEntity
    implements Connections
{
    protected List<Person> person;
    protected Long total;

    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<Person>();
        }
        return this.person;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
