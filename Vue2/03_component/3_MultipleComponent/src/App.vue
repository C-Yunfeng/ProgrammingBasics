<template>
  <div id='app' class="app">
    <h1>hello~</h1>
    <!--方法1：props实现：子传父-->
    <School :getSchoolName="getSchoolName"></School>

    <!--方法2：自定义事件实现：子传父-->
    <!--此处get并没有传给Student，只是绑定事件，-->
    <!--Vue3弃用了$on-->
    <!--<Student v-on:myEvent="getStudentName"></Student>-->
    <!--<Student @myEvent="getStudentName"></Student>-->
    <Student v-on:myEvent="getStudentName"></Student>


    <!--方法3：refs，比较灵活，如等待3s后处理-->
    <!--<Student ref="Student"></Student>-->
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
    methods:{
      // 两个方法都需要配置回调函数
      getSchoolName(name){
        console.log('App get school name:',name)
      },
      getStudentName(name){
        console.log('App get Student name:',name,...args)
      }
    },
    mounted(){
      // 绑定自定义事件
      this.$refs.Student.$on('myEvent',this.getStudentName)
      // this.$refs.Student.$once('myEvent',this.getStudentName)
      // 不能直接取，因为mounted只挂载一次，无法绑定到按钮事件上
      // console.log('Student name is:',this.$refs.Student.name)
      // TODO:Vue3中用mitt实现
      // console.log($emitter,'emitter')
      // $emitter.on('myEvent')
    }
  }
</script>

<!--scoped一般不用于App，因为App中的style一般用于全局-->
<style scoped>
  .app{
    background-color: gray;
  }
</style>
