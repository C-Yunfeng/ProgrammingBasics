##### 数据卷配置

1. 在任意目录(记为mydir),创建html/a.html,内容随意

2. 进入mydir, 创建容器

   ```bash
   # 将本机文件夹/Users/chenyunfeng/Github_Pj/ProgrammingBasics/Docker/resources/html挂载到容器里的/usr/share/nginx/html目录
   docker run -d --name nginx8012 -p 8012:80 -v /Users/chenyunfeng/Github_Pj/ProgrammingBasics/Docker/resources/html:/usr/share/nginx/html nginx
   ```

3. 查看volume情况

   ```bash
   docker volume ls
   docker volume inspect html
   # 此处遇到一个问题是inspect显示mount_point是/var/lib/docker/volumes/html/_data,而我本机没有这个目录.不过通过docker inspect nginx8012中Mounts参数是正确的
   # 后来搜索发现是docker for macos的问题, 如果要查看, 可以执行以下命令进入docker的虚拟机中
   docker run -it --privileged --pid=host debian nsenter -t 1 -m -u -n -i sh
   ls /var/lib/docker
   # 如果想退出,exit即可
   ```

4. 进入容器查看volume挂载效果

   ```bash
   docker exec -it nginx8012 bash
   ls /usr/share/nginx/html
   ```

5. 访问页面, 输入http://localhost:8012/a.html

##### MySQL数据及配置目录挂载

> 注意,本地目录必须以“/”或“./”开头, 否则会识别为数据卷名称

```bash
docker run --hostname=751ed16e6572 env=MYSQL_ROOT_PASSWORD=123456789 --volume=/Users/chenyunfeng/Projects/docker_data/mysql-master/conf/my.cnf:/etc/mysql/my.cnf --volume=/var/lib/mysql -p 3307:3306 --restart=no --runtime=runc -d mysql:8.0.29
```



##### 自定义镜像

> 所需文件见`./Dockerfile_example/jar_demo/Dockerfile`

构建jar镜像

```bash
pwd
### /Users/chenyunfeng/Github_Pj/ProgrammingBasics/Docker/Dockerfile_example/jar_demo
# 构建镜像
docker build -t docker-jar-demo .
# 启动容器
docker run -d --name djd -p 8080:8080 docker-jar-demo
# 查看日志
docker logs -t djd
# 访问http://localhost:8080/hello/count
```



##### 网络访问

```bash
# 创建网桥(inspect命令的Networks参数中有结果)
docker network create heima
# 将已有容器加入到网段heima中
docker network connect heima djd
docker network connect heima nginx8012
# 进入容器djd
docker exec -it djd bash
# 测试通过容器名访问网络
ping nginx8012
```

##### 部署war项目

> 所需文件见目录`./Dockerfile_example/JSP_demo`

```bash
docker build -t jsp_image8581 .
docker run -d -p 8083:8080 --name jsp_cont8581 jsp_image8581
# 访问http://localhost:8083/JSP-1.0-SNAPSHOT/index.jsp
# 注意因为war包没改名,所以访问时上下文路径要写JSP-1.0-SNAPSHOT,即容器中/usr/local/tomcat/webapps里的目录
```

