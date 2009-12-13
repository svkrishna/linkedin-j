
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.RelationToViewer;

public class RelationToViewerImpl
    extends BaseSchemaEntity
    implements RelationToViewer
{

    protected Long distance;

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

	@Override
	public void init(Element element) {
		setDistance(DomUtils.getElementValueAsLongFromNode(element, "distance"));
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("relation-to-viewer");
		DomUtils.setElementValueToNode(element, "distance", String.valueOf(getDistance()));
		return element;
	}
}
