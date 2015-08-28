# Spring 4.0 Security Example
_by Lee Vettleson_

## Overview
The purpose of this project is to provide an isolated example of a web application using Spring Security. It specifically utilizes an Active Directory service for authentication and role membership.


## Dependencies

1. [Spring Framework 4.2.0][1]
1. [Spring Security 4.0.2][2]
1. [SLF4j 1.7.3][3]
1. [Gradle 2.6][4]


## Getting Started

To build:

    > gradle build

This should build the .war file to deploy to your application container of choice. ([Tomcat 8][5] works)

Then open a browser to the following:
    http://localhost:8080/SpringSecSample

You will need to log in with your network credentials. As this is not an _https_ connection, please only do this locally. If you deploy to an actual server environment, please change the connection to https and modify the [ldap.properties](./src/main/resources/ldap.properties) to use the secure connection to Active Directory.

### Development environment
I created this using:

* Java 1.8
* [Eclipse Java EE IDE for Web Developers][6], Luna Release (4.4.0)
    * Eclipse Web Tools Platform
    * Gradle IDE Pack 3.6.x+0.17
* [Gradle 2.6][4]

This is backwards compatible to Java 1.6 and is easily converted to build with [Maven][7] as it originally was a Maven 2+ project that I converted to using Gradle.

### Migrating Spring from 3.x to 4.x
Updating from 3 to 4 wasn't too terribly bad but it wasn't a trivial change.

Official Notes are [here][8].

[1]: http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/ "Spring"
[2]: http://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/ "Spring Security"
[3]: http://www.slf4j.org/ "SLF4j"
[4]: https://gradle.org/ "Gradle"
[5]: http://tomcat.apache.org/ "Tomcat"
[6]: http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr2 "Eclipse IDE"
[7]: https://maven.apache.org/ "Maven"
[8]: http://docs.spring.io/spring-security/site/migrate/current/3-to-4/html5/migrate-3-to-4-xml.html "Spring Migration"
