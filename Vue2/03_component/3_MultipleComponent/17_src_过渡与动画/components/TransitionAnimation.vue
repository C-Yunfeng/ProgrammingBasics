<template>
  <div>
    <button @click="isShow=!isShow">显示/隐藏</button>
    <!--transition是虚拟标签，渲染后不显示-->
    <!--<transition name="hello" appear>-->
    <!--  <h1 v-show="isShow">hello world</h1>-->
    <!--</transition>-->

    <!--<transition name="hello" appear>-->
    <!--  <h1 v-show="isShow">ori and forest</h1>-->
    <!--</transition>-->

    <transition-group name="hello" appear>
      <h1 v-show="!isShow" key="1">minecraft</h1>
      <h1 v-show="isShow" key="2">minecraft</h1>
    </transition-group>
  </div>
</template>

<script>
  export default {
    name: "TransitionAnimation",
    data(){
      return {
        isShow:true
      }
    }
  }
</script>

<style scoped>
  h1{
    background-color: orange;
  }
  .hello-enter-active{
    animation: ani1 1s;
  }
  .hello-leave-active{
    animation: ani1 1s reverse;
  }

  @keyframes ani1 {
    from{
      transform: translateX(-100%);
    }
    to{
      transform: translateX(0px);
    }
  }
</style>