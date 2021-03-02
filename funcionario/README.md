# Manual da API
`funcionario`

## Instruções

## Criando e testando containers Docker

### Criar rede docker:

```shell
user@user:~$ docker network create ms-net
```

### Criando imagem Postgresql no Docker:

```shell
user@user:~$ docker pull postgres:12-alpine
```

```shell
user@user:~$ docker run -p 5432:5432 --name container-postgres --network ms-net -e POSTGRES_PASSWORD=root -e POSTGRES_DB=db_funcionario postgres:12-alpine
```

### Build imagem da Aplicação:

+ Fazer o build da imagem:

+ Na raiz do projeto funcionario, execute:
+ Fazer o build da aplicação:

```shell
user@user:~$ mvn clean install -DskipTests
```

+ Fazer o build da imagem:

```shell
user@user:~$ docker build -t funcionario-service:v1 .
```

+ Executar aplicação em container:

```shell
user@user:~$ docker run -p 9092:9092 --name container-funcionario-service --network ms-net funcionario-service:v1
```
