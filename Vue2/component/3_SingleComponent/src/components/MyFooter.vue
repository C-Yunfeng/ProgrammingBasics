<template>
  <div class="todo-footer" v-show="totalCount">
    <label>
      <!--写法1-->
      <!--<input type="checkbox" :checked="isAll" @change="checkAll"/>-->
      <!--写法2.v-model可以同时实现初始化+后续修改操作-->
      <input type="checkbox" v-model="isAll"/>
    </label>
    <span>
      <span>已完成{{completedCount}}</span> / 全部{{totalCount}}
    </span>
    <button class="btn btn-danger" @click="clearAll">清除已完成任务</button>
  </div>
</template>

<script>
export default {
  name: "MyFooter",
  props:['todos','checkAllItem','clearAllItem'],
  computed:{
    totalCount(){
      return this.todos.length
    },
    completedCount(){
      // 方法一：reduce
      // 调用todos.length次
      // pre为上次调用函数的返回值
      // this.todos.reduce((pre,current)=>{
      //   console.log('@',pre,current)
      //   return pre + (current.done?1:0)
      // },0)
      // return this.todos.reduce((pre,current)=>{return pre + (current.done?1:0)},0)
      // 方法二：filter
      // return this.todos.filter((t)=>{
      //   return t.done === true
      // }).length
      return this.todos.filter(t=>t.done===true).length
    },
    // 写法1.这种方式默认只读：property "isAll" is readonly.
    // isAll(){
    //   // 计算属性可以套娃
    //   return this.completedCount===this.totalCount && this.totalCount!==0
    // }
    // 写法2.计算属性的完整版写法，就不用再写methods了
    isAll:{
      get(){
        return this.completedCount===this.totalCount && this.totalCount > 0
      },
      set(value){
        this.checkAllItem(value)
      }
    }
  },
  methods:{
    // 写法1
    // checkAll(e){
    //   this.checkAllItem(e.target.checked)
    // }
    clearAll(){
      this.clearAllItem()
    }
  }
}
</script>

<style scoped>
  /*footer*/
  .todo-footer {
    height: 40px;
    line-height: 40px;
    padding-left: 6px;
    margin-top: 5px;
  }

  .todo-footer label {
    display: inline-block;
    margin-right: 20px;
    cursor: pointer;
  }

  .todo-footer label input {
    position: relative;
    top: -1px;
    vertical-align: middle;
    margin-right: 5px;
  }

  .todo-footer button {
    float: right;
    margin-top: 5px;
  }
</style>