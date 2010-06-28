
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numResults",
    "people",
    "facets"
})
@XmlRootElement(name = "people-search")
public class PeopleSearchImpl
    implements Serializable, PeopleSearch
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "num-results", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long numResults;
    @XmlElement(type = PeopleImpl.class)
    protected PeopleImpl people;
    @XmlElement(type = FacetsImpl.class)
    protected FacetsImpl facets;

    public Long getNumResults() {
        return numResults;
    }

    public void setNumResults(Long value) {
        this.numResults = value;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People value) {
        this.people = ((PeopleImpl) value);
    }

    public Facets getFacets() {
        return facets;
    }

    public void setFacets(Facets value) {
        this.facets = ((FacetsImpl) value);
    }

}
