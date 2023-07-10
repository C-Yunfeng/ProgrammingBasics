### 0619-内存

##### 共享内存



##### 私有内存

- 性能测试时尽量避免生成磁盘临时表, 而是只生成内存临时表.

  ![image-20230619183952682](assets/a/image-20230619183952682.png)

- 内存计算

  ![image-20230619184715212](assets/a/image-20230619184715212.png)

  共享内存是固定的, 私有内存可以估算.

##### 内存监控

![image-20230619190605920](assets/a/image-20230619190605920.png)

![image-20230619190633192](assets/a/image-20230619190633192.png)

- IO_CACHE为连接数



##### 内存分配器

```bash
systemctl status mysqld_3306
vi /etc/systemd/system/mysqld_3306.service
# jemalloc
ps -ef | grep mysql
# 查看malloc的路径
lsof -p $pid | grep malloc
```

TXSQL独有的内存展示

```sql
show detail processlist\G
```



![image-20230619191300068](assets/a/image-20230619191300068.png)

内存分配器对比

![image-20230619191502504](assets/a/image-20230619191502504.png)

并发很大时, jemalloc的优势凸显出来了, 表明了在动态地释放内存给系统

![image-20230619191542223](assets/a/image-20230619191542223.png)

##### 业务场景

![image-20230619192014192](assets/a/image-20230619192014192.png)

![image-20230619192108072](assets/a/image-20230619192108072.png)

##### 性能测试

![image-20230619192723242](assets/a/image-20230619192723242.png)

![image-20230619193051340](assets/a/image-20230619193051340.png)

- innodb_buffer_pool_size不建议超过60%

测试环境开放了所有的监控, 智慧库上有:

![image-20230619194014043](assets/a/image-20230619194014043.png)



### 0706-代码走差

##### 常见问题

![image-20230706190016249](assets/a/image-20230706190016249.png)

##### 案例分享

**![image-20230706191129037](assets/a/image-20230706191129037.png)**

- 两周一个迭代, 是否下发取决于业务需求

![image-20230706192136142](assets/a/image-20230706192136142.png)

![image-20230706192221840](assets/a/image-20230706192221840.png)

##### 走查实践

![image-20230706192644988](assets/a/image-20230706192644988.png)

##### webhooks

![image-20230706194003968](assets/a/image-20230706194003968.png)

##### 代码库中新建模板

.gitlab/issue_templates

![image-20230706195615074](assets/a/image-20230706195615074.png)

- 设计0.5~1天,走查半小时

![image-20230706200020444](assets/a/image-20230706200020444.png)

- 需求一般不超过8人天



### 0710-MySQL主从复制

##### 主从原理

![image-20230710183402721](assets/a/image-20230710183402721.png)

![image-20230710183446557](assets/a/image-20230710183446557.png)

##### 常用指标

![image-20230710183555966](assets/a/image-20230710183555966.png)

![image-20230710183704947](assets/a/image-20230710183704947.png)



![image-20230710184222279](assets/a/image-20230710184222279.png)

![image-20230710184238935](assets/a/image-20230710184238935.png)

- seconds_behind_master计算, 这是一个估计值. 比如主给从发了3个binlog, 但因网络原因只传到了1个, 且从执行完了. 这是seconds_behind_master就是0, 但其实还差了2个binlog

![image-20230710184815612](assets/a/image-20230710184815612.png)

- 主从线程常见状态

##### 案例-大事务导致从库IO_thread异常

![image-20230710184942018](assets/a/image-20230710184942018.png)

日志文件过大, 默认为250M, 但实际到了4G

![image-20230710185153060](assets/a/image-20230710185153060.png)

- 解决办法: 拆分
  - 场景如千万数据, 没建索引

##### 案例-SQL_thread夯死

![image-20230710185558108](assets/a/image-20230710185558108.png)

![image-20230710185909784](assets/a/image-20230710185909784.png)

- 二级索引与回放

![image-20230710190335564](assets/a/image-20230710190335564.png)

- 主键与回放

##### 案例-哈希值相等主从复制错误

![image-20230710190751370](assets/a/image-20230710190751370.png)

![image-20230710190925093](assets/a/image-20230710190925093.png)

- CRC32

![image-20230710191242175](assets/a/image-20230710191242175.png)

- 大表DDL方案
  - 建索引, truncate, 加字段等: 使用其他工具
  - 大量insert: 比如2000w, 那就分5*400w插入
    - 用一个insert语句, 写**400w个value**值
- 外键导致主从异常
  - 建议尽量少用外键