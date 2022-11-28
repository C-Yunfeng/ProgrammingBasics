// 引入Vue
import Vue from 'vue'
// 引入App
import App from './App.vue'
// 引入插件
import VueRouter from 'vue-router'
// 引入router
import router from './router'

// 关闭生产提示
Vue.config.productionTip = false
Vue.use(VueRouter)

// 创建vm
new Vue({
    el:'#app',
    render: h=>h(App),
    router:router
})
