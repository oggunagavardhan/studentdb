FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies (cached)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy project source
COPY src ./src

# Build jar file
RUN mvn clean package -DskipTests

# ===== STAGE 2: RUN THE APPLICATION =====
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from stage 1
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]