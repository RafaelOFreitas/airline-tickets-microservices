FROM adoptopenjdk:11-jre-hotspot
LABEL Airline Tickets
ARG JAR_FILE=/target/api-gateway-0.0.1.jar
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
EXPOSE 8765
