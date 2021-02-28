# Criando e testando containers Docker

## Criar rede docker
```
docker network create ms-net
```

## Criando imagem Postgresql no Docker
```
docker pull postgres:12-alpine

docker run -p 5432:5432 --name container-postgres --network ms-net -e POSTGRES_PASSWORD=root -e POSTGRES_DB=db_funcionario postgres:12-alpine

```

## Criando imagem do microserviço de funcionario
```
FROM adoptopenjdk:11-jre-hotspot
LABEL Funcionario Service
ARG JAR_FILE=/target/funcionario-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} funcionario.jar
ENTRYPOINT ["java", "-jar", "funcionario.jar"]
EXPOSE 9092


mvnw clean package

docker build -t funcionario-service:v1 .

docker run -p 9092:9092 --name container-funcionario-service --network ms-net funcionario-service:v1
```
