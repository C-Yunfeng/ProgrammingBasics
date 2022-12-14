// 对axois二次封装
import axios from "axios";
// 引入进度条
import nprogress from 'nprogress'
// 引入进度条样式
import "nprogress/nprogress.css"

// 创建axios实例
const request = axios.create({
    // 设置前缀默认路径
    baseURL: "/api",
    timeout: 5000
})

// 请求拦截器
request.interceptors.request.use((config) => {
    // 进度条开始动
    nprogress.start()
    return config
})

// 响应拦截器
request.interceptors.response.use(
    (res) => {
        // 进度条结束
        nprogress.done()
        // 返回基础数据
        return res.data
    },
    (err) => {
        return Promise.reject(new Error('failed'))
    }
)


// 对外暴露
export default request;