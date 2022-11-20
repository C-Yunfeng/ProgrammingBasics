<template>
  <div>
    <button @click="showName">name:{{name}}</button>
    <h2>age:{{age}}</h2>
  </div>
</template>

<script>
  // 引入一个混合
  import {mixin,mixin2} from "@/mixin";

  export default {
    name:'Student',
    data(){
      console.log(this)
      return {
        name:'Alex',
        age:18
      }
    },
    mixins:[mixin,mixin2]
  }
</script>
