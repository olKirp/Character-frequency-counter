FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} counter.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/counter.jar"]