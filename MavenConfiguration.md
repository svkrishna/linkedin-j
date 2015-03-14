# Introduction #

linkedin-j is available through maven as well. However the maven version will not work for android. For android you will have to download it from the Downloads section.
The jar in the maven repository is named linkedin-j-core-xxx.jar and is larger in size than the jar available from the Downloads section, though it has the same features.


# Details #
Include this section in your pom.xml file.

```
<dependency>
  <groupId>com.googlecode.linkedin-j</groupId>
  <artifactId>linkedin-j-core</artifactId>
  <version>1.0.416</version>
  <scope>compile</scope>
</dependency>
```