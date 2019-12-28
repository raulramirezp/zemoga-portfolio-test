# zemoga-portfolio-test
Java Portfolio web app

# Requirements

* Apache tomcat 8.5
* JDK and JRE 11
* Mysql 5.6.46
* maven

# Steps for run part1 (JSP web app)

## Option 1

* open zemoga-portfolio-test\part1\zemoga-portfolio\web generate the war file

```batch 
    jar -cvf zemoga-portfolio.war .
```

* Copy the war file on the Tomcat server in the directory 
```
    Apache Software Foundation\Tomcat 8.5\webapps\
```

* run apache server
* Access to _tomcatServerUrl/zemoga-portfolio_

## Option 2 

* Using an IntelliJ IDEA IDE import the project _zemoga-portfolio-test\part1\zemoga-portfolio_ using the configuration _java Enterprise Web application_ with _Tomcat 8.5.50_

* And press *shift*+*F10* to run

# Steps for run part2 (Spring boot application)

### Before running the application you have to have a Mysql Server running and have to create the Schema zemogatest.

### For create the Schema run the next SQL sentence on the Mysql Command Line Client or using [MySQL Workbench](https://www.mysql.com/downloads/)

```
    create database if not exists zemogatest;
```

### And then go to the properties file (application.properties) located in the folder_zemoga-portfolio-test\part2\portfolio\src\main\resources_ and modify the lines with the appropriate data


```
    spring.datasource.url=jdbc:mysql://{DBUrl:Port}/zemogatest?serverTimezone=UTC
    spring.datasource.username={DBUser}
    spring.datasource.password={DBPassword}
```
 * *{DBUrl:Port}* is the db url and the port. Example **localhost:3306**
 * *{DBUser}* is the user. Example **root**
 * *{DBPassword}* is the user password. Example **MyPassword**
## Option 1 

* open _zemoga-portfolio-test\part2\portfolio_

* run the follow commands
```
    mvn clean install

    mvn spring-boot:run
```

## Option 2

*  Using a IntelliJ IDEA IDE import the project  
_zemoga-portfolio-test\part2\portfolio_ 

* Press *shift*+*F10* to run

# Time required to perform the test

## 30 hours
### Considerations: I had never worked with JSP projects