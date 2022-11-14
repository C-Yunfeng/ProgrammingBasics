<template>
  <!--  组件的结构-->
  <div class="demo">
    <p>name:{{name}}</p>
    <p>address:{{address}}</p>
    <button @click="showName">show school name</button>
  </div>
</template>

<script>
  // 组件交互相关代码（数据/方法等等）
  export default {
    name:'School',
    data(){
      return {
        name:'University of Business and Economy',
        address:'Alaska'
      }
    },
    methods:{
      showName(){
        console.log('###',this)
      }
    }
  }
</script>

<style>
  /*组件的样式*/
  .demo{
    background-color: orange;
  }
</style>