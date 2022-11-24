<template>
  <div class="container">
    <MySearch></MySearch>
    <MyList></MyList>
  </div>

</template>

<script>
  import MySearch from "@/components/MySearch";
  import MyList from "@/components/MyList";
  export default {
    name: "App",
    components: {MySearch, MyList}
  }
</script>

<style scoped>

</style>