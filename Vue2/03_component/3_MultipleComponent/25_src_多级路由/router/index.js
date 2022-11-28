import VueRouter from 'vue-router'
import MyAbout from '../components/MyAbout'
import MyHome from '../components/MyHome'
import MyMessage from "@/../components/MyHome/MyMessage";
import MyNews from "@/../components/MyHome/MyNews";

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
                    component:MyMessage
                },
                {
                    path:'news',
                    component:MyNews
                }
            ]
        },
    ]
})