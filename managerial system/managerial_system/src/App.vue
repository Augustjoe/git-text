<template>
  <div id="app">
    <listOne  />
    <listTwo  />
  </div>
</template>

<script>
import listOne from "@/components/listOne"
import listTwo from "@/components/listTwo"
export default {
  name: 'App',
  components: {
    listOne,
    listTwo
  },
  data(){
    return{
     
    }
  }
}
</script>

<style>

</style>
