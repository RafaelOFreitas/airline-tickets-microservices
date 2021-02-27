# Manual da API
`companhia`

## Instruções:

### Criação de Serviços para o Cluster Kubernetes

+ Iniciando Cluster Kubernets

```shell
user@user:~$ minikube start --vm-driver=virtualbox
```

### Build da imagem da aplicação

+ Utilizar o Docker daemon do Minikube invés do local:
    - Isso evitará o push e pull de imagens para testar nossa aplicação.
    - Agora na definição de pods do kubernetes utilizaremos as imagens locais.

```shell
user@user:~$ eval $(minikube docker-env)
```

+ Fazer o build da imagem:

```shell
user@user:~$ docker build -t airline/companhia-image .
```

+ Para voltar ao seu Docker daemon local:

```shell
user@user:~$ eval $(minikube docker-env -u)
```

### Build da imagem da aplicação

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

### Criação do banco de dados para Companhia

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

+ Delete Deployments

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