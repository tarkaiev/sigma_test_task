# sigma_test_task

This is a simple web application with one model (User) with basic CRUD operations.
Application created according to RESTful interface and uses JSON.

App uses N-tier architecture with DB layer, DAO layer, and Service layer<br>

# Technologies used<br>
Java, Spring, Hibernate, MySql, Tomcat, lombok, checkstyle plugin, Travis Ci<br>


# To run this project you need:<br>
1) *Download and install* the [JDK](https://www.oracle.com/java/technologies/javase-downloads.html, "Download JDK") <br>
2) *Download and install* [MySQL Server](https://dev.mysql.com/downloads/)<br>
+ Connection to DB is configured with parameters below. If you want to change it you can do it in db.properties file <br>
  + user: *"root"*<br>
  + password: *"root"*<br>
  + url: jdbc:mysql://localhost:3306/sigma_test?serverTimezone=UTC<br>
+ Create schema sigma_test (You can use script in init_db.sql file in resources)<br>
 + Configure local Tomcat server and deploy application

# Author
[Denys Tarkaiev](https://github.com/tarkaiev "Author")
