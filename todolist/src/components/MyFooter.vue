<template>
  <div class="todo-footer">
    <label>
      <input type="checkbox"
             v-model="isAllCheck" />
    </label>
    <span>
      <span>已完成{{doneNum}}</span> / 全部{{todos.length}}
    </span>
    <button class="btn btn-danger"
            @click="deleteDone">清除已完成任务</button>
  </div>
</template>

<script>
export default {
  name: 'MyFooter',
  props: ["todos"],
  computed: {
    doneNum () {
      var n = 0
      this.todos.forEach((todo) => {
        if (todo.done) n++
      })
      return n
    },
    isAllCheck: {
      get () {
        return this.todos.length === this.doneNum && this.todos.length > 0
      },
      set (e) {
        this.isAll = e
        this.$emit("checkAll", e)
      }
    }
  },
  methods: {
    deleteDone () {
      this.$emit("deleteDone")
    }
  },
}
</script>

<style scoped>
/*footer*/
.todo-footer {
  height: 40px;
  line-height: 40px;
  padding-left: 6px;
  margin-top: 5px;
}

.todo-footer label {
  display: inline-block;
  margin-right: 20px;
  cursor: pointer;
}

.todo-footer label input {
  position: relative;
  top: -1px;
  vertical-align: middle;
  margin-right: 5px;
}

.todo-footer button {
  float: right;
  margin-top: 5px;
}
</style>