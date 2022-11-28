import VueRouter from 'vue-router'
import MyAbout from '../components/MyAbout'
import MyHome from '../components/MyHome'
import MyMessage from "../components/MyMessage";
import MyNews from "../components/MyNews";
import MyDetail from "../components/MyDetail";

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
                            path:'detail',
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