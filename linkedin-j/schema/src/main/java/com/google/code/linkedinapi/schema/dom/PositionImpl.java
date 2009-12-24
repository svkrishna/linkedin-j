
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    public boolean isIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean value) {
        this.isCurrent = value;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company value) {
        this.company = ((CompanyImpl) value);
    }

	@Override
	public void init(Element element) {
		setId(DomUtils.getElementValueFromNode(element, "id"));
		setTitle(DomUtils.getElementValueFromNode(element, "title"));
		setSummary(DomUtils.getElementValueFromNode(element, "summary"));
		setIsCurrent(Boolean.parseBoolean(DomUtils.getElementValueFromNode(element, "is-current")));
		Element companyElem = (Element) DomUtils.getChildElementByName(element, "company");
		if (companyElem != null) {
			CompanyImpl companyImpl = new CompanyImpl();
			companyImpl.init(companyElem);
			setCompany(companyImpl);
		}
		Element startDateElem = (Element) DomUtils.getChildElementByName(element, "start-date");
		if (startDateElem != null) {
			StartDateImpl startDateImpl = new StartDateImpl();
			startDateImpl.init(startDateElem);
			setStartDate(startDateImpl);
		}
		Element endDateElem = (Element) DomUtils.getChildElementByName(element, "end-date");
		if (endDateElem != null) {
			EndDateImpl endDate = new EndDateImpl();
			endDate.init(endDateElem);
			setEndDate(endDate);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("position");
		DomUtils.setElementValueToNode(element, "id", getId());
		DomUtils.setElementValueToNode(element, "title", getTitle());
		DomUtils.setElementValueToNode(element, "summary", getSummary());
		DomUtils.setElementValueToNode(element, "is-current", String.valueOf(isIsCurrent()));
		
		if (getCompany() != null) {
			element.appendChild(((CompanyImpl) getCompany()).toXml(document));
		}
		if (getStartDate() != null) {
			element.appendChild(((StartDateImpl) getStartDate()).toXml(document));
		}
		if (getEndDate() != null) {
			element.appendChild(((EndDateImpl) getEndDate()).toXml(document));
		}
		return element;
	}
}
