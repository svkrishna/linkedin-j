
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.Updates;

public class NetworkImpl
    extends BaseSchemaEntity
    implements Network
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6143437997201279562L;
	protected NetworkStatsImpl networkStats;
    protected UpdatesImpl updates;

    public NetworkStats getNetworkStats() {
        return networkStats;
    }

    public void setNetworkStats(NetworkStats value) {
        this.networkStats = ((NetworkStatsImpl) value);
    }

    public Updates getUpdates() {
        return updates;
    }

    public void setUpdates(Updates value) {
        this.updates = ((UpdatesImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		Element networkStatsElem = (Element) XppUtils.getChildElementByName(parser, "network-stats");
		if (networkStatsElem != null) {
			NetworkStatsImpl networkStatsImpl = new NetworkStatsImpl();
			networkStatsImpl.init(networkStatsElem);
			setNetworkStats(networkStatsImpl);
		}
		Element updateElem = (Element) XppUtils.getChildElementByName(parser, "updates");
		if (updateElem != null) {
			UpdatesImpl updateImpl = new UpdatesImpl();
			updateImpl.init(updateElem);
			setUpdates(updateImpl);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("network");
		if (getNetworkStats() != null) {
			element.appendChild(((NetworkStatsImpl) getNetworkStats()).toXml(serializer));
		}
		if (getUpdates() != null) {
			element.appendChild(((UpdatesImpl) getUpdates()).toXml(serializer));
		}
		return element;
	}
}
