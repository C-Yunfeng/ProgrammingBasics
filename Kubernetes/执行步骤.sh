yum install -y docker-ce-20.10.7 docker-ce-cli-20.10.7 containerd.io-1.4.6

systemctl enable docker --now

sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://vy9wx1ih.mirror.aliyuncs.com"],
  "exec-opts": ["native.cgroupdriver=systemd"],
  "log-driver": "json-file",
  "log-opts": {
    "max-size": "100m"
  },
  "storage-driver": "overlay2"
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

hostnamectl set-hostname k8s-master
hostnamectl set-hostname k8s-node1
hostnamectl set-hostname k8s-node2

echo "172.31.0.2  cluster-endpoint" >> /etc/hosts

#主节点初始化
kubeadm init \
--apiserver-advertise-address=172.31.0.2 \
--control-plane-endpoint=cluster-endpoint \
--image-repository registry.cn-hangzhou.aliyuncs.com/lfy_k8s_images \
--kubernetes-version v1.20.9 \
--service-cidr=10.96.0.0/16 \
--pod-network-cidr=192.168.0.0/16


Your Kubernetes control-plane has initialized successfully!

To start using your cluster, you need to run the following as a regular user:

  mkdir -p $HOME/.kube
  sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
  sudo chown $(id -u):$(id -g) $HOME/.kube/config

Alternatively, if you are the root user, you can run:

  export KUBECONFIG=/etc/kubernetes/admin.conf

You should now deploy a pod network to the cluster.
Run "kubectl apply -f [podnetwork].yaml" with one of the options listed at:
  https://kubernetes.io/docs/concepts/cluster-administration/addons/

You can now join any number of control-plane nodes by copying certificate authorities
and service account keys on each node and then running the following as root:

  kubeadm join cluster-endpoint:6443 --token 3ztc7a.v23e1d4bdp5gv6ar \
    --discovery-token-ca-cert-hash sha256:882a6eef2623cc4a5bc56bb8f6f6edbe047ae277dd7f59deff22124e698e6d9e \
    --control-plane 

Then you can join any number of worker nodes by running the following on each as root:

kubeadm join cluster-endpoint:6443 --token 3ztc7a.v23e1d4bdp5gv6ar \
    --discovery-token-ca-cert-hash sha256:882a6eef2623cc4a5bc56bb8f6f6edbe047ae277dd7f59deff22124e698e6d9e 

mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config


kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.3.1/aio/deploy/recommended.yaml

mount -t nfs 172.31.0.2:/nfs/data /nfs/data


eyJhbGciOiJSUzI1NiIsImtpZCI6ImZaR1pnSUg2MmhLc3lsOFQ3cmJqMzJGekh5eEdXQ1ZuU0tLNG1mY3Njek0ifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLXhycDJxIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI0YWYzNWYwYS0yMzczLTQyMTYtYTMwZS0zNzUxOWQxMWMxNmIiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZXJuZXRlcy1kYXNoYm9hcmQ6YWRtaW4tdXNlciJ9.fdktl1RKK_SbDS82wxnGO16uD3Xy_lMqpSKMZaclxu2u8jJ4h0dy17Sk4BiGIi2kcrohvN0MRxXgQ6vG03YGRNxajr-keL7tmtDTRReP3orRU0VjAvuOZJ9kMnUeYx-03ORwMu8VwKsW5j_k_WXXorJHgSIPAIBNYCjATn0S25hBekrquXt0CPME_el3CsO55xUloyzX83qKgJ5VosprAs-ds2R5_rf7E8Tv3GfS_NSgHSvLXmcbQSngLBgWXfwSF3pq3jz0J0szjeJjdqBeEZq93oB3nCi6Mo1fth0-HmwVBenZ9Bn5zrSjgk_072-qx6PoWgOakAuUG1TtmpofRQ