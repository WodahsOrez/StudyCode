import Vue from 'vue';
import Vuex from 'vuex';
import VueRouter from 'vue-router';
import App from '@/App.vue';
import ElementUi from 'element-ui';
import ViewUI from 'view-design';

import 'element-ui/lib/theme-chalk/index.css';
import 'view-design/dist/styles/iview.css';

import '@/styles/default.less';

// 模拟数据
if (process.env.NODE_ENV === 'development') {
  require('@/mock');
}

const pathToRegExp = require('path-to-regexp');
import { AppComponents } from '@/app-register';
import store from '@/store';
import router from './router';

Vue.config.errorHandler = function (err: any, vm: any, info: any) {
  console.log(err);
}
Vue.config.productionTip = false;

Vue.use(Vuex);
Vue.use(VueRouter);;

// Vue.use(utils);
Vue.prototype.$pathToRegExp = pathToRegExp;
Vue.use(AppComponents);

router.beforeEach((to: any, from: any, next: any) => {
  if (to.meta && !to.meta.ignoreAddPage) {
    router.app.$store.commit('addPage', to);
  }
  next();
});


new Vue({
  store,
  router,
  render: (h: any) => h(App),
}).$mount('#app');