
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;

public class PositionsImpl
    extends BaseSchemaEntity
    implements Positions
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1542568431460107248L;
	protected List<Position> positionList;
    protected Long total;

    public List<Position> getPositionList() {
        if (positionList == null) {
            positionList = new ArrayList<Position>();
        }
        return this.positionList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("position")) {
    			PositionImpl positionImpl = new PositionImpl();
    			positionImpl.init(parser);
    			getPositionList().add(positionImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "positions");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Position position : getPositionList()) {
			((PositionImpl) position).toXml(serializer);
		}
		serializer.endTag(null, "positions");
	}
}
