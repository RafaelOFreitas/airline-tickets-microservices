# Manual da API

`config-server`

## Papel

+ Uma arquitetura de microserviços, possui muitas configurações para gerir ambientes distintos. 
  
+ Por isso a necessidade de centralizar a configuração de todas as aplicações em um só lugar. 
  
+ Esse é o papel deste componente em nossa arquitetura.

## Configuração Centralizada

+ O Aplicativo (o cliente de configuração) precisa das dependências Config Client e Spring Web.

+ Versões a serem utilizadas no projeto:

```xml
<properties>
  <java.version>11</java.version>
  <spring-cloud.version>2020.0.1</spring-cloud.version>
</properties> 
```

+ Adicionar dependência do Spring Cloud Config:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

+ Adicionar Dependency Management:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>${spring-cloud.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

+ Adicionar dependência para encontrar o servidor de configurações:

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

`OBS:` Utilize este para buscar as configurações do servidor e ainda sim, manter as configurações
globais da aplicação em `application.yml`.

## Lendo a configuração do Config Server utilizando o Config Client

+ Crie um arquivo `bootstrap.yml` em `resources`.

+ As propriedades para configurar o Config Client podem ser definidas da maneira usual para um
  aplicativo Spring Boot.

+ Especifique o `spring.application.name` como do cliente a-bootiful-cliente.

+ Recurso por profile-properties `spring.profiles.active`.

+ Localização do Config Server `spring.cloud.config.uri`.

+ Exemplo:

```yml
  spring:
    application:
      name: '<name-your-application>'
    profiles:
      active: default
    cloud:
      config:
        uri: http://localhost:8888
```

## Adicionando configurações da sua aplicação:

+ Todas as configurações padrões da sua aplicação devem ser adicionadas dentro de uma pasta única no 
  `config-repo`. 
  
+ O arquivo deve possuir o mesmo nome da aplicação configurada no `bootstrap.yml`.
  
+ [Link do repositório de configuração](`https://github.com/RafaelOFreitas/airline-tickets-microservices/tree/main/config-repo`)

+ Adicionar `search-paths` no `application.yml` do Config Server:

```yml
  spring:
    cloud:
      config:
        server:
          git:
            search-paths:
              - config-repo/<your-resource.yml>
```