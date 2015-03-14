# Introduction #
Calling the methods of the API need access token and secret which is obtained by following the OAuth flow described here. [OAuth Flow](OAuthFlow.md)

All the methods in the library can be divided into the following categories.
  * Profile API
  * Connections API
  * Network Updates API
  * Search API
  * Messaging API
The next section gives a brief example of each API. For complete stand-alone examples please checkout the examples source from svn.

---

# API Usage #

## Creating the Client ##
The first step in calling any API method is to create the API client using the api key, api secret, access token, token secret.
```
final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);

```

---

## Profile API Example ##
To fetch the profile of a person by ID.
```
Person profile = client.getProfileById(id);
System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
System.out.println("Headline:" + profile.getHeadline());
System.out.println("Summary:" + profile.getSummary());
System.out.println("Industry:" + profile.getIndustry());
System.out.println("Picture:" + profile.getPictureUrl());
```
To specify a profile type, use this syntax:
```
Person profile = client.getProfileByUrl(url, ProfileType.PUBLIC);
```
To specify field selectors, use this syntax:
```
Person profile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
```

---

## Connections API Example ##
Typical way to get connections of the current user:
```
Connections connections = client.getConnectionsForCurrentUser();
System.out.println("Total connections fetched:" + connections.getTotal());
for (Person person : connections.getPersonList()) {
	System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
}
```
To specify field selectors for connections:
```
Connections connections = client.getConnectionsByUrl(url, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE));
```
You can also specify a starting index and count for paging:
```
Connections connections = client.getConnectionsForCurrentUser(EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.HEADLINE), 1, 50);
```

---

## Network Updates API Example ##
To fetch network updates of the current user:
```
Network network = client.getNetworkUpdates(EnumSet.of(NetworkUpdateType.STATUS_UPDATE));
System.out.println("Total updates fetched:" + network.getUpdates().getTotal());
for (Update update : network.getUpdates().getUpdateList()) {
	System.out.println("-------------------------------");
	System.out.println(update.getUpdateKey() + ":" + update.getUpdateContent().getPerson().getFirstName() + " " + update.getUpdateContent().getPerson().getLastName() + "->" + update.getUpdateContent().getPerson().getCurrentStatus());
	if (update.getUpdateComments() != null) {
		System.out.println("Total comments fetched:" + update.getUpdateComments().getTotal());
		for (UpdateComment comment : update.getUpdateComments().getUpdateCommentList()) {
			System.out.println(comment.getPerson().getFirstName() + " " + comment.getPerson().getLastName() + "->" + comment.getComment());				
		}
	}
}
```
To post network update:
```
client.postNetworkUpdate(updateText);
```

---

## Search API Example ##
To search for people, you will have to specify the serach parameters in a map:
```
Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
searchParameters.put(SearchParameter.KEYWORDS, keywords);
searchParameters.put(SearchParameter.COMPANY, companyName);

People people = client.searchPeople(searchParameters);
System.out.println("Total search result:" + people.getCount());
for (Person person : people.getPersonList()) {
	System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
}

```

---

## Messaging API Example ##
To send a message to specific IDs in the connections list:
```
client.sendMessage(Arrays.asList(id1, id2), subject, message);
```
To send invitation to a person by email:
```
client.sendInviteByEmail(email, firstName, lastName, subject, message);
```
To send invitation to a person retrieved through a search:
```
client.sendInviteToPerson(recepient, subject, message);
```

---
