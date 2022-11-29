<template>
  <div class="col-xs-offset-2 col-xs-8">
    <div class="page-header">
      <h2>hello vue router</h2>
    </div>
    <button @click="back">back</button>
    <button @click="forward">forward</button>
  </div>
</template>

<script>
  export default {
    name: "MyBanner",
    methods:{
      back(){
        this.$router.back()
      },
      forward(){
        this.$router.forward()
      }
    }
  }
</script>

<style scoped>

</style>