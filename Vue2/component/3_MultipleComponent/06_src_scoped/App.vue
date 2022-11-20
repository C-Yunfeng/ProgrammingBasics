<template>
  <div>
    <h1 class="title">hello~</h1>
    <School></School>
    <!--此处的标签无效，因为没有配置props-->
    <Student name="Alex" :age="19"></Student>
  </div>
</template>

<script>
  import Student from "@/components/Student";
  import School from "@/components/School";
  export default {
    name: "App",
    components:{
      Student,School
    },
  }
</script>

<!--scoped一般不用于App，因为App中的style一般用于全局-->
<style scoped>
  .title{
    color:red;
  }
</style>
