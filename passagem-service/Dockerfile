FROM adoptopenjdk:11-jre-hotspot
LABEL "Airline Tickets" = "Passagem Service"
ARG JAR_FILE=/target/passagem-0.0.1.jar
COPY ${JAR_FILE} passagem.jar
ENTRYPOINT ["java", "-jar", "passagem.jar"]
EXPOSE 9093
