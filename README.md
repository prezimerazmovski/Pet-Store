# Pet Store 
## Build with
- [Maven](https://maven.apache.org/) - Dependency Management.
- [SpringBoot](https://spring.io/projects/spring-boot) -Framework to ease the bootstrapping and development of new Spring Applications.
- [JDK](https://www.oracle.com/java/technologies/downloads/)- Java™ Platform, Standard Edition Development Kit.
- [GIT](https://git-scm.com/)- Free and Open-Source distributed version control system.
 ## External Tools Used
  - [Postman](https://www.postman.com/)- API Development Environment (Testing Documentation)
  ## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.example.petstore.PetStoreApplication.java class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml,command run: mvn clean install
- Open IDE
- File -> Import -> Navigate to the folder where you unzipped the zip
- Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right-Click on the file and Run as Java Application
## Database conficuration
- You need to create database with name=Pet Store
- Set following properties in application.properties:
- spring.datasource.url=jdbc:postgresql://localhost:5432/Pet Store
- spring.datasource.username={username}
- spring.datasource.password={password}
- spring.jpa.hibernate.ddl-auto=create-drop
  ## Demo
  After you start the application the server will listen on port 8080
 - CreatePets
  
   HTTP POST localhost:8080/create-pets
 - CreateUsers
  
   HTTP POST localhost:8080/create-users
 - buyPets
  
   HTTP POST localhost:8080/buy
 - GetAllUsers
  
   HTTP GET localhost:8080/list-users
 - GetAllPets
  
   HTTP GET localhost:8080/list-pets
 - Count of SuccessfulyBuyPets and UnsuccessfulyBuyPets
  
   HTTP POST localhost:8080/history-log
   

