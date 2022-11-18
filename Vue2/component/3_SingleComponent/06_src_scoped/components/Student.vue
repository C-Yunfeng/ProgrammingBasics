<template>
  <div class="demo">
    <h2>name:{{name}}</h2>
    <h2>age:{{age}}</h2>
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
    }
  }
</script>

<!--原理是加了一个标签属性-->
<style scoped>
  .demo{
    background-color: orange;
  }
</style>
