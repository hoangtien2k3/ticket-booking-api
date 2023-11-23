# Rest API to Book movie tickets

## ER Diagram Demo

![image](https://github.com/hoangtien2k3qx1/ticket-booking-api/assets/122768076/1e7b671a-8f6f-4457-84f5-44f62cf03e57)

## Tools and Technologies Used
- [Java]()
- [Spring Boot]()
- [JDK - 17 or later]()
- [Spring MVC]()
- [Hibernate]()
- [Spring Security]()
- [Maven]()
- [Spring Data JPA]()
- [IDE Intellij IDEA]()
- [MYSQL]()
- [Deploy Docker Network]()

## Test:
```java
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.hoangtien2k3:ticket-booking-api >-----------------
[INFO] Building ticket-booking-api 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.1.0:resources (default-resources) @ ticket-booking-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 2 resources
[INFO] 
[INFO] --- compiler:3.8.1:compile (default-compile) @ ticket-booking-api ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.1.0:testResources (default-testResources) @ ticket-booking-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Volumes/DATA/Backend/ticket-booking-api/src/test/resources
[INFO] 
[INFO] --- compiler:3.8.1:testCompile (default-testCompile) @ ticket-booking-api ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:2.22.2:test (default-test) @ ticket-booking-api ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.hoangtien2k3.ticketbookingapi.TicketBookingApiApplicationTests
```


## Build Docker-compose:
```java
[+] Building 0.6s (10/10) FINISHED                                                                                                                     docker:desktop-linux
 => [springboot-app internal] load .dockerignore                                                                                                                       0.0s
 => => transferring context: 2B                                                                                                                                        0.0s
 => [springboot-app internal] load build definition from Dockerfile                                                                                                    0.0s
 => => transferring dockerfile: 410B                                                                                                                                   0.0s
 => [springboot-app internal] load metadata for docker.io/library/maven:latest                                                                                         0.0s
 => [springboot-app 1/5] FROM docker.io/library/maven:latest                                                                                                           0.0s
 => [springboot-app internal] load build context                                                                                                                       0.0s
 => => transferring context: 17.03kB                                                                                                                                   0.0s
 => CACHED [springboot-app 2/5] RUN mkdir -p /home/app                                                                                                                 0.0s
 => CACHED [springboot-app 3/5] WORKDIR /home/app                                                                                                                      0.0s
 => [springboot-app 4/5] COPY ./ .                                                                                                                                     0.1s
 => [springboot-app 5/5] ADD target/ticket-booking-api-0.0.1-SNAPSHOT.jar ticket-booking-api-0.0.1-SNAPSHOT.jar                                                        0.1s
 => [springboot-app] exporting to image                                                                                                                                0.2s
 => => exporting layers                                                                                                                                                0.2s
 => => writing image sha256:281d94c8a8c9e86941481b0cccd8107343da035837ee2cea28155c039b6f041d                                                                           0.0s
 => => naming to docker.io/library/ticket-booking-api:latest                                                                                                           0.0s
[+] Running 2/2
 ✔ Container ticket-booking-api-mysql-1           Started                                                                                                              0.1s 
 ✔ Container ticket-booking-api-springboot-app-1  Started  
```

## Start docker:
<img width="1440" alt="image" src="https://github.com/hoangtien2k3qx1/ticket-booking-api/assets/122768076/e5170684-36ad-447e-a5b9-ccc8a04f5213">










