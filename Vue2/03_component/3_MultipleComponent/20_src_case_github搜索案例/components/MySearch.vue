<template>
  <section class="jumbotron">
    <h3 class="jumbotron-heading">Search Github Users</h3>
    <div>
      <input type="text" placeholder="enter the name you search" v-model="keyWord"/>
      <button @click="searchUsers">Search</button>
    </div>
  </section>
</template>

<script>
  import axios from 'axios'
  export default {
    name: "MySearch",
    data(){
      return {
        keyWord:''
      }
    },
    methods:{
      searchUsers(){
        console.log('Before request...')
        this.$bus.$emit('updateUserList',{isFirst:false,isLoading:true,errMsg:'',users:[]})
        axios.get(`https://api.github.com/search/users?q=${this.keyWord}`).then(
            response =>{
              console.log('Request succeed:')
              this.$bus.$emit('updateUserList',{isLoading:false,errMsg:'',users:response.data.items})
            },
            error =>{
              console.log('Request failed:',error.message)
              this.$bus.$emit('updateUserList',{isLoading:false,errMsg:error.message,users:[]})
            }
        )
      }
    }

  }
</script>

