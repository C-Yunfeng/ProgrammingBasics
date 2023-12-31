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

