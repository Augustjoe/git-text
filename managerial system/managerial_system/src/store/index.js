import vue from 'vue'
import Vuex from 'vuex'

vue.use(Vuex)

const store = new Vuex.Store({
    state:{ //再vuex中这些属性的名字都是固定的
        product:[
            {name:'刘强东',money:'250'},
            {name:'马化腾',money:'300'},
            {name:'马云',money:'400'},
            {name:'李彦宏',money:'200'},
          ]
    },
    getters:{ //getters的名字是固定的
        whoTheFirst(state){
            state.product.sort((a,b)=>{
                return b.money-a.money
            })
        }
    },
    mutations:{ //mutations中的所有函数都是及时的
        add(state,num){
            state.product.forEach((item)=>[
                item.money= Number(item.money) + num
            ])
        }
    },
    actions:{
        add(state,num){
            setTimeout(
              ()=>{
                    state.commit('add',num)
                  },3000)
        }
    }

})
export default store;