<template>
  <div class="category">
    <h3>Category:{{title}}</h3>
    <!--定义一个插槽-->
    <slot name="center">This is default value and will appear when not receiving specific structure</slot>
    <slot name="footer">This is default value and will appear when not receiving specific structure</slot>
    <!--<ul>-->
    <!--  <li  v-for="(x,i) in lst" :key="i">{{x}}</li>-->
    <!--</ul>-->
  </div>
</template>

<script>
  export default {
    name: "MyCategory",
    props:['title']
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