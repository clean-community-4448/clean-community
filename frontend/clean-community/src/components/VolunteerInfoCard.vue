<template>
  <div id="InfoCard">
    <h2>Ryan Rouleau</h2>
    <h3>Volunteer</h3>
  </div>
</template>

<script>
export default {
  name: 'VolunterInfoCard'

}
</script>

<style>
#InfoCard {
  position: absolute;
  top: 0;
  right: 0;
  z-index: 1000000000;
  width: 230px !important;
  height: 60;
  background: white;
  margin: 20px 20px;
  border-radius: 10px;
  box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
}
</style>
