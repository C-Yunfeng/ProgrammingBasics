import Vue from 'vue'
import App from './App.vue'
// 将三级联动注册为全局组件，因此不需要import
import TypeNav from "@/components/TypeNav";

Vue.component(TypeNav.name, TypeNav)
import router from '@/router'
// 引入swiper
// import "swiper/css/swiper.css"
// 测试API
import {reqCategoryList} from "@/api";

reqCategoryList().then(
    response => {
        console.log('succ')
    },
    error => {
        console.log('fail')
    }
);

new Vue({
    render: h => h(App),
    // 注册路由，KV一致省略V
    router
}).$mount('#app')
