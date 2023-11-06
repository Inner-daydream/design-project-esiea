<template>
    <q-layout view="lHh Lpr lFf">
      <q-header elevated>
        <q-toolbar>
          <q-tabs>
            <q-route-tab v-for="nav in navigation" :key="nav.to" :to="nav.to" :label="nav.label" :icon="nav.icon"
              :id="nav.label" exact />
          </q-tabs>
        </q-toolbar>
      </q-header>
  
      <q-page-container>
        <router-view />
      </q-page-container>
    </q-layout>
  </template>
  
  <script setup>
  const navigation = [
    {
      icon: "school",
      label: "Schools",
      to: "/school",
    },
    {
      icon: "supervisor_account",
      label: "Teachers",
      to: "/teacher",
    },
    {
      icon: "child_care",
      label: "Students",
      to: "/students",
    },
    {
      icon: "meeting_room",
      label: "Classrooms",
      to: "/classrooms",
    },
  ];
  </script>
  