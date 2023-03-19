<template>
  <div class="hello">
    <form @submit.prevent="submitMyForm()">
      <div>
        First:<input v-model.trim="$v.fname.$model" /><br />
        Last:<input v-model.trim="$v.lname.$model" />
      </div>
      <div v-if="!$v.fname.required">First name is required</div>
      <div v-if="!$v.lname.required">Last name is required</div>
      <div v-if="!$v.fname.minLength">
        Name must have at least {{ $v.fname.$params.minLength.min }} letters.
      </div>
      <div v-if="!$v.lname.minLength">
        Name must have at least {{ $v.lname.$params.minLength.min }} letters.
      </div>
      <button type="submit">Submit!</button>
    </form>
  </div>
</template>
<script>
import { required, minLength } from 'vuelidate/lib/validators'

export default {
  data () {
    return {
      fname: '',
      lname: '',
      age: 0,
      submitStatus: null
    }
  },
  validations: {
    fname: {
      required,
      minLength: minLength(4)
    },
    lname: {
      required,
      minLength: minLength(5)
    }
  },
  methods: {
    submitMyForm () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        this.submitStatus = 'ERROR'
      } else {
        this.submitStatus = 'OK'
      }
      alert(this.submitStatus)
    }
  }
}
</script>
