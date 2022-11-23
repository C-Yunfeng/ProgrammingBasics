const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 配置方法一
  // devServer:{
  //   proxy:"http://localhost:5000/"
  // }
  devServer:{
    proxy:{
      '/api':{
        target:"http://localhost:5000/", //代理目标的基础路径
        pathRewrite:{'^/api':''}
        // 默认为true
        // ws:true, //用于支持websocket
        // changeOrigin:true //用于控制请求头中的host值
      },
      '/demo':{
        target:"http://localhost:5001/", //代理目标的基础路径
        pathRewrite:{'^/demo':''}
        // 默认为true
        // ws:true, //用于支持websocket
        // changeOrigin:true //用于控制请求头中的host值
      }
    }
  }
})
