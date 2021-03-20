# Manual da API
`funcionario`

## Instruções

### Criar rede docker:

```shell
user@user:~$ docker network create ms-net
```

### Criando imagem Postgresql no Docker:

+ Fazer o pull da imagem do Postgres:

```shell
user@user:~$ docker pull postgres:12-alpine
```

+ Executar Postgres em container:

```shell
user@user:~$ docker run -p 5432:5432 --name container-postgres --network ms-net -e POSTGRES_PASSWORD=root -e POSTGRES_DB=db_funcionario postgres:12-alpine
```

### Build imagem da Aplicação:

+ Na raiz do projeto funcionario, execute:

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
