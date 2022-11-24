<template>
  <div class="container">
    <!--<MyCategory title="food" :lst="foods"></MyCategory>-->
    <MyCategory title="wall">
      <!--将标签体写到组件标签中-->
      <!--img在App完成解析之后，再放到MyCategory中的-->
      <img src="https://w.wallhaven.cc/full/g8/wallhaven-g825ll.jpg" alt="">
    </MyCategory>
    <MyCategory title="game">
      <ul>
        <li  v-for="(g,i) in games" :key="i">{{g}}</li>
      </ul>
    </MyCategory>
    <MyCategory title="film">
      <video controls src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"></video>
    </MyCategory>
  </div>

</template>

<script>
  import MyCategory from "@/components/MyCategory";
  export default {
    name: "App",
    components: {MyCategory},
    data(){
      return {
        walls: ['米山舞', 'debug'],
        games: ['红色警戒', '穿越火线', '劲舞团'],
        films: ['《教父》', '《拆弹专家》', '《你好，李焕英》']
      }
    },

  }
</script>

<style scoped>
  .container{
    /*width: 100%;*/
    display: flex;
    /*间距*/
    justify-content: space-around;
    /*justify-content: center;*/
  }
</style>