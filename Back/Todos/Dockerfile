FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Todos-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]