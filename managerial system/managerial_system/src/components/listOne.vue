<template>
  <div id="One">
      <h2>listOne</h2>
      <ul>
          <li v-for="list in productList" :key="list.name">
              <span style="margin-right:20px;" > 姓名：{{list.name}}</span>
              <span>收入：{{list.money}}</span>
          </li>
      </ul>
  </div>
</template>

<script>

export default {
   computed:{
       productList(){
           return this.$store.state.product
       }
   },
  data() {
    return{

    }
  }
}
</script>

<style>

</style>
