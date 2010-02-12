
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.RelationToViewer;

public class RelationToViewerImpl
    extends BaseSchemaEntity
    implements RelationToViewer
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5385043041125747824L;
	protected Long distance;

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setDistance(XppUtils.getElementValueAsLongFromNode(parser, "distance"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("relation-to-viewer");
		XppUtils.setElementValueToNode(element, "distance", getDistance());
		return element;
	}
}
