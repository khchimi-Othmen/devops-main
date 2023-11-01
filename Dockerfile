FROM openjdk:11

RUN curl -o maintestdevops.jar http://${NEXUS_URL}/repository/${REPOSITORY_ID}/${REPOSITORY_ID}/${env.DOCKER_TAG}/maintestdevops-${env.DOCKER_TAG}.jar

COPY maintestdevops.jar /app/maintestdevops.jar

WORKDIR /app

EXPOSE 8082

CMD ["java", "-jar", "maintestdevops.jar"]
