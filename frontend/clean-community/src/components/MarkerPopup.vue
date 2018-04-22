<template>
  <l-marker :lat-lng="posting.location.split(',')" :title="posting.title" :draggable="false">
    <l-popup>

      <!-- Shared in admin and volunteer view -->
      <h2>{{ posting.title }}</h2>
      <h3>{{ posting.associatedUsername }}</h3>
      <p>{{ posting.description }}</p>

      <!-- Only volunteer view -->
      <span v-if="!isAdmin">
        <button @click="reportPost()">Report Post</button>
        <button @click="deletePost()">Complete</button>
      </span>

      <!-- Only admin view -->
      <span v-if="isAdmin">
        <p v-if="this.posting.flagged" style="font-weight: bold; color: red">This post has been reported. Action required.</p>
        <button @click="unreportPost()" v-if="this.posting.flagged">Unreport Post</button>
        <button @click="deletePost()">Delete Post</button>
      </span>

    </l-popup>
  </l-marker>
</template>

<script>
import Bus from './bus.js';

import { LMarker, LPopup } from 'vue2-leaflet';
import axios from 'axios';

export default {
  name: 'MarkerPopup',

  props: ['posting', 'isAdmin'],

  components: {
    LMarker,
    LPopup
  },

  methods: {

    reportPost() {
      axios.put('/flag/' + this.posting.id)
        .then(res => {
          console.log(res);
          Bus.$emit('refresh-markers');
        })
        .catch(err => {
          alert(err);
        });
    },

    unreportPost() {
      axios.put('/unreport/' + this.posting.id + '?username=' + this.adminUsername)
        .then(res => {
          console.log(res);
          Bus.$emit('refresh-markers');
        })
        .catch(err => {
          alert(err);
        });
    },

    deletePost() {
      axios.delete('/postings/' + this.posting.id + '?username=' + this.adminUsername)
        .then(res => {
          console.log(res);
          Bus.$emit('refresh-markers');
        })
        .catch(err => {
          alert(err);
        })
    }

  },

  data () {
    return {
      adminUsername: 't2nerb'
    }
  }
}
</script>
