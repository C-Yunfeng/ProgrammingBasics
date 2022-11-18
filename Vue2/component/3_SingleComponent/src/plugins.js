export default{
    install(app,x){
        console.log('x is:',x)
        // 输出可以看到此版本的Vue已经没有filter里
        console.log(app)
        // app.filter('mySlice',function(value){
        //     return value.slice(0,2)
        // })
    }
}