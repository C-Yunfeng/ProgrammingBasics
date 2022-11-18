<template>
  <div>
    <button @click="showName">name:{{name}}</button>
    <h2>address:{{address}}</h2>
  </div>
</template>

<script>
  export default {
    name:'School',
    data(){
      console.log(this)
      return {
        name:'UIBE',
        address:'BeiJing'
      }
    },
    methods:{
      showName(){
        alert(this.name)
      }
    }

  }
</script>
