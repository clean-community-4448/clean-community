<template>
  <div id="Map">
    <l-map style="height: 100%; width: 100%" :zoom="zoom" :center="center">
      <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
      <marker-popup :isAdmin="isAdmin" :posting="posting" v-for="posting in validPostings" :key="posting.id"></marker-popup>
    </l-map>
  </div>
</template>

<script>
import MarkerPopup from './MarkerPopup.vue';
import Bus from './bus.js';

import { LMap, LTileLayer, LMarker } from 'vue2-leaflet';
import axios from 'axios';

export default {
  name: 'Map',

  props: ['isAdmin'],

  components: {
    LMap,
    LTileLayer,
    LMarker,
    MarkerPopup
  },

  mounted() {
    Bus.$on('refresh-markers', this.addMarkers);
    this.addMarkers();
  },

  methods: {

    addMarkers () {
      axios.get('/postings/')
        .then(res => {
          this.postings = res.data;
          console.log(this.postings);
        })
        .catch(err => {
          alert(err);
        })
    }

  },

  computed: {

    validPostings () {
      return this.postings.filter(posting => {
        // If admin, display all posts, even reported ones
        if (this.isAdmin) return true;
        // If volunteer, hide reported posts until admin unreports
        return !posting.flagged && !this.isAdmin;
      })
    }

  },

  data () {
    return {
      zoom:14,
      center: [40.0150, -105.2705], // default to boulder lat/lang
      url:'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
      attribution:'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
      postings: []
    }
  }

}
</script>

<style>
.leaflet-fake-icon-image-2x !important {
  background-image: url(../../node_modules/leaflet/dist/images/marker-icon-2x.png);
}
.leaflet-fake-icon-shadow !important {
  background-image: url(../../node_modules/leaflet/dist/images/marker-shadow.png);
}
@import "../../node_modules/leaflet/dist/leaflet.css";
#Map {
  width: 100%;
  height: 100%;
}
</style>
