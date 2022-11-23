<template>
  <div id="root">
    <div class="todo-container">
      <div class="todo-wrap">
        <MyHeader @itemCreated="createItem"></MyHeader>
        <MyList
            :todos="todos">
        </MyList>
        <MyFooter
            :todos="todos"
            @checkAllItem="checkAllItem"
            @clearAllItem="clearAllItem">
        </MyFooter>
      </div>
    </div>
  </div>
</template>

<script>
  import MyHeader from "@/components/MyHeader";
  import MyList from "@/components/MyList";
  import MyFooter from "@/components/MyFooter";

  export default {
    name: "App",
    components:{MyFooter,MyList,MyHeader},
    data(){
      return {
        // 方法1：watch实现
        todos:JSON.parse(localStorage.getItem('todosKey')) || []
      }
    },
    methods:{
      createItem(item){
        this.todos.unshift(item)
      },
      updateItem(id,title){
        this.todos.forEach((todo)=>{
          if(todo.id===id) todo.title=title
        })
      },
      checkItem(id){
        this.todos.forEach((x)=>{
          if(x.id===id) x.done=!x.done
        })
      },
      deleteItem(id){
        this.todos=this.todos.filter(todo=>todo.id!==id)
      },
      checkAllItem(done){
        this.todos.forEach((x)=>{
          x.done = done
        })
      },
      clearAllItem(){
        this.todos = this.todos.filter((todo)=>{
          return !todo.done
        })
      }
    },
    // 方法1：watch实现
    watch:{
      todos:{
        deep:true,
        handler(newV){
          localStorage.setItem('todosKey',JSON.stringify(newV))
        }
      }
    },
    mounted(){
      this.$bus.$on('checkItem',this.checkItem)
      this.$bus.$on('deleteItem',this.deleteItem)
      this.$bus.$on('updateItem',this.updateItem)
    },
    beforeDestroy() {
      this.$bus.$off('checkItem',this.checkItem)
      this.$bus.$off('deleteItem',this.deleteItem)
      this.$bus.$off('updateItem',this.updateItem)
    }
  }
</script>

<!--scoped一般不用于App，因为App中的style一般用于全局-->
<style>
  /*base*/
  body {
    background: #fff;
  }

  .btn {
    display: inline-block;
    padding: 4px 12px;
    margin-bottom: 0;
    font-size: 14px;
    line-height: 20px;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
    border-radius: 4px;
  }

  .btn-danger {
    color: #fff;
    background-color: #da4f49;
    border: 1px solid #bd362f;
  }

  .btn-edit {
    color: #fff;
    background-color: skyblue;
    border: 1px solid skyblue;
    margin-right: 5px;
  }

  .btn-danger:hover {
    color: #fff;
    background-color: #bd362f;
  }

  .btn:focus {
    outline: none;
  }

  .todo-container {
    width: 600px;
    margin: 0 auto;
  }
  .todo-container .todo-wrap {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
</style>