<template>
  <ul>
    <!--<li>id:{{$route.query.id}}</li>-->
    <!--<li>title:{{$route.query.title}}</li>   -->
    <li>id:{{id}}</li>
    <li>title:{{title}}</li>
  </ul>
</template>

<script>
export default {
  name: "MyDetail",
  props:['id','title'],
  mounted() {
    // console.log(this.$route)
  }
}
</script>

<style scoped>

</style>