<template>
  <div>
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
