
package com.google.code.linkedinapi.schema.xpp;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

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
	protected List<Update> updateList;
    protected Long total;
    protected Long count;
    protected Long start;
    

    public List<Update> getUpdateList() {
        if (updateList == null) {
            updateList = new ArrayList<Update>();
        }
        return this.updateList;
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
		List<Element> updateElems = XppUtils.getChildElementsByLocalName(parser, "update");
		for (Element updateElem : updateElems) {
			UpdateImpl updateImpl = new UpdateImpl();
			updateImpl.init(updateElem);
			getUpdateList().add(updateImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("updates");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		XppUtils.setAttributeValueToNode(element, "start", getStart());
		XppUtils.setAttributeValueToNode(element, "count", getCount());
		for (Update update : getUpdateList()) {
			element.appendChild(((UpdateImpl) update).toXml(serializer));
		}
		return element;
	}
}
