#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM amazoncorretto:21.0.4-alpine3.18
WORKDIR /app
COPY target/order-service-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]