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
import plugins from "./plugins";

// Vue.config.productionTip = false
// Vue.use(plugins)
const app = createApp(App)
// .mount('#app')
app.use(plugins,3)
