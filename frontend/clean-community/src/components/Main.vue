<template>
  <div id="Main">
    <Map></Map>
  </div>
</template>

<script>
import axios from 'axios';
import Map from './Map.vue'

export default {
  name: 'Main',

  components: {
    Map
  },

  props: {
    msg: String
  },

  mounted() {
    axios.get('/postings/')
      .then(res => {
        console.log(res);
        this.test = res;
      })
      .catch(err => {
        this.test = err;
      });
  },

  data() {
    return {
      test: "blah"
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

.leaflet-fake-icon-image-2x {
  background-image: url(../../node_modules/leaflet/dist/images/marker-icon-2x.png);
}
.leaflet-fake-icon-shadow {
  background-image: url(../../node_modules/leaflet/dist/images/marker-shadow.png);
}
@import "../../node_modules/leaflet/dist/leaflet.css";
#Main {
  position: absolute;
  overflow-x: auto;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}
body {
  margin: 0px;
}
/*
h3 {
  margin: 40px 0 0;
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
*/
</style>
