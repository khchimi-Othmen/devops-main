# Use the official OpenJDK base image with Java 11
FROM openjdk:11-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY target/DevOps_Project-2.1.jar /app/DevOps_Project-2.1.jar

# Expose the port that your Spring Boot application listens on (change as needed)
EXPOSE 8082

# Command to run your Spring Boot application
CMD ["java", "-jar", "DevOps_Project-2.1.jar"]
