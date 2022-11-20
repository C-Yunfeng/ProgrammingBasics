<template>
  <div class="demo">
    <h2>name:{{name}}</h2>
    <h2>address:{{address}}</h2>
  </div>
</template>

<script>
  export default {
    name: "School",
    data(){
      return {
        name:'UIBE',
        address:'BeiJing'
      }
    }
}
</script>

<style scoped>
  .demo{
    background-color: orange;
  }
</style>