# -------------------------------
# Stage 1: Build the application
# -------------------------------
FROM maven:3.9.6-eclipse-temurin-11 AS build

WORKDIR /app

# Copy pom.xml first (cache dependencies)
COPY pom.xml .

# Pre-fetch dependencies (faster rebuilds)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the JAR
#RUN mvn clean package -DskipTests
RUN mvn spring-boot:build-image "-Dmaven.test.skip=true"


# -------------------------------
# Stage 2: Runtime
# -------------------------------
FROM eclipse-temurin:11-jre-jammy

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]