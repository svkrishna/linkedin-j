
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Error;

public class ErrorImpl
    extends BaseSchemaEntity
    implements Error
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7306088000916275288L;
	protected Long status;
    protected Long timestamp;
    protected String errorCode;
    protected String message;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long value) {
        this.status = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long value) {
        this.timestamp = value;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

	@Override
	public void init(XmlPullParser parser) {
		setStatus(XppUtils.getElementValueAsLongFromNode(parser, "status"));
		setTimestamp(XppUtils.getElementValueAsLongFromNode(parser, "timestamp"));
		setErrorCode(XppUtils.getElementValueFromNode(parser, "error-code"));
		setMessage(XppUtils.getElementValueFromNode(parser, "message"));
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("error");
		XppUtils.setElementValueToNode(element, "status", getStatus());
		XppUtils.setElementValueToNode(element, "timestamp", getTimestamp());
		XppUtils.setElementValueToNode(element, "error-code", getErrorCode());
		XppUtils.setElementValueToNode(element, "message", getMessage());
		return element;
	}
}
