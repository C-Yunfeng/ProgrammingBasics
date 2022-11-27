<template>
  <div class="container">
    <MyCategory title="game">

      <template v-slot:center="{games}" >
        <ul>
          <li  v-for="(g,i) in games" :key="i">{{g}}</li>
        </ul>
      </template>
    </MyCategory>
  </div>

</template>

<script>
  import MyCategory from "@/components/MyCategory";
  export default {
    name: "App",
    components: {MyCategory},
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