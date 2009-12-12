
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.Updates;

public class UpdatesImpl
    extends BaseSchemaEntity
    implements Updates
{

    protected List<Update> update;
    protected Long total;

    public List<Update> getUpdate() {
        if (update == null) {
            update = new ArrayList<Update>();
        }
        return this.update;
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
