import Vuex from 'vuex'
import Vue from 'vue'

// 如果直接在main.js里使用会报错：在new Vue之前使用了Vue.use()
// 因此放到./store/index.js里
Vue.use(Vuex)

const actions={
    // 此处的context可以理解为miniStore
    // plus(context,value){
    //     // 此处的函数名一般写成大写，表示mutations里的
    //     console.log('plus of actions was called...')
    //     context.commit('PLUS',value)
    // },
    // minus(context,value){
    //     // 此处的函数名一般写成大写，表示mutations里的
    //     console.log('minus of actions was called...')
    //     context.commit('MINUS',value)
    // },
    plusOdd(context,value){
        // 此处的函数名一般写成大写，表示mutations里的
        console.log('plusOdd of actions was called...')
        context.commit('PLUSODD',value)
    },


}
const mutations={
    // mutations里的用大写
    PLUS(state,value){
        console.log('PLUS of mutations was called...')
        state.sum +=value
    },
    MINUS(state,value){
        console.log('MINUS of mutations was called...')
        state.sum -=value
    },
    PLUSODD(state,value){
        console.log('PLUSODD of mutations was called...')
        if(state.sum%2){
            state.sum +=value
        }
    }
}
const state={
    sum:0
}

export default new Vuex.Store({
    actions,
    mutations,
    state
})