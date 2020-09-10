<template>
  <div id="One">
      <h2>listTwo</h2>
      <ul>
            <li v-for="list in productList" :key="list.name">
              <span style="margin-right:20px;" > 姓名：{{list.name}}</span>
              <span>收入：{{list.money}}</span>
          </li>
      </ul>
      <button @click="whoTheFirst">who first</button>
      <button @click="add(2)">try add</button>
      <button @click="addTwo">try add again</button>
  </div>
</template>

<script>

import { mapGetters } from 'vuex' 
import { mapActions } from 'vuex' 

export default {
  data(){
    return{
       productList:[] 
    }
  },
  methods:{
      ...mapGetters([ //不能放在函数中
        'whoTheFirst'//可以通过数组的方式引用，使用方法与函数相同
      ]),
      ...mapActions([
        'add',//可以通过数组的方式引用，使用方法与函数相同
      ]),
      addTwo(){
        this.add(4)
      }
    // add(num){
    //   // this.$store.commit('add')
    //   this.$store.dispatch('add',num)
    // }

  },
  watch:{
      get(){
          console.log(1)
          this.productList = this.$store.state.product
      }
     
  },
  mounted() {
      this.productList = this.$store.state.product
  },
}
</script>

<style>

</style>
