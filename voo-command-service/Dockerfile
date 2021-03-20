FROM adoptopenjdk:11-jre-hotspot
LABEL Airline Tickets
ARG JAR_FILE=/target/voo-command-0.0.1.jar
COPY ${JAR_FILE} voo-command.jar
ENTRYPOINT ["java", "-jar", "voo-command.jar"]
EXPOSE 9094
