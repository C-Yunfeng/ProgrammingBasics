// // 引入Vue
// import Vue from 'vue'
// // 引入App
// import App from './App.vue'
// // 关闭生产提示
// Vue.config.productionTip = false
//
// // 创建vm
// new Vue({
//     el:'#app',
//     render: h=>h(App)
// })

import { createApp } from 'vue'
import App from './App.vue'

createApp(App).mount('#app')