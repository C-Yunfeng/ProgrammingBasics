// 引入Vue
import Vue from 'vue'
// 引入App
import App from './App.vue'
// 引入插件
import vueResource from 'vue-resource'
// 引入store
import store from './store'

// 关闭生产提示
Vue.config.productionTip = false
Vue.use(vueResource)

// 创建vm
new Vue({
    el:'#app',
    render: h=>h(App),
    store,
    beforeCreate() {
        Vue.prototype.$bus = this
    }
})

// import { createApp } from 'vue'
// import App from './App.vue'
//
// // Vue.config.productionT
// createApp(App).mount('#app')
// // const app = createApp(App)
// // .mount('#app')
