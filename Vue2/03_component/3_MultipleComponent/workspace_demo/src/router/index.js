import VueRouter from 'vue-router'
import MyAbout from '../components/MyAbout'
import MyHome from '../components/MyHome'

export default new VueRouter({
    routes:[
        {
            path:'/about',
            component:MyAbout
        },
        {
            path:'/home',
            component:MyHome
        },
    ]
})