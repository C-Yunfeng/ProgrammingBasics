### DEV

- [Oracle迁移到MySQL时要确保事务隔离级别一致](https://time.geekbang.org/column/article/68963)

  MySQL默认是repeatable read; Oracle默认是read committed.

  ```sql
  show variables like 'transaction_isolation';
  ```

  > 当然在可重复读隔离级别下，未提交变更对其他事务也是不可见的.
  >
  > 那二者区别是?



### SIT



### UAT
