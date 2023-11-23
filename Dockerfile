## start with a base image
FROM maven:latest
VOLUME /tmp
ARG PROJECT_VERSION=0.0.1
RUN mkdir -p /home/app
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE application
COPY ./ .
ADD target/ticket-booking-api-0.0.1-SNAPSHOT.jar ticket-booking-api-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "ticket-booking-api-0.0.1-SNAPSHOT.jar"]
CMD ["mvn", "spring-boot:run"]