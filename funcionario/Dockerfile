FROM adoptopenjdk:11-jre-hotspot
LABEL Funcionario Service
ARG JAR_FILE=/target/funcionario-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} funcionario.jar
ENTRYPOINT ["java", "-jar", "funcionario.jar"]
EXPOSE 9092
