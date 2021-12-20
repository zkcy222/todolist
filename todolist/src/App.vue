<template>

  <div id="root">
    <div class="todo-container">
      <div class="todo-wrap">
        <my-header @addObj="addObj" />
        <my-list :todos="todos" />
        <my-footer :todos="todos"
                   @checkAll="checkAll"
                   @deleteDone="deleteDone" />
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios"
import Qs from "qs"

import MyFooter from './components/MyFooter.vue'
import MyHeader from './components/MyHeader.vue'
import MyList from './components/MyList.vue'
export default {
  name: 'App',
  components: {
    MyHeader, MyFooter, MyList
  },
  data () {
    return {
      todos: JSON.parse(localStorage.getItem("todos")) || [
        { id: 0, title: '吃肯德基', done: false },
        { id: 1, title: '吃麦当劳', done: true },
        { id: 2, title: '吃大东北水饺', done: false },
        { id: 3, title: '吃花雕醉鸡', done: false },
        { id: 4, title: '吃螺蛳粉', done: false },
        { id: 5, title: '吃驴火', done: false },
        { id: 6, title: '这就是你分手的借口', done: false },
        { id: 7, title: '吃如果让你重新来过', done: false },
        { id: 8, title: '哎，华强', done: false },
        { id: 9, title: '焯', done: false },
        { id: 10, title: '我自己吃了它', done: false },
        { id: 11, title: '输的这么彻底', done: false }
      ]
      // todos: [
      //   { id: 0, title: '吃肯德基', done: false },
      //   { id: 1, title: '吃麦当劳', done: true },
      //   { id: 2, title: '吃大东北水饺', done: false },
      //   { id: 3, title: '吃花雕醉鸡', done: false },
      //   { id: 4, title: '吃螺蛳粉', done: false },
      // ]
    }
  },
  methods: {
    addObj (todoObj) {
      this.todos.push(todoObj)
    },
    //切换勾选状态
    checkTodo (id) {
      this.todos.forEach((todo) => {
        if (todo.id === id) {
          todo.done = !todo.done
          axios.get(this.$requestHeader + "/todolist/checkOne?id=" + id).then(
            response => {
              console.log("勾选")
            }
          )
        }
      });
      console.log(id)
    },
    checkAll (e) {
      this.todos.forEach((todo) => {
        if (todo.done !== e) {
          axios.get(this.$requestHeader + "/todolist/checkOne?id=" + todo.id).then(
            response => {
              console.log("勾选")
            }
          )
        }
        todo.done = e
      });
    },
    deleteDone () {
      var i = 0;
      while (i < this.todos.length) {
        if (this.todos[i].done === true) {
          axios.get(this.$requestHeader + "/todolist/deleteOne?id=" + this.todos[i].id).then(
            response => {
              console.log("删除成功")
            }
          )
          this.todos.splice(i, 1)

        } else {
          i++
        }
      }
    },
    deleteTodoObj (id) {
      this.todos = this.todos.filter((todo) => {
        return todo.id !== id
      });
      axios.get(this.$requestHeader + "/todolist/deleteOne?id=" + id).then(
        response => {
          console.log("删除成功")
        }
      )
    },
    editTodoObj (id, title) {
      this.todos.forEach((todo) => {
        if (todo.id === id) {
          todo.title = title
          axios.get(this.$requestHeader + "/todolist/editOne?" + Qs.stringify(todo)).then(
            response => {
              console.log("编辑成功")
            }
          )
        }
      });
    }


  },
  watch: {
    todos: {
      deep: true,
      handler (value) {
        localStorage.setItem("todos", JSON.stringify(value))
      }
    }
  },
  mounted () {
    this.$bus.$on("checkTodo", this.checkTodo)
    this.$bus.$on("deleteTodoObj", this.deleteTodoObj)
    this.$bus.$on("editTodoObj", this.editTodoObj)
    // while (true) {
    // setTimeout(2000)
    axios.get(this.$requestHeader + "/todolist/selectAll").then(
      response => {
        console.log("请求成功", response.data)
        this.todos = response.data
      }
    )
    // }


  },
  beforeDestroy () {
    this.$bus.$off("checkTodo")
    this.$bus.$off("deleteTodoObj")
    this.$bus.$off("editTodoObj")
  },
}
</script>

<style>
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
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2),
    0 1px 2px rgba(0, 0, 0, 0.05);
  border-radius: 4px;
}

.btn-danger {
  color: #fff;
  background-color: #da4f49;
  border: 1px solid #bd362f;
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


