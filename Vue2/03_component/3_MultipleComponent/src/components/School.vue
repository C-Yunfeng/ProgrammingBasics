<template>
  <div class="school">
    <h2>name:{{name}}</h2>
    <h2>address:{{address}}</h2>
    <!--方法1：配置props接收函数，并调用-->
    <button @click="sendSchoolName">Send school name</button>
  </div>
</template>

<script>
  export default {
    name:'School',
    data(){
      console.log(this)
      return {
        name:'UIBE',
        address:'BeiJing',
      }
    },
    props:['getSchoolName'],
    methods:{
      sendSchoolName(){
        this.getSchoolName(this.name)
      }
    }
  }
</script>

<style scoped>
  .school{
    background-color: aqua;
  }
</style>
