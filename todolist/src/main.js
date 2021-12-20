import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({


  el: "#app",
  render: h => h(App),
  beforeCreate() {
    Vue.prototype.$bus = this //安装全局事件总线
    Vue.prototype.$requestHeader = "http://39.105.222.250:8800"

    // Vue.prototype.$requestHeader = "http://localhost:8081"
  }
})