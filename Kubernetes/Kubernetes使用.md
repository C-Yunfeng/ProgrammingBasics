##### 集群搭建

> https://www.yuque.com/leifengyang/oncloud/mbvigg

```bash
#主节点初始化
kubeadm init \
--apiserver-advertise-address=172.31.0.4 \
--control-plane-endpoint=cluster-endpoint \
--image-repository registry.cn-hangzhou.aliyuncs.com/lfy_k8s_images \
--kubernetes-version v1.20.9 \
--service-cidr=10.96.0.0/16 \
--pod-network-cidr=192.168.0.0/16

#所有网络范围不重叠


kubectl get pods -A

#获取访问令牌
kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"
```



##### 命令空间Namespace

```bash
# 创建命名空间
kubectl create ns hello
# 删除命名空间
kubectl delete ns hello
```

```yaml
apiVersion: v1
kind: Namespace
metadata:
  name: hello
```

##### Pod

- 一个Pod是一或多个容器的集合

```bash
# 创建pod
kubectl run mynginx --image=nginx
# 查看事件
kubectl describe pod mynginx
```

> 小飞飞：不指定节点/pod的亲和性和反亲和性的话，都是随检分配到worknode上的

```yaml
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: mynginx
  name: mynginx
#  namespace: default
spec:
  containers:
  - image: nginx
    name: mynginx
```

```bash
# 查看日志
kubectl logs mynginx
kubectl logs -f mynginx

# 每个Pod - k8s都会分配一个ip
kubectl get pod -owide
# 使用Pod的ip+pod里面运行容器的端口
curl 192.168.169.136

kubectl exec -it mynginx -- /bin/bash

# 集群中的任意一个机器以及任意的应用都能通过Pod分配的ip来访问这个Pod
```

```yaml
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: myapp
  name: myapp
  namespace: default
spec:
  containers:
  - image: nginx
    name: nginx
  - image: tomcat:8.5.68
    name: tomcat
```

![image-20240103212831774](assets/Kubernetes使用/image-20240103212831774.png)

若配置了端口冲突: 会报错`Back-off restarting failed container`, 日志nginx2 in myapp-2里有`Address already in use`

```yaml
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: myapp-2
  name: myapp-2
  namespace: default
spec:
  containers:
  - image: nginx
    name: nginx
  - image: nginx
    name: nginx2
```





