<template>
  <div>
    <h2>name:{{name}}</h2>
    <h2>address:{{address | mySlice }}</h2>
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
    }
  }
</script>
