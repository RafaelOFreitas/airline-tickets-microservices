FROM adoptopenjdk:11-jre-hotspot
LABEL Airline Tickets
ARG JAR_FILE=/target/eureka-server-0.0.1.jar
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
EXPOSE 8761
