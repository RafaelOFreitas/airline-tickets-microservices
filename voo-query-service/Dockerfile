FROM adoptopenjdk:11-jre-hotspot
LABEL "Airline Tickets" = "Voo Query Service"
ARG JAR_FILE=/target/voo-query-0.0.1.jar
COPY ${JAR_FILE} voo-query.jar
ENTRYPOINT ["java", "-jar", "voo-query.jar"]
EXPOSE 9095
