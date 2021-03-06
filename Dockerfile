FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/workbasket-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} WorkBasketApi.jar
ENTRYPOINT ["java","-jar","/WorkBasketApi.jar"]