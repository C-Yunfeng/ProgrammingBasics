- 插槽的定义：让父组件可以向子组件指定位置插入html结构，也是一种组件间通信的方式，适用于：父组件——》子组件 \
> slot大家看看文档都懂了，无非就是在子组件中挖个坑，坑里面放什么东西由父组件决定。

### 作用域插槽
- https://v2.cn.vuejs.org/v2/guide/components-slots.html#作用域插槽
- [Comparison: slot-scope vs. v-slot](https://github.com/vuejs/rfcs/blob/master/active-rfcs/0001-new-slot-syntax.md#comparison-new-vs-old)
  - 2.5之后scope就被弃用了， 2.6用slot-scope
  - vue3中还有具名作用域插槽，就是把2和3合一起去了
- 作用域插槽的特点：子组件复用了，且数据一样，但根据数据生成的结构是由使用者决定的
  ![](.notes_images/cc733e84.png)
- 作用域插槽必须使用template
- [作用域插槽适合的场景是至少包含三级以上的组件层级，是一种优秀的组件化方案！](https://juejin.cn/post/6844903812130422792)


##### 解构插槽
- https://v2.cn.vuejs.org/v2/guide/components-slots.html#解构插槽-Prop
- [解构赋值：Destructing assignment](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment#解构对象)

##### 弹幕：
> - 原理：
>   - 这是控制反转的思想，解耦了好吧，灵活度更高了，一切交给调用者，而不是在代码写死
>   - 如果只是结构灵活，具名插槽完全能胜任，这里的关键是：在拿不到数据的情况下。
> - 用途：
>   - 我悟了：项目后期维护子组件没有的结构就能通过父组件和插槽插入进去从而不破坏子组件原结构和数据方法等等配置项
>   - 这个功能用的贼多！！！！  因为经常用别人封装的通用组件，，烦死了。不能改
>   - 项目里面经常遇到这样的情况,在分页列表插件里就是通过这种方式传值的
>   - 很有用 尤其是写电商项目 分类菜单导航的时候
> - 解构赋值：
>   - 解构赋值--es6的入门语法
>   - {games:games}同名省略




