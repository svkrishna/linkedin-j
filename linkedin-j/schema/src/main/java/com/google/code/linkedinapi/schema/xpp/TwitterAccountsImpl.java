
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.TwitterAccount;
import com.google.code.linkedinapi.schema.TwitterAccounts;

public class TwitterAccountsImpl
	extends BaseSchemaEntity
    implements Serializable, TwitterAccounts
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<TwitterAccount> twitterAccountList;
    protected Long total;

    public List<TwitterAccount> getTwitterAccountList() {
        if (twitterAccountList == null) {
            twitterAccountList = new ArrayList<TwitterAccount>();
        }
        return this.twitterAccountList;
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
        	
        	if (name.equals("twitter-account")) {
        		TwitterAccountImpl accountImpl = new TwitterAccountImpl();
    			accountImpl.init(parser);
    			getTwitterAccountList().add(accountImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "twitter-accounts");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (TwitterAccount account : getTwitterAccountList()) {
			((TwitterAccountImpl) account).toXml(serializer);
		}
		serializer.endTag(null, "twitter-accounts");
	}
}
