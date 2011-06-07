/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum SearchSortOrder implements FieldEnum {
	
	
	/**
	 * Number of connections per person, from largest to smallest.
	 */
	CONNECTIONS("connections", EnumSet.of(Scope.PEOPLE)),
	
    /**
     * Orders the returns by number of ensorsers each of the search returns has.
     */
    RECOMMENDERS("recommenders", EnumSet.of(Scope.PEOPLE)),

    /**
     * Orders the returns based on the ascending degree of separation within a member's network, with first degree connections first.
     */
    DISTANCE("distance", EnumSet.of(Scope.PEOPLE)),
    
    RELATIONSHIP("relationship", EnumSet.of(Scope.COMPANIES)),
    FOLLOWERS("followers", EnumSet.of(Scope.COMPANIES)),
    COMPANY_SIZE("company-size", EnumSet.of(Scope.COMPANIES)),

    /**
     * Orders the returns based on relevance for the keywords provided.
     */
    RELEVANCE("relevance", EnumSet.of(Scope.PEOPLE, Scope.COMPANIES));
    
    public enum Scope {
    	PEOPLE, COMPANIES, JOBS;
    }
    
    /**
     * Field Description.
     */
	private static final Map<String, SearchSortOrder> stringToEnum = new HashMap<String, SearchSortOrder>();

	static { // Initialize map from constant name to enum constant
		for (SearchSortOrder op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}
	
    /** Field description */
    private final String fieldName;
    private final Set<Scope> scopes;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    SearchSortOrder(String name, Set<Scope> scopes) {
        this.fieldName = name;
        this.scopes = scopes;
    }

    /**
     * @return the name of the field
     */
    public String fieldName() {
        return this.fieldName;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

    public boolean hasScope(Scope scope) {
    	return scopes.contains(scope);
    }
    
	/**
	 *
	 * @return Returns SearchSortOrder for string, or null if string is invalid
	 */
	public static SearchSortOrder fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
