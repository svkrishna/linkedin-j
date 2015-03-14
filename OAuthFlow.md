# Introduction #

LinkedIn uses OAuth for authentication. The details of the LinkedIn OAuth is given here. [OAuth Authentication](http://developer.linkedin.com/docs/DOC-1008)


# Details #
A typical OAuth authentication follows these steps:
## Create OAuth Service ##
To create the OAuth Service, you need the api consumer key and secret.
```
final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(consumerKeyValue, consumerSecretValue);
```
## Get Request Token ##
For out of band requests:
```
LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
```
Specifying a callback:
```
LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken(callbackUrl);
```
## Redirect user To Authorize Page ##
You will get the authorisation url by:
```
String authUrl = requestToken.getAuthorizationUrl();
```
In a typical web-based JEE application you will redirect user like: (don't forget to save the request token)
```
session.setAttribute("requestToken", requestToken);
response.sendRedirect(authUrl);
```
## User Authorisation ##
User will authenticate on the LinkedIn website, you cannot control it through the API. However after authentication the control is returned to the callback url if specified:
## Get Access Token ##
Once the control returns to the callback url, you can get the access token like:
```
LinkedInRequestToken requestToken = (LinkedInRequestToken) session.getAttribute("requestToken");
String oauthVerifier = request.getParameter("oauth_verifier");
LinkedInAccessToken accessToken = oauthService.getOAuthAccessToken(requestToken, oauthVerifier);
```
You can save this access token in a repository and use it to call subsequent API methods like:
```
final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
final LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);

Person profile = client.getProfileForCurrentUser();
```