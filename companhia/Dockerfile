FROM adoptopenjdk:11-jre-hotspot
LABEL Airline Tickets
ARG JAR_FILE=/target/vooDataCompanhia-0.0.1.jar
COPY ${JAR_FILE} vooDataCompanhia.jar
ENTRYPOINT ["java", "-jar", "vooDataCompanhia.jar"]
EXPOSE 9091
