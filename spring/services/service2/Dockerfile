FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service2-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/service2-1.0-SNAPSHOT.jar"]