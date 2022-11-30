const express = require('express')
const history = require('connect-history-api-fallback')

const app = express()
// 插件
app.use(history())
app.use(express.static(__dirname+'/static'))

app.get('/person',(req,res)=>{
    res.send({
        name:'alex',
        age:18
    })
})
app.listen(5005,(err)=>{
    if(!err) console.log('The server started successfully.')
})