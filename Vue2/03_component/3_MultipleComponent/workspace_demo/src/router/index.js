import VueRouter from 'vue-router'
import MyAbout from '../pages/MyAbout'
import MyHome from '../pages/MyHome'
import MyMessage from "../pages/MyMessage";
import MyNews from "../pages/MyNews";
import MyDetail from "../pages/MyDetail";

export default new VueRouter({
    routes:[
        {
            path:'/about',
            component:MyAbout
        },
        {
            path:'/home',
            component:MyHome,
            children:[
                {
                    path:'message',
                    component:MyMessage,
                    children:[
                        {
                            name:'detail',
                            path:'detail/:id/:title',
                            component:MyDetail
                        }
                    ]
                },
                {
                    path:'news',
                    component:MyNews
                }
            ]
        },
    ]
})