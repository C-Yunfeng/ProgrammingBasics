<template>
  <li>
    <label>
      <!--不推荐用v-model，因为props相当于一个常量指针，逻辑上只读，不建议修改。
      且Vue只能检测到地址的变动，无法检测属性值变动（浅层监视）。
      即如果v-model绑定的是简单变量（非对象），则会报错-->
      <!--<input type="checkbox" v-model="todoData.done"/>-->
      <input type="checkbox" :checked="todoData.done" @change="handleCheck(todoData.id)"/>
      <span>{{ todoData.title }}</span>
    </label>
    <button class="btn btn-danger" @click="handleDelete(todoData.id)">删除</button>
  </li>
</template>

<script>
  export default {
    name: "MyItem",
    // 声明接收todoData对象
    props:['todoData'],
    methods:{
      handleCheck(id){
        this.$bus.$emit('checkItem',id)
      },
      handleDelete(id){
        if(confirm('Are you sure?')){
          this.$bus.$emit('checkItem',id)
        }
      }
    }
  }
</script>

<style scoped>
  /*item*/
  li {
    list-style: none;
    height: 36px;
    line-height: 36px;
    padding: 0 5px;
    border-bottom: 1px solid #ddd;
  }
  li label {
    float: left;
    cursor: pointer;
  }
  li label li input {
    vertical-align: middle;
    margin-right: 6px;
    position: relative;
    top: -1px;
  }
  li button {
    float: right;
    display: none;
    margin-top: 3px;
  }
  li:before {
    content: initial;
  }
  li:last-child {
    border-bottom: none;
  }
  li:hover{
    background-color: #dddddd;
  }
  li:hover button{
    display: block;
  }
</style>