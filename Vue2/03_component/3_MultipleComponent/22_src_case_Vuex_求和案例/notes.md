### VueX
##### 逻辑图
![](.notes_images/5db59cdc.png)

##### 搭建Vuex环境
- ES6：import命令的执行会提到文件开头
- Vue.use(Vuex)写到./store/index.js里（项目里就是这么写的，如果下边替换成modules模块，就更完美了）


> 弹幕：
> - 做项目时，有时候用actions这个获取用户权限
> - actions中可进行异步请求，业务逻辑处理，
> - 越听越像MVC 视图  控制器 业务逻辑
> - 个人见解这个图结构类似于vuecom：view，actions：controller，mutation：service，state：mapper结构，这样后端同学好理解
