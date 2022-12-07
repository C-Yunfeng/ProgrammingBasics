<template>
  <div>
    <h1>Todo List</h1>
    <form @submit="addTodo">
      <input v-model="newTodoText" placeholder="Add a todo" />
      <button type="submit">Add Todo</button>
    </form>
    <ul>
      <li v-for="(todo, index) in todos" :key="index">
        {{ todo.text }}
        <button @click="removeTodo(index)">Remove</button>
      </li>
    </ul>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  name: 'TodoList',
  setup() {
    // Use a ref to store the new todo text
    const newTodoText = ref('')

    // Use a ref to store the list of todos
    const todos = ref([])

    // A method to add a todo
    function addTodo(e) {
      e.preventDefault()
      if (newTodoText.value) {
        todos.value.push({
          text: newTodoText.value,
        })
        newTodoText.value = ''
      }
    }

    // A method to remove a todo
    function removeTodo(index) {
      todos.value.splice(index, 1)
    }

    // Return the todos and methods to the component
    return {
      newTodoText,
      todos,
      addTodo,
      removeTodo,
    }
  },
}
</script>

<style>
ul {
  list-style: none;
  padding: 0;
}
li {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 8px;
  border-bottom: 1px solid #ccc;
}
</style>
