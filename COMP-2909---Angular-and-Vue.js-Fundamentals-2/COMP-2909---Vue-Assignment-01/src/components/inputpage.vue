/* eslint-disable vue/valid-v-model */
/* eslint-disable no-undef */
<template>
  <div class="hello">
    <form class="filterform">
      <input type="text" placeholder="search artist..." v-model="searchstring" />
      <button v-on:click="addItemYesNo()">Add Artist</button>        <!-- <button v-on:click="getUserImage()">PRESS ME</button> -->

    </form>
    <form @submit.prevent="submit" class="addform" v-if="addItemOk">
      <input
        type="text"
        placeholder="artist name"
        id="name"
        v-model="artistname"
      /><br />
      <input
        type="text"
        placeholder="artist info"
        id="into"
        v-model="artistinfo"
      /><br />
      <!-- <input
        type="text"
        placeholder="image url"
        id="url"
        v-model="imageurl"
      /><br /> -->
      <button type="submit">ADD</button>
    </form>
    <table>
      <tr v-for="(artist, key) in this.artistList" :key="key" v-if="artist.name.toLowerCase().includes(searchstring.toLowerCase())">
        <td class="userimg"><img :src="artist.imageurl" /></td>
        <td class="userdata">
          <span class="name" v-text="artist.name"></span><br />
          <span class="about" v-text="artist.info"></span>
        </td>
        <td class="delete">
          <button v-on:click="deleteArtist(key)">DELETE</button>
        </td>
      </tr>
    </table>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'inputpage',
  data () {
    return {
      searchstring: '',
      addItemOk: false,
      artistname: '',
      artistinfo: '',
      imageurl: '',
      artistid: 1,
      artistList: [],
      artistImageData: null,
      artistImageURL: 'https://randomuser.me/api/portraits/med/women/1.jpg'
    }
  },
  methods: {
    addItemYesNo () {
      if (this.addItemOk === false) {
        this.addItemOk = true
      } else if (this.addItemOk === true) {
        this.addItemOk = false
      }
      console.log(this.addItemOk)
    },
    submit () {
      this.getUserImage()
      const artistjson = JSON.parse(
        JSON.stringify({
          id: this.artistid,
          name: this.artistname,
          info: this.artistinfo,
          imageurl: this.artistImageURL
        })
      )
      console.log('added artist: ' + artistjson)
      this.artistid += 1
      this.artistList.push(artistjson)
      console.log('current array: ' + this.artistList)
    },
    deleteArtist (artistindex) {
      this.$delete(this.artistList, artistindex)
    },
    getUserImage () {
      axios.get('https://randomuser.me/api/?inc=picture').then(response => (
        this.artistImageURL = response.data.results[0].picture.medium
      ))
      console.log(this.artistImageURL)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.filterform input {
  width: 400px;
  height: 70px;
  font-size: 50px;
  padding: 10px;
  margin: 20px;
  vertical-align: middle;
}
.filterform button {
  height: 60px;
  width: 100px;
  padding: 0px;
  vertical-align: middle;
}
.addform input {
  width: 400px;
  height: 60px;
  font-size: 40px;
  padding: 10px;
  margin: 10px;
  vertical-align: middle;
}
.addform button {
  width: 400px;
  height: 60px;
  font-size: 40px;
  margin-bottom: 30px;
}
table {
  width: 600px;
  margin-left: auto;
  margin-right: auto;
  border: 1px solid black;
  margin-bottom: 300px;
}
table tr {
  width: 100%;
  height: 72px;
  border: 1px solid black;
}
table tr td.userimg {
  width: 100px;
  border: 1px solid black;
}
table tr td.userdata {
  width: 400px;
  text-align: left;
  border: 1px solid black;
}
table tr td.delete {
  border: 1px solid black;
  width: 100px;
}
table tr td.delete button {
  width: 80px;
  height: 60px;
  color: white;
  background-color: red;
}
table tr td span.name {
  font-size: 30px;
  align-content: left;
}
table tr td span.about {
  font-size: 15px;
  text-align: left;
}
</style>
