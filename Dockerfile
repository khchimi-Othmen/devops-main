FROM openjdk:11

WORKDIR /app

ADD maintestdevops.jar /app/maintestdevops.jar

RUN curl -o maintestdevops.jar http://192.168.1.100:8081/service/rest/repository/browse/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar

EXPOSE 8082

CMD ["java", "-jar", "maintestdevops.jar"]
