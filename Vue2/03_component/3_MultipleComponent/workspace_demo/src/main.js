// 引入Vue
import Vue from 'vue'
// commit实际不推荐引入整个文件
// import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-chalk/index.css'

// commit自定义引入组件
// import {} from "element-ui";

// 引入App
import App from './App.vue'
// 引入插件
// import VueRouter from 'vue-router'
// 引入router
// import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

// 关闭生产提示
Vue.config.productionTip = false
// Vue.use(ElementUI)
// Vue.component(Button.name,Button)
Vue.use(ElementUI);


// 创建vm
new Vue({
    el:'#app',
    render: h=>h(App)
})
