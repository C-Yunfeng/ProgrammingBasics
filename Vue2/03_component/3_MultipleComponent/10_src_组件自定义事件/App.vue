<template>
	<div class="app">
		<h1>{{msg}}，学生姓名是:{{studentName}}</h1>
		<h1>{{msg}}，学校姓名是:{{schoolName}}</h1>

		<!-- 通过父组件给子组件传递函数类型的props实现：子给父传递数据 -->
		<MySchool ref="MySchool" :getSchoolName="getSchoolName"/>

		<!-- 通过父组件给子组件绑定一个自定义事件实现：子给父传递数据（第一种写法，使用@或v-on） -->
		<!-- <MyStudent @atguigu="getStudentName" @demo="m1"/> -->

		<!-- 通过父组件给子组件绑定一个自定义事件实现：子给父传递数据（第二种写法，使用ref） -->
		<MyStudent ref="MyStudent"/>
    <!--组件绑定原生DMOM事件，把show给到了MyStudent的根元素div-->
		<!--<MyStudent ref="student" @click.native="show"/>-->
	</div>
</template>

<script>
	import MyStudent from './components/MyStudent'
	import MySchool from './components/MySchool'

	export default {
		name:'App',
		components:{MySchool,MyStudent},
		data() {
			return {
				msg:'你好啊！',
				studentName:'',
        schoolName:''
			}
		},
		methods: {
			getSchoolName(name){
				console.log('App收到了学校名：',name)
        this.schoolName = name
			},
			getStudentName(name,...params){
				console.log('App收到了学生名：',name,params)
				this.studentName = name
			},
			m1(){
				console.log('demo事件被触发了！')
			},
			show(){
				alert(123)
			}
		},
		mounted() {
      // 谁触发的atguigu事件，则this指向谁
      // 或者把getStudentName写成箭头函数，则会往外找this到App
      // 此处this本应为MyStudent，但getStudentName为当前组件APP中的methods的函数，所以覆盖调了
			this.$refs.MyStudent.$on('atguigu',this.getStudentName) //绑定自定义事件
      // TODO：可以一个事件绑定两个组件？
			this.$refs.MySchool.$on('atguigu',this.getSchoolName) //绑定自定义事件
			// this.$refs.student.$once('atguigu',this.getStudentName) //绑定自定义事件（一次性）
		},
	}
</script>

<style scoped>
	.app{
		background-color: gray;
		padding: 5px;
	}
</style>
