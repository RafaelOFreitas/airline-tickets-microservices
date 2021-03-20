FROM adoptopenjdk:11-jre-hotspot
LABEL "Airline Tickets" = "Companhia Service"
ARG JAR_FILE=/target/companhia-0.0.1.jar
COPY ${JAR_FILE} companhia.jar
ENTRYPOINT ["java", "-jar", "companhia.jar"]
EXPOSE 9091
