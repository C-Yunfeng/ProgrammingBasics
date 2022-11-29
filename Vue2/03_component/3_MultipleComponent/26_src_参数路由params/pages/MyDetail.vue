<template>
  <ul>
    <!--<li>id:{{$route.query.id}}</li>-->
    <!--<li>title:{{$route.query.title}}</li>   -->
    <li>id:{{$route.params.id}}</li>
    <li>title:{{$route.params.title}}</li>
  </ul>
</template>

<script>
export default {
  name: "MyDetail",
  mounted() {
    // console.log(this.$route)
  }
}
</script>

<style scoped>

</style>