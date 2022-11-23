<template>
  <div class="todo-header">
    <input type="text" placeholder="请输入你的任务名称，按回车键确认" v-model="title" @keyup.enter="addItem"/>
  </div>
</template>

<script>
  import {nanoid} from 'nanoid'
  export default {
    name: "MyHeader",
    data(){
      return{
        title:''
      }
    },
    methods:{
      addItem(){
        // 将用户的输入包装成一个TODO对象
        // 有服务器时，ID由数据自动生成。此处为单机，则自己生成
        // TODO:uuid/雪花算法，简化版为nanoid
        // 校验数据
        if (!this.title.trim()) return alert('输入不能为空')
        // 将用户输入包装成todo对象
        const todoObj = {id:nanoid(),title:this.title,done:false}
        // 通知APP组件添加对象
        this.$emit('itemCreated',todoObj)
        // 清空输入
        this.title = ''
      }
    }
  }
  </script>

<style scoped>
  /*header*/
  .todo-header input {
    width: 560px;
    height: 28px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 4px 7px;
  }

  .todo-header input:focus {
    outline: none;
    border-color: rgba(82, 168, 236, 0.8);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6);
  }
</style>