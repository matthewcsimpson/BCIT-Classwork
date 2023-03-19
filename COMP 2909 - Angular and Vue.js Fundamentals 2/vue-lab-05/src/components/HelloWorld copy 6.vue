/* eslint-disable vue/no-parsing-error */
<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{ mixinMsg }}</h2>
    <button v-on:click="showMixinAlert()">Show alert</button>
     <ul>
      <li v-for="item in footwear" :key="item.id">
        ID {{ item.id }}: {{ item.brand }} - {{ item.shoe }}
      </li>
    </ul>
    <h1>FULL NAME: {{ fullname }}</h1>
    <button v-on:click="assignFullName()">ADD THE FULL NAME</button>
  </div>
</template>

<script>
import mymixin from './mymixin'

export default {
  name: 'HelloWorld',
  mixins: [mymixin],
  data () {
    return {
      msg: 'Hello from HelloWorld component.'
    }
  }
}
</script>
