<template>
  <div id="app">
    <router-link  to="/">Home</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/contact">Contact</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>
