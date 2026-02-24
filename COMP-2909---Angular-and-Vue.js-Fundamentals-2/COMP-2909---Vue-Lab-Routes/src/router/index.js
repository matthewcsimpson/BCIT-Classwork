import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import About from '@/components/About'
import Contact from '@/components/Contact'
Vue.use(Router)

export default new Router({
  mode: 'history', // Removes the hashbang.
  routes: [
    {
      path: '/',
      component: HelloWorld
    },
    // NEW
    {
      path: '/about',
      component: About
    },
    {
      path: '/contact',
      component: Contact
    }
  ]
})
