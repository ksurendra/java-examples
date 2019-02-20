# Basic Authentication Example
This module includes all the primary sources required to build and development of a web applications using JAQ Stack with the Basic Authentication feature.

# Build and Deployment
System requirements
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Angular CLI - Optional](https://cli.angular.io/)
* [NodeJS](https://nodejs.org/en/download/)
* [MongoDB](https://www.mongodb.com/)
* [Apache Maven 3.x](https://maven.apache.org/download.cgi)


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
* Choose `Select WAR file to upload` , uplaod the `basicauth.war`
  ![jaq-stack-sample-tomcat-admin](https://user-images.githubusercontent.com/902972/39284635-dfe0e0b6-48d9-11e8-9211-c5650ff5e8a3.png)***Image:*** *Sample Tomcat admin console screen*
* If the deployment is successful, you can see `/jaq-stack-webapp` in the deployed applications.
* Open a new browser and use this url `http://samplesever.com:8080/basicauth/` . You should see `Java Hello World!`
  ![jaq-stack-sample-screen-browser](https://user-images.githubusercontent.com/902972/39284861-0d430d80-48db-11e8-8b96-16719b595e96.png)***Image:*** *Sample jaq-stack-webapp page on browser*

# Test
* Main application `http://sampleserver:8080/basicauth`
  ![jaq-stack-sample-screen-browser](https://user-images.githubusercontent.com/902972/39284861-0d430d80-48db-11e8-8b96-16719b595e96.png)***Image:*** *Sample jaq-stack-webapp page on browser*


# REST Endpoints
* Add a new user - `/basicauth/service/auth/register`
  * Sample URL `http://localhost:8080/basicauth/service/auth/register`
  * JSON input `{"username":"meenu", "password":"test", "firstname":"Meenakshi", "lastname":"Konathala"}`
  * Sample output `User meenu added successfully.` 
* Find Username and Password - `/basicauth/service/auth/login`
  * Sample URL `http://localhost:8080/basicauth/service/auth/login`
  * JSON input `{"username":"meenu", "password":"test"}`
  * Sample output `{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXJlbiJ9.emR1bSwGNds4QV7P9FdrLkhv80rmwj3WPF06ntB83H4"}` 


# MongoDB Setup
### Install & Setup
* Download community edition and configure in your system (Windows or Mac or Linux)
### Commands
* `use jaqstack` to Create and move to "jaqstack" database.
* `db.createCollection("users")` to create the collection "users"
* `db.users.insert( { username: "suren", password: "test", firstname: "Surendra", lastname: "Konathala" } )` sample insert of a record into "users"

# Troubleshooting
* If `mvn package` command fails showing that **ng** fails,then run try this
  * `sudo npm install -g @angular/cli`
  * If installation of the above goes into infinite loop, then
    * `mkdir ~/.npm-global`
    * `npm config set prefix ~/.npm-global`
    * `export PATH=~/.npm-global/bin:$PATH`
    * Back on the command line, update your system variables: `source ~/.profile`






