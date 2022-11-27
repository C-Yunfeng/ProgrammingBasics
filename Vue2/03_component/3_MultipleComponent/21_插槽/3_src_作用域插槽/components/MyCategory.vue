<template>
  <div class="category">
    <h3>Category:{{title}}</h3>
    <slot name="center" :games="games">This is default value and will appear when not receiving specific structure</slot>
  </div>
</template>

<script>
  export default {
    name: "MyCategory",
    props:['title'],
    data(){
      return {
        games: ['红色警戒', '穿越火线', '劲舞团'],
      }
    },
  }
</script>

<style scoped>
  .category{
    background-color: skyblue;
    width: 200px;
    height: 300px;
  }
  h3{
    text-align: center;
    background-color: orange;
  }
  video{
    width: 100%;
  }
  img{
    width: 100%;
  }
</style>
