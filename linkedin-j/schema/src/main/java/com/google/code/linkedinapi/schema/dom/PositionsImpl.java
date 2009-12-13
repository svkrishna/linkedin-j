
package com.google.code.linkedinapi.schema.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;

public class PositionsImpl
    extends BaseSchemaEntity
    implements Positions
{

    protected List<Position> position;
    protected Long total;

    public List<Position> getPosition() {
        if (position == null) {
            position = new ArrayList<Position>();
        }
        return this.position;
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
		List<Element> positionElems = DomUtils.getChildElementsByLocalName(element, "position");
		for (Element positionElem : positionElems) {
			PositionImpl positionImpl = new PositionImpl();
			positionImpl.init(positionElem);
			getPosition().add(positionImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("positions");
		element.setAttribute("total", String.valueOf(getTotal()));
		for (Position position : getPosition()) {
			element.appendChild(((PositionImpl) position).toXml(document));
		}
		return element;
	}
}
