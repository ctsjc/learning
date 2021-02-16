FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kafkaConsumer1-1.0-SNAPSHOT.jar
COPY target/classes/application.properties application.yml
ENTRYPOINT ["java","-jar","/kafkaConsumer1-1.0-SNAPSHOT.jar"]