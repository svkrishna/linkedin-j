# Introduction #

The linkedin-j library includes a asynchronous operations API that can be used to call [LinkedIn API](http://developer.linkedin.com/index.jspa) methods in an asynchronous fashion. i.e. The client will not need to wait for the API response to proceed.


# Details #

## Creating Asynchronous Client ##
Creating an asynchronous client is very similar to creating a normal client:
```
final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
final AsyncLinkedInApiClient client = factory.createAsyncLinkedInApiClient(accessTokenValue, tokenSecretValue);
```
## Invoking an Asynchronous Operation ##
You can invoke ann asynchrnous operation like:
```
Future<?> future = client.postNetworkUpdate(updateText);
```
You will not have to wait for the response. If you want to block for the response, you can check:
```
future.get();
```
This call will block until the operation is complete.

---

## Invoking Methods That Return a Result ##
To invoke methods that return some value, you will have to do:
```
Future<Connections> future = client.getConnectionsForCurrentUser();
```
This call will not block. Now when you are ready to consume the response:
```
Connections connections = future.get();
```