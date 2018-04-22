<template>
  <div id="NewPostingForm">
    <h2>Create New Posting</h2>
    <input v-model="title" placeholder="Title...">
    <input v-model="description" placeholder="Description...">
    <input v-model="address" placeholder="Address...">
    <button @click="createPosting()">Create Posting</button>
  </div>
</template>

<script>

import axios from 'axios';
import Bus from './bus.js';

export default {
  name: 'NewPostingForm',

  methods: {
    createPosting () {

      // Hit mapquest geocoding api to get lat/long from inputted address,
      // then hit clean community api to add posting

      const KEY = "F2GPL3tLYRX6To1wYX3yvLm7AXT8ptrG"
      let url = "http://www.mapquestapi.com/geocoding/v1/address?key=" + KEY + "&location=address" + this.address;
      axios.get(url)
        .then(res => {
          console.log(res.data.results[0].locations[0].latLng);
          let loc = res.data.results[0].locations[0].latLng;
          return axios.post('/postings/', {
            "id":-1,
            "title": this.title,
            "description": this.description,
            "associatedUsername": "barklin",
            "location": loc.lat + "," + loc.lng,
            "accepted":false,
            "completed":false,
            "flagged":false
          })
        })
        .then(res => {
          console.log(res);
          this.title = '';
          this.description = '';
          this.address = '';
          Bus.$emit('refresh-markers');
        })
        .catch(err => {
          alert(err);
        });
    }
  },

  data () {
    return {
      title: '',
      description: '',
      address: ''
    }
  }
}
</script>

<style scoped>
#NewPostingForm {
  position: absolute;
  bottom: 0;
  right: 0;
  z-index: 1000000000;
  width: 200px !important;
  height: 220px;
  background: white;
  margin: 40px 20px;
  border-radius: 10px;
  box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
}
</style>
