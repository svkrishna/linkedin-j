
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.StartDate;

public class PositionImpl
    extends BaseSchemaEntity
    implements Position
{

    protected String id;
    protected String title;
    protected String summary;
    protected StartDateImpl startDate;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
