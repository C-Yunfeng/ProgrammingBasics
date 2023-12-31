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
   ```

4. 进入容器查看volume挂载效果

   ```bash
   docker exec -it nginx8012 bash
   ls /usr/share/nginx/html
   ```

5. 访问页面, 输入http://localhost:8012/a.html

