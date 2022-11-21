<template>
  <div>
    <!--此处的标签无效，因为没有配置props-->
    <Student name="Alex" :age="19"></Student>
    <School></School>
  </div>
</template>

<script>
  import Student from "@/components/MyStudent";
  import School from "@/components/MySchool";
  export default {
    name: "App",
    components:{
      Student,School
    },
  }
</script>

<style scoped>

</style>
