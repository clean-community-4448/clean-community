<template>
  <div id="Main">

    <transition name="fade">

      <div id="admin-check" v-if="!adminChoiceSelected">
        <h1>Are you an Admin or Volunteer?</h1>
        <button @click="setAdmin">I'm an Admin!</button>
        <button @click="setVolunteer">I'm a Volunteer!</button>
      </div>

    </transition>

    <Map :isAdmin="isAdmin"></Map>
    <AdminInfoCard v-if="isAdmin"></AdminInfoCard>
    <VolunteerInfoCard v-if="!isAdmin"></VolunteerInfoCard>
    <NewPostingForm v-if="!isAdmin"></NewPostingForm>

    <div id="toggle-admin-chooser">
      <button @click="adminChoiceSelected = false">Switch Account</button>
    </div>

  </div>
</template>

<script>
import Map from './Map.vue'
import NewPostingForm from './NewPostingForm.vue'
import AdminInfoCard from './AdminInfoCard.vue'
import VolunteerInfoCard from './VolunteerInfoCard.vue'


export default {
  name: 'Main',

  components: {
    Map,
    AdminInfoCard,
    VolunteerInfoCard,
    NewPostingForm
  },

  props: {
    msg: String
  },

  methods: {

    setAdmin () {
      this.isAdmin = true;
      this.adminChoiceSelected = true;
    },

    setVolunteer () {
      this.isAdmin = false;
      this.adminChoiceSelected = true;
    }

  },

  data () {
    return {
      isAdmin: false,
      adminChoiceSelected: false
    }
  }
}
</script>

<style>
#Main {
  z-index: 0;
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
#admin-check {
  width: 100%;
  height: 100%;
  position: absolute;
  background: white;
  top: 0;
  left: 0;
  z-index: 10000000000000000;
}
#admin-check button {
  font-size: 18px;
  margin: 10px;
}
#toggle-admin-chooser {
  position: absolute;
  bottom: 0;
  left: 0;
  margin: 10px 10px;
  z-index: 100000000;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .7s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>
