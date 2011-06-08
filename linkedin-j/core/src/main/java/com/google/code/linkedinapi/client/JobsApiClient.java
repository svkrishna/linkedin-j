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
package com.google.code.linkedinapi.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.JobField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.enumeration.SearchSortOrder;
import com.google.code.linkedinapi.schema.ExperienceLevelCode;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobBookmarks;
import com.google.code.linkedinapi.schema.JobSearch;
import com.google.code.linkedinapi.schema.JobTypeCode;
import com.google.code.linkedinapi.schema.Jobs;
import com.google.code.linkedinapi.schema.RoleCode;

/**
 * The Interface JobsApiClient.
 */
public interface JobsApiClient extends LinkedInAuthenticationClient {
	
	/**
	 * The Interface JobBuilder.
	 */
	public static interface JobBuilder {
		
		public JobBuilder withPartnerJobId(String value);
		public JobBuilder withContractId(Long value);
		public JobBuilder withCustomerJobCode(String value);
		public JobBuilder withCompany(String companyId, String companyName, String description);
		public JobBuilder withTitle(String jobTitle);
		public JobBuilder withDescription(String jobDescription);
		public JobBuilder withCountry(String country);
		public JobBuilder withPostalCode(String postalCode);
		public JobBuilder withLocation(String location);
		public JobBuilder withSkillsAndExperience(String skillsAndExperience);
		public JobBuilder withJobFunctions(String... jobFunctions);
		public JobBuilder withIndustries(String... industries);
		public JobBuilder withType(JobTypeCode jobType);
		public JobBuilder withExperienceLevel(ExperienceLevelCode experienceLevel);
		public JobBuilder withApplicationUrl(String applicationUrl);
		public JobBuilder withPosterEmailAddress(String emailAddress);
		public JobBuilder withPosterRole(RoleCode role);
		public JobBuilder withSalary(String value);
		public JobBuilder withReferralBonus(String value);
		public JobBuilder withTrackingPixelUrl(String value);
		public JobBuilder withRenewal();
		public JobBuilder withDisplayPoster(Boolean display);
		
		/**
		 * Builds the.
		 * 
		 * @return the job
		 */
		public Job build();
	}

	/**
	 * New job builder.
	 * 
	 * @return the job builder
	 */
	public JobBuilder newJobBuilder();
	
	/**
	 * Gets the job by id.
	 * 
	 * @param id the id
	 * 
	 * @return the job by id
	 */
	public Job getJobById(String id);
	
	/**
	 * Gets the job by id.
	 * 
	 * @param id the id
	 * @param jobFields the job fields
	 * 
	 * @return the job by id
	 */
	public Job getJobById(String id, Set<JobField> jobFields);
    
    /**
     * Gets the job bookmarks.
     * 
     * @return the job bookmarks
     */
    public JobBookmarks getJobBookmarks();
    
    /**
     * Gets the job bookmarks.
     * 
     * @param jobFields the job fields
     * 
     * @return the job bookmarks
     */
    public JobBookmarks getJobBookmarks(Set<JobField> jobFields);
    
    /**
     * Bookmark job.
     * 
     * @param jobId the job id
     */
    public void bookmarkJob(String jobId);
    
    /**
     * Unbookmark job.
     * 
     * @param jobId the job id
     */
    public void unbookmarkJob(String jobId);
    
    /**
     * Gets the job suggestions.
     * 
     * @return the job suggestions
     */
    public Jobs getJobSuggestions();
    
    /**
     * Gets the job suggestions.
     * 
     * @param jobFields the job fields
     * 
     * @return the job suggestions
     */
    public Jobs getJobSuggestions(Set<JobField> jobFields);
    
    /**
     * Post job.
     * 
     * @param job the job
     */
    public void postJob(Job job);
    
    /**
     * Update job.
     * 
     * @param partnerJobId the partner job id
     * @param job the job
     */
    public void updateJob(String partnerJobId, Job job);
    
    /**
     * Renew job.
     * 
     * @param partnerJobId the partner job id
     * @param contractId the contract id
     */
    public void renewJob(String partnerJobId, String contractId);
    
    /**
     * Close job.
     * 
     * @param partnerJobId the partner job id
     */
    public void closeJob(String partnerJobId);
	
    /**
     * Search jobs.
     * 
     * @return the jobs
     */
    public Jobs searchJobs();

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param start the start
     * @param count the count
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, int start, int count);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param sortOrder the sort order
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, SearchSortOrder sortOrder);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    // Faceted Search
    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, int start, int count, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the jobs
     */
    public Jobs searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
    
    
    // Facets and Jobs
    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param sortOrder the sort order
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, SearchSortOrder sortOrder);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder);
    

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param facets the facets
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param facets the facets
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count, List<Parameter<FacetType, String>> facets);
    
    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);

    /**
     * Search jobs.
     * 
     * @param searchParameters the search parameters
     * @param jobFields the job fields
     * @param facetFields the facet fields
     * @param start the start
     * @param count the count
     * @param sortOrder the sort order
     * @param facets the facets
     * 
     * @return the job search
     */
    public JobSearch searchJobs(Map<SearchParameter, String> searchParameters, Set<JobField> jobFields, Set<FacetField> facetFields, int start, int count,
                               SearchSortOrder sortOrder, List<Parameter<FacetType, String>> facets);
}
