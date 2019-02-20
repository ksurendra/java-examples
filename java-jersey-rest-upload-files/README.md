#  REST Example To Upload A File With Jersey, JAX-RS on Tomcat
This module includes all the primary sources required to build and development of a web applications using REST to uplaod a file.

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
* Choose `Select WAR file to upload` , uplaod the `java-jersey-rest-upload-files.war`
* If the deployment is successful, you can see `/java-jersey-rest-upload-files` in the deployed applications.
* Open a new browser and use this url `http://samplesever.com:8080/java-jersey-rest-upload-files/` . You should see `Java Hello World!`

# Test
* Main application `http://sampleserver:8080/java-jersey-rest-upload-files`

## On Postman
* [Get Postman Google Chrome Extension Here](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
* Test endpoint
  * URL `http://sampleserver.com:8080/java-jersey-rest-upload-files/service/files/imageupload`
  
