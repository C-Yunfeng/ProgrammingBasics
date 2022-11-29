<template>
  <ul>
    <li v-for="m in messageList" :key="m.id">
      <!--参数写法-->
      <!--<router-link :to="`/home/message/detail/666/hello`">{{m.title}}}</router-link>-->
      <!--对象写法-->
      <router-link :to="{
        name:'detail',
        query:{
          id:m.id,
          title:m.title
        }
      }">
        {{m.title}}
      </router-link>
    </li>
    <hr>
    <router-view></router-view>
  </ul>
</template>

<script>
export default {
  name: "MyMessage",
  data(){
    return {
      messageList:[
        {id:'001',title:'message1'},
        {id:'002',title:'message2'}
      ]
    }
  }
}
</script>

<style scoped>

</style>