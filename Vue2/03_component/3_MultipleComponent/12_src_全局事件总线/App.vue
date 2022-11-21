<template>
	<div class="app">
		<h1>{{msg}}</h1>
    <MySchool></MySchool>
    <MyStudent></MyStudent>
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
				msg:'你好啊！'
			}
		}
	}
</script>

<style scoped>
	.app{
		background-color: gray;
		padding: 5px;
	}
</style>
