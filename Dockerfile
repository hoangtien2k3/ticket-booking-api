FROM maven:latest
VOLUME /tmp
ARG PROJECT_VERSION=0.0.1
RUN mkdir -p /home/app
WORKDIR /home/app
ENV SPRING_PROFILES_ACTIVE application
COPY . .
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/ticket-booking-api-0.0.1-SNAPSHOT.jar"]


