
package com.google.code.linkedinapi.schema.sax;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml(Document document) {
		// TODO Auto-generated method stub
		return null;
	}

}
