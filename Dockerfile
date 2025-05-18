# Stage 1: Build
FROM maven:3.8.5-openjdk-19 AS build
WORKDIR /app
COPY pom.xml .
COPY src src

RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:19-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
