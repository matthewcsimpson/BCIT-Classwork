<template>
  <div class="hello">
    First Name:
    <input v-model="$v.fname.$model" v-on:blur="$v.fname.$touch()" />
    <!-- $dirty indicates that the input was used. -->
    <div v-if="$v.fname.$dirty && !$v.fname.required">Field is required</div>
    <div v-if="!$v.fname.minLength">
      Name must have at least {{ $v.fname.$params.minLength.min }} letters.
    </div>
    <div v-if="!$v.fname.alpha">Name must contain letters only</div>
    <br />

    Last Name:
    <input v-model="$v.lname.$model" v-on:blur="$v.lname.$touch()" />
    <div v-if="$v.lname.$dirty && !$v.lname.required">Field is required</div>
    <div v-if="!$v.lname.minLength || !$v.lname.maxLength">
      Name must be between at {{ $v.lname.$params.minLength.min }} and
      {{ $v.lname.$params.maxLength.max }} letters.
    </div>
    <div v-if="!$v.lname.alpha">Name must contain letters only</div>

    <br /><br />
    Age
    <input class="form__input" v-model="$v.age.$model" />
    <div class="error" v-if="!$v.age.between">
      Must be between {{ $v.age.$params.between.min }} and
      {{ $v.age.$params.between.max }}
    </div>
    <br /><br />
      Temperature:
      <input v-model="$v.temp.$model" v-on:blur="$v.temp.$touch()" />
    <div v-if="$v.temp.$dirty && !$v.temp.required">Field is required</div>
  </div>
</template>
<script>
import {
  required,
  minLength,
  maxLength,
  between,
  helpers
} from 'vuelidate/lib/validators'
const alpha = helpers.regex('alpha', /^[a-zA-Z]*$/)
export default {
  name: 'HelloWorld',
  data () {
    return {
      fname: '',
      lname: '',
      age: null,
      temp: null
    }
  },
  validations: {
    fname: {
      required,
      minLength: minLength(4),
      alpha
    },
    lname: {
      required,
      minLength: minLength(3),
      maxLength: maxLength(14),
      alpha
    },
    age: {
      between: between(20, 30)
    },
    temp: {
      required
    }
  },
  methods: {}
}
</script>
