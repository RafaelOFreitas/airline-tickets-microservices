# Manual da API
`companhia`

## Pré-requisitos:

+ [Maven](https://maven.apache.org/)
+ [Kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
+ [Minikube](https://minikube.sigs.k8s.io/docs/start/)
+ [Virtualbox](https://www.virtualbox.org/wiki/Downloads)

## Instruções:

+ Para testar a aplicação sem o Kubernetes: 
  - Adicionar em variáveis de ambiente os dados do banco de dados conforme especificação do arquivo: 
    `companhia-configmap.yaml`

### Criação do Cluster e Serviços Kubernetes:

+ Iniciando Cluster Kubernetes

```shell
user@user:~$ minikube start --vm-driver=virtualbox
```

### Criação do banco de dados para Companhia:

+ No terminal dentro da pasta infra.
+ Criar recurso de mapas de configuração Postgres:

```shell
user@user:~$ kubectl create -f companhia-db-configmap.yaml
```

+ Volume de armazenamento persistente:

```shell
user@user:~$ kubectl create -f companhia-db-storage.yaml 
```

+ Implantação PostgreSQL:

```shell
user@user:~$ kubectl create -f companhia-db-deployment.yaml
```

+ Serviço PostgreSQL:

```shell
user@user:~$ kubectl create -f companhia-db-service.yaml
```

+ Conecte-se ao PostgreSQL:

```shell
user@user:~$ psql -h localhost -U admin --password -p 5432 companhia
```

### Build imagem da Aplicação:

+ Utilizar o Docker daemon do Minikube invés do local:
  - Isso evitará o push e pull de imagens para testar a aplicação.
  - Agora na definição de pods do kubernetes utilizaremos as imagens locais.

```shell
user@user:~$ eval $(minikube docker-env)
```

+ Na raiz do projeto companhia (build da aplicação), execute:

```shell
user@user:~$ mvn clean install -DskipTests
```

+ Fazer o build da imagem:

```shell
user@user:~$ docker build -t airline/companhia-image .
```

+ Para voltar ao seu Docker daemon local (OPCIONAL):

```shell
user@user:~$ eval $(minikube docker-env -u)
```

### Criação da Companhia:

+ Criar recurso de mapas de configuração Companhia:

```shell
user@user:~$ kubectl create -f companhia-configmap.yaml
```

+ Deployment Companhia:

```shell
user@user:~$ kubectl create -f companhia-deployment.yaml 
```

+ Serviço Companhia:

```shell
user@user:~$ kubectl create -f companhia-service.yaml
```

### Para testar collection Postman da Aplicação:

+ Importar `companhia-service.collection.json` (raiz do projeto companhia) no Postman. 
  
+ É necessário identificar o INTERNAL_IP do cluster (LINUX):

```shell
user@user:~$ kubectl get nodes -o wide
```

+ Adicionar `host` com o `INTERNAL_IP` ou localhost (Windows). 

### Delete Deployments:

```
kubectl delete configmap companhia-configmap
kubectl delete service companhia-service
kubectl delete deployment companhia-deployment
kubectl delete service companhia-db-service
kubectl delete deployment companhia-db-deployment
kubectl delete configmap companhia-db-configmap
kubectl delete persistentvolumeclaim companhia-db-pv-claim
kubectl delete persistentvolume companhia-db-pv-volume
```