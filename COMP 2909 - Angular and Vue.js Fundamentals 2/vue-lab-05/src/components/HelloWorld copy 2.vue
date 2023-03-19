<template>
  <div class="hello">
    <div v-for="item in items" v-bind:key="item">
      {{ item }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      items: ['apples', 'peaches', 'pears', 'plums']
    }
  }
}
</script>
