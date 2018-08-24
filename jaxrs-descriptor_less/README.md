# JAQ Stack - core
This module includes all the primary sources required to build and development of web appications using JAQ Stack. 

# Build and Deployment
System requirements
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Angular CLI - Optional](https://cli.angular.io/)
* [NodeJS](https://nodejs.org/en/download/)
* [Apache Maven 3.x](https://maven.apache.org/download.cgi)

# Folder Strcuture

![jaq-stack-folder-structure](https://user-images.githubusercontent.com/902972/39322677-4277b364-4950-11e8-8de4-7c311a51511e.png)***Image:*** *Folder structure*


# How to Build

* Create a new directory and cd to it
  * `$ mkdir projects`
  * `cd projects`
* Clone git repository  
  * `git clone https://github.com/ksurendra/jaqstack.git` [Note: 'ksurendra' will change for you. Copy from github]
* Jaq-stack directory will be created with sources in it
  * `cd jaq-stack`
* Build the project
  * `mvn clean package`
* If the build goes well, you will see the output as below
  ![jaq-stack-sample-build-screen1](https://user-images.githubusercontent.com/902972/39282460-15835c04-48cf-11e8-8f04-2c4d699ac843.png)***Image:*** *Sample build screen 1*
  
  ![jaq-stack-sample-build-screen2](https://user-images.githubusercontent.com/902972/39282459-156fa466-48cf-11e8-8c3f-ecc852b4d2df.png)***Image:*** *Sample build screen 2*
* The above will generate a `war` file named `` under `/jaq-stack/target/jaq-stack-webapp.war`
* Deploy this `war` to any web application server like Tomcat, Jetty, etc

# How to Deploy/Run

Using Tomcat as an example:
* Open tomcat's admin console like `http://sampleserver.com:8080/manager/html` 
* Choose `Select WAR file to upload` , uplaod the `jaq-stack-webapp.war`
  ![jaq-stack-sample-tomcat-admin](https://user-images.githubusercontent.com/902972/39284635-dfe0e0b6-48d9-11e8-9211-c5650ff5e8a3.png)***Image:*** *Sample Tomcat admin console screen*
* If the deployment is successful, you can see `/jaq-stack-webapp` in the deployed applications.
* Open a new browser and use this url `http://samplesever.com:8080/jaq-stack-webapp/` . You should see `Java Hello World!`
  ![jaq-stack-sample-screen-browser](https://user-images.githubusercontent.com/902972/39284861-0d430d80-48db-11e8-8b96-16719b595e96.png)***Image:*** *Sample jaq-stack-webapp page on browser*

# Test
* Main application `http://sampleserver:8080/jaq-stack-webapp`
  ![jaq-stack-sample-screen-browser](https://user-images.githubusercontent.com/902972/39284861-0d430d80-48db-11e8-8b96-16719b595e96.png)***Image:*** *Sample jaq-stack-webapp page on browser*


* Initializr Theme `http://sampleserver:8080/jaq-stack-webapp/initializr/` 
  ![jaq-stack-sample-screen-webpage-initializr-angular](https://user-images.githubusercontent.com/902972/39497157-a23decd0-4d67-11e8-910e-bd5d9de73991.png)***Image:*** *Sample jaq-stack-webapp page on browser*


* Sample servlet `http://sampleserver.com:8080/jaq-stack-webapp/simple`
  ![jaq-stack-sample-screen-servlet](https://user-images.githubusercontent.com/902972/39284983-aeb1daac-48db-11e8-93c6-c3169d0de848.png)***Image:*** *Sample jaq-stack-webapp page on browser*


# Troubleshooting
* If `mvn package` command fails showing that **ng** fails,then run try this
  * `sudo npm install -g @angular/cli`
  * If installation of the above goes into infinite loop, then
    * `mkdir ~/.npm-global`
    * `npm config set prefix ~/.npm-global`
    * `export PATH=~/.npm-global/bin:$PATH`
    * Back on the command line, update your system variables: `source ~/.profile`






