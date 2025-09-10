# Use Java 17 base image
FROM openjdk:17-jdk-slim

# Copy the Spring Boot JAR into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose app port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","/app.jar"]
