### 基本命令

```bash
# 启动
nginx
# 重新加载配置文件
nginx -s reload
# 停止nginx(或者查到PID并kill)
nginx -s stop
```





### 反向代理

##### 启动两个TOMCAT服务

1. 启动已有的tomcat, 如/usr/local/apache-tomcat-10.1.17

2. 将已有的tomcat复制一份到任意目录,如/usr/local/tomcat8081/apache-tomcat-10.1.17,

3. 修改conf/server.xml中的端口,把SHUTDOWN的端口改为8015(默认8005), 把访问端口改为8081(默认为8080)

4. 因为zshrc中已经配置了CATALIMA_HOME, 所以无论在哪个tomcat的目录中启动都是启动8080的, 所以需要为8081的tomcat单独配置环境变量:

   修改~/.zshrc, 添加一行:

   ```bash
   export TOMCAT_HOME1=/usr/local/tomcat8081/apache-tomcat-10.1.17
   ```

   执行source ~/.zshrc生效

   修改/usr/local/tomcat8081/apache-tomcat-10.1.17/bin/catalina.sh, 添加一行

   ```bash
   export CATALINA_HOME=$TOMCAT_HOME1
   ```

   此时在tomcat8081中启动, 就是使用8081端口的服务了.



##### mac添加端口访问

修改后的结果见`./config_example/pfctl/pf.conf`

使用pfctl修改

```bash
# 备份
sudo cp /etc/pfctl.conf /etc/pfctl.conf.bak
# 修改
sudo vi /etc/pfctl.conf
##### 在/rdr-anchor "com.apple/*"的下一行添加如下内容

rdr on lo0 inet proto tcp from any to any port 80 -> 127.0.0.1 port 80
rdr on lo0 inet proto tcp from any to any port 8081 -> 127.0.0.1 port 8081
rdr on lo0 inet proto tcp from any to any port 9001 -> 127.0.0.1 port 9001

# 关闭
sudo pfctl -d
# 加载配置文件
sudo pfctl -f pf.conf
# 启动
sudo pfctl -e
```



### 负载均衡

修改后的结果见`./config_example/nginx/nginx.conf`

四种分配策略

- 轮循
-  weight
- hash
- fair



### 高可用

##### 配置主备nginx

1. 开放8011端口,用于nginx8011

   ```bash
   
   fs
   
   ```

2. 配置nginx8011
3. 启动nginx8011

##### 配置keepalived

##### 配置VIP
