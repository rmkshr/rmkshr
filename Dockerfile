FROM openjdk:latest
ADD target/spring-api-engine.jar spring-api-engine.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "spring-api-engine.jar"]
