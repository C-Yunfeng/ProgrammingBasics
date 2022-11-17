<template>
  <!--  组件的结构-->
  <div>
    <p>name:{{name}}</p>
    <p>age:{{age}}</p>
    <button @click="showName">show MyStudent name</button>
  </div>
</template>

<script>
  // 组件交互相关代码（数据/方法等等）
  export default {
    name:'MyStudent',
    data(){
      return {
        name:'Alex',
        age:18
      }
    },
    methods:{
      showName(){
        console.log('###',this)
      }
    }
  }
</script>
