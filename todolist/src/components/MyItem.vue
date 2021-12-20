<template>
  <li>
    <label>
      <input type="checkbox"
             :checked="todo.done"
             @click="check(todo.id)" />
      <span v-show="!todo.ifDisplayInput">{{todo.title}}</span>
      <input v-model="inputText"
             v-show="todo.ifDisplayInput"
             @blur="setNewName"
             ref="inputText" />
    </label>
    <button class="btn btn-danger"
            @click="deleteTodoObj(todo.id)">删除</button>
    <button class="btn btn-safe"
            @click="clickEditBtn">编辑</button>
  </li>
</template>

<script>

export default {
  data () {
    return {
      inputText: this.todo.title,
    }
  },
  name: 'MyItem',
  props: ['todo'],
  methods: {
    check (id) {
      this.$bus.$emit("checkTodo", id)
    },
    deleteTodoObj (id) {
      this.$bus.$emit("deleteTodoObj", id)
    },
    clickEditBtn () {
      this.$set(this.todo, "ifDisplayInput", true)
      this.$nextTick(function () {
        this.$refs.inputText.focus()
      })
    },
    setNewName () {
      this.todo.ifDisplayInput = false
      this.$bus.$emit("editTodoObj", this.todo.id, this.inputText)
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

li:hover {
  background-color: #ddd;
}

li:hover button {
  display: block;
}

.btn-safe {
  margin-right: 5px;
  color: #fff;
  background-color: #105f5f;
  border: 1px solid #104646;
}
</style>