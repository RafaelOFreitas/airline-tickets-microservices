# Manual da API
`passagem`

## Instruções


### Criando imagem mongo no Docker:

+ Fazer o pull da imagem do Postgres:

```shell
user@user:~$ docker pull mongo
```

+ Executar Postgres em container:

```shell
user@user:~$ docker run -p 27017:27017 --name container-mongo --network ms-net mongo
```

### Build imagem da Aplicação:

+ Na raiz do projeto passagem, execute:

```shell
user@user:~$ mvn clean install -DskipTests
```

+ Fazer o build da imagem:

```shell
user@user:~$ docker build -t passagem-service:v1 .
```

+ Executar aplicação em container:

```shell
user@user:~$ docker run -p 9093:9093 --name container-passagem-service --network ms-net passagem-service:v1
```
