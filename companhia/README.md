# Manual da API
`companhia`

## Pré-requisitos

+ [Maven](https://maven.apache.org/)
+ [Kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
+ [Minikube](https://minikube.sigs.k8s.io/docs/start/)
+ [Virtualbox](https://www.virtualbox.org/wiki/Downloads)

## Instruções

### Criação do Cluster e Serviços Kubernetes

+ Iniciando Cluster Kubernetes

```shell
user@user:~$ minikube start --vm-driver=virtualbox
```

### Criação do banco de dados para Companhia

+ No terminal dentro da pasta infra, execute:
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

### Build imagem da aplicação

+ Utilizar o Docker daemon do Minikube invés do local:
  - Isso evitará o push e pull de imagens para testar nossa aplicação.
  - Agora na definição de pods do kubernetes utilizaremos as imagens locais.

```shell
user@user:~$ eval $(minikube docker-env)
```

+ Na raiz do projeto companhia, execute:
+ Fazer o build da aplicação:

```shell
user@user:~$ mvn clean install
```

+ Fazer o build da imagem:

```shell
user@user:~$ docker build -t airline/companhia-image .
```

+ Para voltar ao seu Docker daemon local:

```shell
user@user:~$ eval $(minikube docker-env -u)
```

### Criação da Companhia

+ Criar recurso de mapas de configuração Companhia:

```shell
user@user:~$ kubectl create -f companhia-configmap.yaml
```

+ POD Companhia:

```shell
user@user:~$ kubectl create -f companhia-pod.yaml 
```

+ Serviço Companhia:

```shell
user@user:~$ kubectl create -f companhia-service.yaml
```

### Delete Deployments

```
kubectl delete configmap companhia-configmap
kubectl delete service companhia-service
kubectl delete pod companhia-pod
kubectl delete service companhia-db
kubectl delete deployment companhia-db
kubectl delete configmap companhia-db-configmap
kubectl delete persistentvolumeclaim companhia-db-pv-claim
kubectl delete persistentvolume companhia-db-pv-volume
```

### Para testar collection Postman da Aplicação

+ É necessário identificar o INTERNAL_IP do cluster (LINUX):

```shell
user@user:~$ kubectl get nodes -o wide
```

+ Adicionar na URL do recurso o INTERNAL_IP ou localhost (Windows). 