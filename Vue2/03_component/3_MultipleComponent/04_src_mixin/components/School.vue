<template>
  <div>
    <button @click="showName">name:{{name}}</button>
    <h2>address:{{address}}</h2>
  </div>
</template>

<script>
  // import {mixin,mixin2} from "@/mixin";

  export default {
    name:'School',
    data(){
      console.log(this)
      return {
        name:'UIBE',
        address:'BeiJing',
        // data里的优先级高于mixin.js里的
        x:666
      }
    },
    // mixins:[mixin,mixin2],
    // 钩子函数都保留
    mounted() {
      console.log('hello school')
    }
  }
</script>
