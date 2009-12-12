
package com.google.code.linkedinapi.schema.dom;

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
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
