import Vue from 'vue'
import App from './App.vue'
import htmlToPdf from '@/utils/htmlTopdf'

Vue.config.productionTip = false
Vue.use(htmlToPdf)
new Vue({
  render: h => h(App),
}).$mount('#app')
