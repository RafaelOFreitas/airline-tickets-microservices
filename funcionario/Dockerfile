FROM adoptopenjdk:11-jre-hotspot
LABEL Airline Tickets
ARG JAR_FILE=/target/funcionario-0.0.1.jar
COPY ${JAR_FILE} funcionario.jar
ENTRYPOINT ["java", "-jar", "funcionario.jar"]
EXPOSE 9092
