FROM adoptopenjdk:11-jre-hotspot
LABEL eureka server
ARG JAR_FILE=/target/eureka-server-airline-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} eureka-server-airline.jar
ENTRYPOINT ["java", "-jar", "eureka-server-airline.jar"]
EXPOSE 8761
