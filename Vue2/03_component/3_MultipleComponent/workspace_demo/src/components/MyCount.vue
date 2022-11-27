<template>
  <div>
    <h3>{{$store.state.sum}}</h3>
    <select v-model.number="n">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
    </select>
    <button @click="increment">increment</button>
    <button @click="decrement">decrement</button>
    <button @click="incrementOdd">incrementOdd</button>
  </div>
</template>

<script>
  export default {
    name: "MyCount",
    props:['title'],
    data(){
      return {
        n:1,
      }
    },
    methods:{
      // 如果没有业务逻辑，可以越过actions直接调用commit，而非dispatch
      increment(){
        // this.$store.dispatch('plus',this.n)
        this.$store.commit('PLUS',this.n)
      },
      decrement(){
        // this.$store.dispatch('minus',this.n)
        this.$store.commit('MINUS',this.n)
      },
      incrementOdd(){
        this.$store.dispatch('plusOdd',this.n)
      }
    }
  }
</script>

<style scoped>
  button{
    margin-left: 5px;
  }
</style>

