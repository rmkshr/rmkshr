FROM openjdk
ADD target/spring-api-engine.jar spring-api-engine.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "spring-api-engine.jar"]