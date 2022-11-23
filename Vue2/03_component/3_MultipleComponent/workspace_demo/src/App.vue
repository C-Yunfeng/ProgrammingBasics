<template>
  <div>
    <button @click="getStudentName">Get student name</button>
    <button @click="getCarName">Get cat name</button>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "App",
    methods:{
      getStudentName(){
        // axios.get("http://localhost:8080/test.txt").then(
        axios.get("http://localhost:8080/api/students").then(
            response =>{
              console.log('request succeed',response.data)
            },
            error =>{
              console.log('request failed',error.message)
            }
        )
      },
      getCarName(){
        // axios.get("http://localhost:8080/test.txt").then(
        axios.get("http://localhost:8080/demo/cars").then(
            response =>{
              console.log('request succeed',response.data)
            },
            error =>{
              console.log('request failed',error.message)
            }
        )
      },
    }
  }
</script>

