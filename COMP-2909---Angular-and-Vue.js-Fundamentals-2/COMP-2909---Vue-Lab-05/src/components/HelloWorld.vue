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
    <h1>SHOE SEARCH</h1>
    <form>
      <div>
        ShoeID: <input v-model.trim="$v.shoeid.$model" /><br />
        Shoe ID Input: {{ shoeid }}
      </div>
      <div v-if="!$v.shoeid.required">Input required</div>
      <div v-if="!$v.shoeid.numnum">Must be numbers only</div>
      <button v-on:click="getShoe(parseInt(shoeid))">Submit!</button>
    </form>

  </div>
</template>

<script>
import mymixin from './mymixin'
import { required, helpers } from 'vuelidate/lib/validators'
const numnum = helpers.regex('alpha', /^[0-9]*$/)

export default {
  name: 'HelloWorld',
  mixins: [mymixin],
  data () {
    return {
      shoeid: null,
      msg: 'Hello from HelloWorld component.'
    }
  },
  validations: {
    shoeid: {
      required,
      numnum
    }
  }
}
</script>
