<template>
  <div>
    <Student name="Alex" :age="18"></Student>
  </div>
</template>

<script>
  import Student from "@/components/MyStudent";
  export default {
    name: "App",
    components:{
      Student,
    },
  }
</script>

<style scoped>

</style>
