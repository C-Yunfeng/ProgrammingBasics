<template>
  <div class="container">
    <!--<MyCategory title="food" :lst="foods"></MyCategory>-->
    <MyCategory title="wall">
      <!--将标签体写到组件标签中-->
      <!--img在App完成解析之后，再放到MyCategory中的-->
      <img slot="center" src="https://w.wallhaven.cc/full/g8/wallhaven-g825ll.jpg" alt="">
      <a slot="footer" href="https://twitter.com/yoneyamai">more</a>
    </MyCategory>

    <MyCategory title="game">
      <ul slot="center">
        <li  v-for="(g,i) in games" :key="i">{{g}}</li>
      </ul>
      <div class="foot" slot="footer">
        <a href="https://www.atguigu.com">单机游戏</a>
        <a href="https://www.atguigu.com">网络游戏</a>
      </div>
    </MyCategory>

    <MyCategory title="film">
      <video slot="center" controls src="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"></video>
      <!--template渲染时不生成实际标签，所以可以用于包括多个标签体-->
      <!--仅template标签中可以用v-slot-->
      <template v-slot:footer>
        <div class="foot">
          <a href="http://www.atguigu.com">经典</a>
          <a href="http://www.atguigu.com">热门</a>
          <a href="http://www.atguigu.com">推荐</a>
        </div>
        <h4>欢迎前来观影</h4>
      </template>
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
  .container,.foot{
    /*width: 100%;*/
    display: flex;
    /*间距*/
    justify-content: space-around;
    /*justify-content: center;*/
  }
  h4{
    text-align: center;
  }
</style>