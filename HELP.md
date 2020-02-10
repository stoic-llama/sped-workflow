# Getting Started With SPED Workflows Application (Tips)
Below is the check list for setting up SPED Workflows in an AWS elastic beanstalk cloud environment.
1. Create AWS Account (You will need a personal credit card to open an account.)
2. Enter into EB Service Console to create a Java web application and mysql instance.  
3. Set up environment variables on AWS to point to MYSQL_HOST, MYSQL_PORT, MYSQL_DB, MYSQL_USERNAME, MYSQL_PASSWORD, PORT.  
4. Set up AWS Security Group to point the Spring Boot web application to the RDS mySQL database.  
5. Temporarily open up RDS mySQL database to 0.0.0.0/0 so that you can connect locally from your mySQL Admin tool to create the tables and load the data.  Then promptly remove the 0.0.0.0/0 entry.
6. Load the URL and validate.

Refer this [article](https://blog.arnoldgalovics.com/deploying-a-simple-spring-boot-with-mysql-app-to-aws-using-elastic-beanstalk/) for details. 


# 
Below are the environment variables to set up in AWS from the application.properties file.
* `server.port=${PORT:8080}`
* `spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/${MYSQL_DB:spedworkflows?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC}`
* `spring.datasource.username=${MYSQL_USERNAME:root}`
* `spring.datasource.password=${MYSQL_PASSWORD:root}`

Toggle between create and validate for data loading and normal runtime mode
* `spring.jpa.hibernate.ddl-auto=create`
* `spring.jpa.hibernate.ddl-auto=validate`

# 
Generate a jar file from the sped-workflow project to upload to the cloud environment for deployment.

1. In terminal, go to the root of the project folder, and type in “mvn package” to generate jar file. The jar file should be stored in the target subdirectory.  
2. To validate if the jar file was generated correctly:
   * Go to the root of the project folder, 
   * Type java -jar target/sped-workflow-0.0.1-SNAPSHOT.jar  
   * The Spring Boot application should have started. 
   * Now go to your local browser and type in localhost:5000.  
   * This should bring you to the login page.

# 
Set up SPEDWorkflows database in MySQL Server in the cloud manually.

Create the following tables manually in MySQL Server by turning on the ddl-auto=create mode.  Do it one time; then change it to ddl-auto=validate normal runtime mode. 
* authorities
* question_responses
* questionstemplate
* userdto
* users
* workflow_comments
* workflowdto
* workflowdto_user

Then load the data required for users. Refer to data.sql for a template (dummy data in data.sql).



***

# Getting Started With Spring Boot Generally

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/htmlsingle/#boot-features-security)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

