#FROM maven:latest
#VOLUME /tmp
#ARG PROJECT_VERSION=0.0.1
#RUN mkdir -p /home/app
#WORKDIR /home/app
#ENV SPRING_PROFILES_ACTIVE application
#COPY . .
#RUN mvn clean package
#EXPOSE 8888
#ENTRYPOINT ["java", "-jar", "target/ticket-booking-api-0.0.1-SNAPSHOT.jar"]

# Sử dụng một phiên bản cụ thể của Maven
FROM maven:3.8.4-openjdk-8 AS builder

# Tạo thư mục app và thiết lập nó làm thư mục làm việc
RUN mkdir -p /home/app
WORKDIR /home/app

# Sao chép toàn bộ mã nguồn vào thư mục làm việc
COPY . .

# Sử dụng Maven Wrapper để build ứng dụng
RUN chmod +x mvnw
RUN ./mvnw clean package

# Sử dụng hình ảnh Java để chạy ứng dụng
FROM openjdk:8-jre-slim

# Sao chép tập tin JAR đã được build từ builder stage
COPY --from=builder /home/app/target/ticket-booking-api-0.0.1-SNAPSHOT.jar /app.jar

# Mở cổng 8080
EXPOSE 8080

# Chạy ứng dụng khi container được khởi động
CMD ["java", "-jar", "/app.jar"]

