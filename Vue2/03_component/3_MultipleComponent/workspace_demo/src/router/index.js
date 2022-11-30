import VueRouter from 'vue-router'
import MyAbout from '../pages/MyAbout'
import MyHome from '../pages/MyHome'
import MyMessage from "../pages/MyMessage";
import MyNews from "../pages/MyNews";
import MyDetail from "../pages/MyDetail";

const router = new VueRouter({
    routes:[
        {
            name:'guanyu',
            path:'/about',
            component:MyAbout,
            meta:{title:'关于'}
        },
        {
            name:'zhuye',
            path:'/home',
            component:MyHome,
            meta:{isAuth:false,title:'主页'},
            children:[
                {
                    name:'xinxi',
                    path:'message',
                    component:MyMessage,
                    meta:{isAuth:true,title:'信息'},
                    children:[
                        {
                            name:'detail',
                            path:'detail',
                            component:MyDetail,
                            meta:{isAuth:true,title:'详情'},
                            // props函数写法
                            props($route){
                                return{
                                    id:$route.query.id,
                                    title:$route.query.title
                                }
                            }
                        }
                    ]
                },
                {
                    name:'xinwen',
                    path:'news',
                    component:MyNews,
                    meta:{isAuth:true,title:'新闻'},
                    // commit独享路由守卫。只有前置，没有后置
                    beforeEnter:(to, from, next)=>{
                        if(to.meta.isAuth===true){
                            if(localStorage.getItem('name')==='Alex'){
                                next()
                            }else {
                                alert('Only Alex could visit.')
                            }
                        }else {
                            next()
                        }
                    }
                }
            ]
        },
    ]
})

// commit全局守卫路由
// router.beforeEach((to,from,next)=>{
//     if(to.meta.isAuth===true){
//     // if(to.name==='xinxi' || to.path==='xinwen'){
//     // if(to.path==='/home/news' || to.path==='/home/message'){
//         if(localStorage.getItem('name')==='Alex'){
//             next()
//         }else {
//             alert('Only Alex could visit.')
//         }
//     }else {
//         next()
//     }
// })

router.afterEach((to,from)=>{
    console.log(to,from)
    document.title=to.meta.title || '硅谷系统'
})

export default router