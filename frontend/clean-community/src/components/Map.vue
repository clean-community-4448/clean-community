<template>
  <div id="Map">
    <div style="height: 10%; overflow: auto;">
      <h3>Simple map</h3>
      Marker is placed at {{ marker.lat }}, {{ marker.lng }}
    </div>
    <l-map style="height: 90%; width: 100%" :zoom="zoom" :center="center">
      <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
    </l-map>
  </div>
</template>

<script>
import { LMap, LTileLayer, LMarker } from 'vue2-leaflet';

export default {
  name: 'Map',

  components: {
    LMap,
    LTileLayer,
    LMarker
  },

  data () {
    return {
      zoom:13,
      center: [40.0150, -105.2705],
      marker: [40.0150, -105.2705],
    }
  }

}
</script>

<style>
#Map {
  width: 100%;
  height: 100%;
}
</style>
