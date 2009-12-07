/**
 * 
 */
package com.google.code.linkedinapi.client.examples;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.People;

/**
 * @author nmukhtar
 *
 */
public class SearchApiExample {

    /**
     * Consumer Key
     */
    private static final String CONSUMER_KEY_OPTION = "consumerKey";
	
    /**
     * Consumer Secret
     */
    private static final String CONSUMER_SECRET_OPTION = "consumerSecret";
    
    /**
     * Access Token
     */
    private static final String ACCESS_TOKEN_OPTION = "token";
	
    /**
     * Access Token Secret
     */
    private static final String ACCESS_TOKEN_SECRET_OPTION = "tokenSecret";

    /**
     * keywords
     */
    private static final String KEYWORDS_OPTION = "keywords";
    
    /**
     * name
     */
    private static final String NAME_OPTION = "name";
    
    /**
     * company
     */
    private static final String COMPANY_OPTION = "company";
    
    /**
     * is current company
     */
    private static final String CURRENT_COMPANY_OPTION = "current_company";
    
    /**
     * title
     */
    private static final String TITLE_OPTION = "title";
    
    /**
     * current-title
     */
    private static final String CURRENT_TITLE_OPTION = "current_title";
    
    /**
     * industry-code
     */
    private static final String INDUSTRY_CODE_OPTION = "industry_code";
    
    /**
     * search-location-type
     */
    private static final String SEARCH_LOCATION_TYPE_OPTION = "search_location_type";
    
    /**
     * country-code
     */
    private static final String COUNTRY_CODE_OPTION = "country_code";
    
    /**
     * postal-code
     */
    private static final String POSTAL_CODE_OPTION = "postal_code";
    
    /**
     * network
     */
    private static final String NETWORK_OPTION = "network";
    
    /**
     * Name of the help command line option.
     */
    private static final String HELP_OPTION = "help";
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}
	
    /**
     * Process command line options and call the service. 
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(CONSUMER_KEY_OPTION) && line.hasOption(CONSUMER_SECRET_OPTION)
        		&& line.hasOption(ACCESS_TOKEN_OPTION) && line.hasOption(ACCESS_TOKEN_SECRET_OPTION)) {
    		final String consumerKeyValue = line.getOptionValue(CONSUMER_KEY_OPTION);
    		final String consumerSecretValue = line.getOptionValue(CONSUMER_SECRET_OPTION);
    		final String accessTokenValue = line.getOptionValue(ACCESS_TOKEN_OPTION);
    		final String tokenSecretValue = line.getOptionValue(ACCESS_TOKEN_SECRET_OPTION);
    		
    		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
    		final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);
    		
    		Map<SearchParameter, String> searchParameters = getSearchParameters(line);
    		
    		if(!searchParameters.isEmpty()) {
    			System.out.println("Searching for users.");
    			People people = client.searchPeople(searchParameters);
    			printResult(people);
    		} else {
    			System.out.println("Searching for users.");
    			People people = client.searchPeople();
    			printResult(people);
    		}
        } else {
            printHelp(options);
        }
    }
	
	/**
     * Build command line options object.
     */
    private static Options buildOptions() {
       
        Options opts = new Options();
        
        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String consumerKeyMsg = "You API Consumer Key.";
        OptionBuilder.withArgName("consumerKey");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(CONSUMER_KEY_OPTION);
        opts.addOption(consumerKey);
        
        String consumerSecretMsg = "You API Consumer Secret.";
        OptionBuilder.withArgName("consumerSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerSecretMsg);
        Option consumerSecret = OptionBuilder.create(CONSUMER_SECRET_OPTION);
        opts.addOption(consumerSecret);
        
        String accessTokenMsg = "You OAuth Access Token.";
        OptionBuilder.withArgName("accessToken");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(accessTokenMsg);
        Option accessToken = OptionBuilder.create(ACCESS_TOKEN_OPTION);
        opts.addOption(accessToken);
        
        String tokenSecretMsg = "You OAuth Access Token Secret.";
        OptionBuilder.withArgName("accessTokenSecret");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(tokenSecretMsg);
        Option accessTokenSecret = OptionBuilder.create(ACCESS_TOKEN_SECRET_OPTION);
        opts.addOption(accessTokenSecret);
        
        OptionBuilder.withArgName("keywords");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("keywords");
        opts.addOption(OptionBuilder.create(KEYWORDS_OPTION));
        
        OptionBuilder.withArgName("name");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("name");
        opts.addOption(OptionBuilder.create(NAME_OPTION));
        
        OptionBuilder.withArgName("company");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("company");
        opts.addOption(OptionBuilder.create(COMPANY_OPTION));
        
        OptionBuilder.withArgName("current-company");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("current-company");
        opts.addOption(OptionBuilder.create(CURRENT_COMPANY_OPTION));
        
        OptionBuilder.withArgName("title");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("title");
        opts.addOption(OptionBuilder.create(TITLE_OPTION));
        
        OptionBuilder.withArgName("current-title");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("current-title");
        opts.addOption(OptionBuilder.create(CURRENT_TITLE_OPTION));
        
        OptionBuilder.withArgName("industry-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("industry-code");
        opts.addOption(OptionBuilder.create(INDUSTRY_CODE_OPTION));
        
        OptionBuilder.withArgName("search-location-type");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("search-location-type");
        opts.addOption(OptionBuilder.create(SEARCH_LOCATION_TYPE_OPTION));
        
        OptionBuilder.withArgName("country-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("country-code");
        opts.addOption(OptionBuilder.create(COUNTRY_CODE_OPTION));
        
        OptionBuilder.withArgName("postal-code");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("postal-code");
        opts.addOption(OptionBuilder.create(POSTAL_CODE_OPTION));
        
        OptionBuilder.withArgName("network");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription("network");
        opts.addOption(OptionBuilder.create(NETWORK_OPTION));
        
        return opts;
    }
    
    /**
     * Print help and usage.
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = SearchApiExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0}, -{1}, -{2} and -{3} options are required. All others are optional.", CONSUMER_KEY_OPTION, CONSUMER_SECRET_OPTION, ACCESS_TOKEN_OPTION, ACCESS_TOKEN_SECRET_OPTION);
        String footer = "\nIf you do not specify any of the other options, all the members of the user's network are returned.";
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
    
    /**
     * Print the result of API call.
     */
    private static void printResult(People people) {
		// TODO Auto-generated method stub
	}
    
    /**
     *
     */
	private static Map<SearchParameter, String> getSearchParameters(CommandLine line) {
		Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
		
		if (line.hasOption(KEYWORDS_OPTION)) {
			searchParameters.put(SearchParameter.fromString(KEYWORDS_OPTION.replaceAll("_", "-")), line.getOptionValue(KEYWORDS_OPTION));
		}
		
		if (line.hasOption(NAME_OPTION)) {
			searchParameters.put(SearchParameter.fromString(NAME_OPTION.replaceAll("_", "-")), line.getOptionValue(NAME_OPTION));
		}
		
		if (line.hasOption(COMPANY_OPTION)) {
			searchParameters.put(SearchParameter.fromString(COMPANY_OPTION.replaceAll("_", "-")), line.getOptionValue(COMPANY_OPTION));
		}
		
		if (line.hasOption(CURRENT_COMPANY_OPTION)) {
			searchParameters.put(SearchParameter.fromString(CURRENT_COMPANY_OPTION.replaceAll("_", "-")), line.getOptionValue(CURRENT_COMPANY_OPTION));
		}
		
		if (line.hasOption(TITLE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(TITLE_OPTION.replaceAll("_", "-")), line.getOptionValue(TITLE_OPTION));
		}
		
		if (line.hasOption(CURRENT_TITLE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(CURRENT_TITLE_OPTION.replaceAll("_", "-")), line.getOptionValue(CURRENT_TITLE_OPTION));
		}
		
		if (line.hasOption(INDUSTRY_CODE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(INDUSTRY_CODE_OPTION.replaceAll("_", "-")), line.getOptionValue(INDUSTRY_CODE_OPTION));
		}
		
		if (line.hasOption(SEARCH_LOCATION_TYPE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(SEARCH_LOCATION_TYPE_OPTION.replaceAll("_", "-")), line.getOptionValue(SEARCH_LOCATION_TYPE_OPTION));
		}
		
		if (line.hasOption(COUNTRY_CODE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(COUNTRY_CODE_OPTION.replaceAll("_", "-")), line.getOptionValue(COUNTRY_CODE_OPTION));
		}
		
		if (line.hasOption(POSTAL_CODE_OPTION)) {
			searchParameters.put(SearchParameter.fromString(POSTAL_CODE_OPTION.replaceAll("_", "-")), line.getOptionValue(POSTAL_CODE_OPTION));
		}
		
		if (line.hasOption(NETWORK_OPTION)) {
			searchParameters.put(SearchParameter.fromString(NETWORK_OPTION.replaceAll("_", "-")), line.getOptionValue(NETWORK_OPTION));
		}
		
		return searchParameters;
	}
}
