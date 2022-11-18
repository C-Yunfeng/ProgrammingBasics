<template>
  <div>
    <h1 v-text="msg"></h1>
    <h2>name:{{name}}</h2>
    <h2>age:{{myAge+1}}</h2>
    <h2>age2:{{age2}}</h2>
    <button @click="updateAge">Try to change age received</button>
  </div>
</template>

<script>
  export default {
    name: "Student",
    data(){
      console.log(this)
      return {
        msg:'Introduction',
        myAge:this.age
      }
    },
    // TODO
    // computed:{
    //   age2:function(){
    //     return this.age++
    //   }
    // },
    // 简单声明接收
    props:['name','age']

    // 接收并限制类型
    // props:{
    //   name:String,
    //   age:Number
    // }

    // 接收，并限制类型/指定默认值/必要性限制
    // props:{
    //   name:{
    //     type:String,
    //     required:true
    //   },
    //   age:{
    //     type:Number,
    //     default:99
    //   }
    // }
  }
</script>
