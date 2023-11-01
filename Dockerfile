FROM openjdk:11

WORKDIR /app

COPY http://192.168.1.100:8081/repository/maven-releases/maintestdevops.jar /app/maintestdevops.jar

EXPOSE 8082

CMD ["java", "-jar", "maintestdevops.jar"]
