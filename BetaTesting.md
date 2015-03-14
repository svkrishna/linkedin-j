# Introduction #

I have released the 0.1-SNAPSHOT version of the library for download so that it can be tested.


# Details #

I am releasing a beta snapshot version of LinkedIn API java wrapper for beta testing. You can download it from http://code.google.com/p/linkedin-j/ . Please download and try out the library. Try out the examples first and then go through the javadoc (which is a bit sketchy yet) to see which methods are available. If you run into issues please post them on Google code (some known issues are already there).
Most of the methods will require a consumer key, consumer secret, access token and access token secret. However the authentication example works with only consumer key and consumer secret (see OAuthAuthenticationExample to get access token).
The core jar for the library is in the dist directory. The library uses JAXB for xml binding so you should have atleast Java SE 6 (you can probably run it on previous versions with jaxb libraries but I have not tried it). The library currently also has a dependency on signpost oauth library and commons codec though there are plans to remove it. The examples have an additional dependency on commons cli. All the jars (except jaxb) are included in the distribution.
The dev-lib directory contains additional jars which are needed only if you want to build from source.
Since the LinkedIn team have not yet released the schema for their API, the jaxb binding uses a custom generated schema and does not perform validation against it. All the beans have been automatically generated from this schema without any customization. This will be improved upon later if necessary.
You can also checkout a readonly copy of the code from Google code. Unfortunately the build file is not working 100%. So it would be great if you build and run the project in eclipse. This will also be fixed shortly.

If you have any suggestions, please post them on Google code too.
Thanks for your help in using and testing out the library.