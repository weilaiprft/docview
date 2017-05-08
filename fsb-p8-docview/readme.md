Synopsis

This is an application designed for FSB for the purpose of auditing document viewed on their filenet p8 system.  


Code Example

It builds on spring boot and uses spring-jpa-data rest to create HATEOAS endpoints and some custom endpoints for repository operations.
The font end is HTMLs on bootstrap framework and AdminLTE themes

Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain why the project exists.

Installation

Spring boot, run as application, but it needs to be deployed on a jboss server.  So you should just mvn clean install to generate the war file
deploy to your local jboss environment.  make sure you have jdbc datasource setup to connect to the right db, ORACLE

API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

Tests

Describe and show how to run the tests with code examples.

Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

License

A short snippet describing the license (MIT, Apache, etc.)