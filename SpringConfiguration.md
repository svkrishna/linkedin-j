# Introduction #

[Spring Framework](http://www.springsource.org/) is a popular framework that is used for configuring and injecting dependencies declaratively. Since most modern enterprise application use it, we will describe a typical configuration for this library.


# Details #
Typically spring beans are instantiated by their public constructors. However the API client class in the library does not provide a public constructor, hence its configuration is slightly different.

## Configuring API Client Factory ##
The first step is to configure the API client factory:
```
<bean id="linkedInApiClientFactory" class="com.google.code.linkedinapi.client.LinkedInApiClientFactory" factory-method="newInstance">
	 <constructor-arg value="api-key"/> 
	 <constructor-arg value="api-secret"/> 
</bean>
```
The default singleton scope is sufficient or the factory as long as you plan to use only one LinkedIn application in your code.

## Configuring API Client ##
You can inject this factory in you code and create api clients programmatically like:
```
final LinkedInApiClient client = factory.createLinkedInApiClient(accessTokenValue, tokenSecretValue);
```
This will be needed if you have a separate client for each user. Alternatively you can also configure your client using spring:
```
<bean id="linkedInApiClient" factory-bean="linkedInApiClientFactory" factory-method="createLinkedInApiClient">
	 <constructor-arg value="token-key"/> 
	 <constructor-arg value="token-secret"/> 
</bean>
```
## Configuring Asynchronous API Client ##
Configuring asynchronous API client is similar to the one described above, except that you can optionally specify a thread pool as well. Here's a typical configuration:
```
<bean id="asyncTaskExecutor" class="java.util.concurrent.Executors" factory-method="newCachedThreadPool"/>

<bean id="linkedInApiClientFactory" class="com.google.code.linkedinapi.client.LinkedInApiClientFactory" factory-method="newInstance">
	 <constructor-arg value="api-key"/> 
	 <constructor-arg value="api-secret"/> 
	 <property name="taskExecutor">
		 <ref local="asyncTaskExecutor"/>
	 </property>
</bean>
<bean id="linkedInApiClient" factory-bean="linkedInApiClientFactory" factory-method="createAsyncLinkedInApiClient">
	 <constructor-arg value="token-key"/> 
	 <constructor-arg value="token-secret"/> 
</bean>
```
## Configuring OAuth Service ##
Configuring OAuth Service also follows a similar pattern:
```
<bean id="linkedInApiOAuthFactory" class="com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory" factory-method="getInstance"/>
<bean id="linkedInOAuthService" factory-bean="linkedInApiOAuthFactory" factory-method="createLinkedInOAuthService">
	 <constructor-arg value="api-key"/> 
	 <constructor-arg value="api-secret"/> 
</bean>
```