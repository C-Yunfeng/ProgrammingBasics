<template>
  <div class="student">
    <h2>name:{{name}}</h2>
    <h2>age:{{age}}</h2>
    <!--方法2：不需要配置props并调用，只需要emit即可-->
    <button @click="sendStudentName">Send student name</button>
  </div>
</template>

<script>
  export default {
    name:'Student',
    data(){
      console.log(this)
      return {
        name:'Alex',
        age:18
      }
    },
    methods:{
      sendStudentName(){
        // 绑定Student组件的VC的事件
        this.$emit('myEvent',this.name,111,222)
        // this.$myEmit.$emit('myEvent',this.name,111,222)
      }
    }
  }
</script>

<!--原理是加了一个标签属性-->
<style scoped>
  .student{
    background-color: orange;
  }
</style>
