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

    <transition-group
        appear
        name="animate__animated animate_bounce"
        enter-active-class="animate__swing"
        leave-active-class="animate__backOutUp"
    >
      <h1 v-show="!isShow" key="1">Alex</h1>
      <h1 v-show="isShow" key="2">Steve</h1>
    </transition-group>
  </div>
</template>

<script>
  export default {
    name: "TransitionAnimation2",
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
</style>