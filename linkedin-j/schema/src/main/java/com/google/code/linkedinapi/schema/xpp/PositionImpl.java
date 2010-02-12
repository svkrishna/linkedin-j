
package com.google.code.linkedinapi.schema.xpp;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.EndDate;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.StartDate;

public class PositionImpl
    extends BaseSchemaEntity
    implements Position
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4485115686667474338L;
	protected String id;
    protected String title;
    protected String summary;
    protected StartDateImpl startDate;
    protected EndDateImpl endDate;
    protected boolean isCurrent;
    protected CompanyImpl company;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate value) {
        this.startDate = ((StartDateImpl) value);
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate value) {
        this.endDate = ((EndDateImpl) value);
    }

    public Boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Boolean value) {
        this.isCurrent = value;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) {
		setId(XppUtils.getElementValueFromNode(parser, "id"));
		setTitle(XppUtils.getElementValueFromNode(parser, "title"));
		setSummary(XppUtils.getElementValueFromNode(parser, "summary"));
		setIsCurrent(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser, "is-current")));
		Element companyElem = (Element) XppUtils.getChildElementByName(parser, "company");
		if (companyElem != null) {
			CompanyImpl companyImpl = new CompanyImpl();
			companyImpl.init(companyElem);
			setCompany(companyImpl);
		}
		Element startDateElem = (Element) XppUtils.getChildElementByName(parser, "start-date");
		if (startDateElem != null) {
			StartDateImpl startDateImpl = new StartDateImpl();
			startDateImpl.init(startDateElem);
			setStartDate(startDateImpl);
		}
		Element endDateElem = (Element) XppUtils.getChildElementByName(parser, "end-date");
		if (endDateElem != null) {
			EndDateImpl endDate = new EndDateImpl();
			endDate.init(endDateElem);
			setEndDate(endDate);
		}
	}

	@Override
	public String toXml(XmlSerializer serializer) {
		Element element = serializer.createElement("position");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "title", getTitle());
		XppUtils.setElementValueToNode(element, "summary", getSummary());
		XppUtils.setElementValueToNode(element, "is-current", String.valueOf(isIsCurrent()));
		
		if (getCompany() != null) {
			element.appendChild(((CompanyImpl) getCompany()).toXml(serializer));
		}
		if (getStartDate() != null) {
			element.appendChild(((StartDateImpl) getStartDate()).toXml(serializer));
		}
		if (getEndDate() != null) {
			element.appendChild(((EndDateImpl) getEndDate()).toXml(serializer));
		}
		return element;
	}
}
