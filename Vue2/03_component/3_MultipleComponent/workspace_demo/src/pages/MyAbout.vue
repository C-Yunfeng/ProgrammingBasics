<template>
  <h2>This is MyAbout</h2>
</template>

<script>
  export default {
    name: "MyAbout",
    // commit组件路由守卫
    //通过路由规则，进入该组件时被调用
    beforeRouteEnter (to, from, next) {
      console.log('###About--beforeRouteEnter',to,from)
      if(to.meta.isAuth){ //判断是否需要鉴权
        if(localStorage.getItem('name')==='Alex'){
          next()
        }else{
          alert('Only Alex could visit.')
        }
      }else{
        next()
      }
    },
    //通过路由规则，离开该组件时被调用
    beforeRouteLeave (to, from, next) {
      console.log('###About--beforeRouteLeave',to,from)
      next()
    }
  }
</script>

<style scoped>

</style>