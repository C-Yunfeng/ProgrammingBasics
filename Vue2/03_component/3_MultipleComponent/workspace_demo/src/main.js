//引入Vue
import Vue from 'vue'
//引入App
import App from './App.vue'
//关闭Vue的生产提示
Vue.config.productionTip = false

// const demo =  Vue.extend({})
// const d = new demo()
// // 事件总线需要放到Vue.prototype上
// Vue.prototype.x = d

//创建vm
new Vue({
	el:'#app',
	render: h => h(App),
	// VM原型的东西在此时添加
})