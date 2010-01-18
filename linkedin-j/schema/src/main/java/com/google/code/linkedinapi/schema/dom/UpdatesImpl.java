
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.Updates;

public class UpdatesImpl
    extends BaseSchemaEntity
    implements Updates
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6353261321228473792L;
	protected List<Update> update;
    protected Long total;
    protected Long count;
    protected Long start;
    

    public List<Update> getUpdateList() {
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
	public void init(Element element) {
		setTotal(DomUtils.getAttributeValueAsLongFromNode(element, "total"));
		setStart(DomUtils.getAttributeValueAsLongFromNode(element, "start"));
		setCount(DomUtils.getAttributeValueAsLongFromNode(element, "count"));
		List<Element> updateElems = DomUtils.getChildElementsByLocalName(element, "update");
		for (Element updateElem : updateElems) {
			UpdateImpl updateImpl = new UpdateImpl();
			updateImpl.init(updateElem);
			getUpdateList().add(updateImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("updates");
		DomUtils.setAttributeValueToNode(element, "total", getTotal());
		DomUtils.setAttributeValueToNode(element, "start", getStart());
		DomUtils.setAttributeValueToNode(element, "count", getCount());
		for (Update update : getUpdateList()) {
			element.appendChild(((UpdateImpl) update).toXml(document));
		}
		return element;
	}
}
