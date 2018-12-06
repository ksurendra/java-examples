# Basic REST example with Jersey, JAX-RS, CDI on Tomcat
This module includes all the primary sources required to build and development of a web applications using JAQ Stack with the Basic Authentication feature.

# Build and Deployment
System requirements
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven 3.x](https://maven.apache.org/download.cgi)


# How to Build
* Create a new directory and cd to it
  * `$ mkdir projects`
  * `$ cd projects`
* Clone git repository  
  * `git clone https://github.com/ksurendra/java-jersey-rest-cdi-tomcat-weld.git` [Note: 'ksurendra' will change for you. Copy from github]
* `java-jersey-rest-cdi-tomcat-weld` directory will be created with sources in it
  * `cd java-jersey-rest-cdi-tomcat-weld`
* Build the project
  * `mvn clean package`
* The above will generate a `war` file named `` under `/java-jersey-rest-cdi-tomcat-weld/target/java-jersey-rest-cdi-tomcat-weld.war`

# How to Deploy/Run
Using Tomcat 8.x or 9.x:
* Open tomcat's admin console like `http://sampleserver.com:8080/manager/html` 
* Choose `Select WAR file to upload` , uplaod the `java-jersey-rest-cdi-tomcat-weld.war`
* If the deployment is successful, you can see `/jaq-stack-webapp` in the deployed applications.
* Open a new browser and use this url `http://samplesever.com:8080/java-jersey-rest-cdi-tomcat-weld/` . You should see `Java Hello World!`

# Test
* Main application `http://sampleserver:8080/java-jersey-rest-cdi-tomcat-weld`

## On Postman
* [Get Postman Google Chrome Extension Here](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
* Test endpoint
  * URL `http://sampleserver.com:8080/java-jersey-rest-cdi-tomcat-weld/service/cake/price`
  * Sample input ```{"model":"A", "shape":"round", "color":"black", "flavor":"vanilla"}```
  

![java-jersey-rest-cdi-tomcat-weld-postman-cake-rest-example](https://user-images.githubusercontent.com/902972/49599138-d962f180-f945-11e8-959d-fed2b177283d.png)


# Enabling Contexts and Dependency Injection (CDI) for Tomcat
* Include maven dependencies in `pom.xml`

```xml
<dependency>
       <groupId>javax</groupId>
       <artifactId>javaee-api</artifactId>
       <version>8.0</version>
       <scope>provided</scope>
    </dependency>
    <dependency>
       <groupId>javax</groupId>
       <artifactId>javaee-web-api</artifactId>
       <version>8.0</version>
       <scope>provided</scope>
    </dependency>
    <dependency>
       <groupId>javax.enterprise</groupId>
       <artifactId>cdi-api</artifactId>
       <version>2.0.SP1</version>
       <scope>provided</scope>
    </dependency>
    <dependency>
       <groupId>org.glassfish.jersey.ext.cdi</groupId>
       <artifactId>jersey-cdi1x</artifactId>
       <version>2.26</version>
    </dependency>
    <dependency>
       <groupId>org.jboss.weld.servlet</groupId>
       <artifactId>weld-servlet-shaded</artifactId>
       <version>3.0.5.Final</version>
    </dependency>
```

* Add the below lines to `/WEB-INF/web.xml`
```xml
  <resource-env-ref>
    <resource-env-ref-name>BeanManager</resource-env-ref-name>
    <resource-env-ref-type>javax.enterprise.inject.spi.BeanManager</resource-env-ref-type>
  </resource-env-ref>
```

* Create a new file `beans.xml` under `/WEB-INF` folder, and add the below lines:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd"
       bean-discovery-mode="all">
</beans>
```

* Create a new folder `/project-root/META-INF` and file under it `context.xml` with below content.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Context antiJARLocking="true" path="/com-turreta-cdi-servlet-demo">
  <Resource
    name="BeanManager"
    auth="Container"
    type="javax.enterprise.inject.spi.BeanManager"
    factory="org.jboss.weld.resources.ManagerObjectFactory"/>
</Context>
``` 

* Definition of the service
```java
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CakeService implements Serializable {
    ...
    public Double calculatePrice(Cake cake) {
        ...
        return ...
    }
}
```

* Inject a service/class as:
```java
    import javax.inject.Inject;
    ...
    @Inject
    CakeService cakeService;
    ...
    
    Double price = cakeService.calculatePrice(cake);
```