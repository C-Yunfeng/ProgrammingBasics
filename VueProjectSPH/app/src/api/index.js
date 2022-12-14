// 统一管理所有API接口
import requests from './request'

// 三级联动的接口
// /api/product/getBaseCategoryList get 无参数
// 发送请求,axios的返回结果为Promise对象
// 1. 箭头函数的简写形式
export const reqCategoryList = () => requests({url: '/product/getBaseCategoryList', method: 'get'})

// export const reqCategoryList = () => {
//     return requests({url:'/product/getBaseCategoryList',method:'get'})
// }
