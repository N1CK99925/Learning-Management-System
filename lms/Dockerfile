# Multi-stage build for Spring Boot application

# Stage 1: Build stage
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

# Set working directory
WORKDIR /app

# Copy Maven configuration files
COPY pom.xml .
COPY src ./src

# Build the application (skip tests for faster builds, remove -DskipTests to run tests)
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Create non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring

# Copy the built artifact from build stage
COPY --from=build /app/target/*.jar app.jar

# Optional: Copy additional config files if needed
# COPY application-prod.properties /app/config/application-prod.properties

# Change ownership to non-root user
RUN chown spring:spring app.jar

# Switch to non-root user
USER spring:spring

# Expose the default Spring Boot port
EXPOSE 8080

# Set JVM options (adjust as needed)
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Health check (adjust the endpoint as needed)
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]