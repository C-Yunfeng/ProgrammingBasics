<template>
  <div>
    <h1 v-text="msg" ref="title"></h1>
    <button @click="showDOM">click on me to output DOM above</button>
    <School ref="sch"></School>
  </div>
</template>

<script>
  import School from './components/School'
  export default {
    name: "App",
    components:{
      School
    },
    methods:{
      showDOM(){
        console.log(this.$refs.title)
        console.log(this.$refs.sch)
      }
    },
    data(){
      return {
        msg:'hello~'
      }
    }
  }
</script>

<style scoped>

</style>
