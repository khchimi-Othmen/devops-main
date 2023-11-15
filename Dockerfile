# Use the official OpenJDK base image with Java 11
FROM openjdk:11-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY target/DevOps_Project-2.1.jar /app/devops-last-back.jar

# Expose the port that your Spring Boot application listens on (change as needed)
EXPOSE 8082

# Command to run your Spring Boot application
CMD ["java", "-jar", "devops-last-back.jar"]
#FROM openjdk:11
#EXPOSE 8082
#RUN curl -O http://192.168.1.100:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar
#ENTRYPOINT ["java","-jar","/DevOps_Project-2.1.jar"]
