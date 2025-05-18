# Etapa 1: Construcción del JAR con Maven + OpenJDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar archivos necesarios
COPY pom.xml .
COPY src src

# Construir el proyecto (sin ejecutar tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final solo con el JAR y OpenJDK 21
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
