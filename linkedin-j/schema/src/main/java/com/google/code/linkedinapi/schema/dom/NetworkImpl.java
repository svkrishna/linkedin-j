
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.NetworkStats;
import com.google.code.linkedinapi.schema.Updates;

public class NetworkImpl
    extends BaseSchemaEntity
    implements Network
{

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
	public void init(Element element) {
		Element networkStatsElem = (Element) DomUtils.getChildElementByName(element, "network-stats");
		if (networkStatsElem != null) {
			NetworkStatsImpl networkStatsImpl = new NetworkStatsImpl();
			networkStatsImpl.init(networkStatsElem);
			setNetworkStats(networkStatsImpl);
		}
		Element updateElem = (Element) DomUtils.getChildElementByName(element, "updates");
		if (updateElem != null) {
			UpdatesImpl updateImpl = new UpdatesImpl();
			updateImpl.init(updateElem);
			setUpdates(updateImpl);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("network");
		if (getNetworkStats() != null) {
			element.appendChild(((NetworkStatsImpl) getNetworkStats()).toXml(document));
		}
		if (getUpdates() != null) {
			element.appendChild(((UpdatesImpl) getUpdates()).toXml(document));
		}
		return element;
	}
}
