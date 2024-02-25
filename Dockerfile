FROM maven:3.8.4-jdk-17 AS build
WORKDIR /app
COPY pom.xml
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn -B clean install

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080