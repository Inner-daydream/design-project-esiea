<script setup lang="ts">
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { QTableProps } from 'quasar';
import { Classroom, ClassroomJsonData, AddClassroomRequest } from './models';
const dialog = ref(false);
const form = reactive({
    name: '',
    buildingName: '',
    capacity: 0,
});
const classrooms = ref<Classroom[]>([]);
const selectedStudentId = ref('');
const getClassrooms = async () => {
    const response = await fetch(process.env.API_URL + '/classroom');
    if (!response.ok) {
        console.error('Error fetching classrooms');
    }
    const data: ClassroomJsonData = await response.json();
    classrooms.value = data.classrooms;
};

const openUpdateDialog = (row: Classroom) => {
    form.name = row.name;
    form.buildingName = row.buildingName;
    form.capacity = row.capacity;
    dialog.value = true;
    selectedStudentId.value = row.id;
};
const openAddDialog = () => {
    form.name = '';
    form.buildingName = '';
    form.capacity = 0;
    dialog.value = true;
    selectedStudentId.value = '';
};
const updateClassroom = async (classrooms: Classroom) => {
    const response = await fetch(process.env.API_URL + '/classroom/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(classrooms),
    });
    if (!response.ok) {
        console.error('Error updating classroom');
    }
    getClassrooms();
};
const saveClassroom = async () => {
    const classroom: Classroom = {
        id: selectedStudentId.value,
        name: form.name,
        buildingName: form.buildingName,
        capacity: form.capacity,
    };
    updateClassroom(classroom);
    dialog.value = false;
};
const addClassroom = async () => {
  const classroom: AddClassroomRequest = {
    name: form.name,
    buildingName: form.buildingName,
    capacity: form.capacity
  }
  const response = await fetch(process.env.API_URL + '/classroom/create', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(classroom),
  });
  if (!response.ok) {
    console.error('Error adding classroom');
  }
  await getClassrooms();
  dialog.value = false;
};
let interval: NodeJS.Timeout;
onMounted(async () => {
  getClassrooms();
  interval = setInterval(getClassrooms, 5000);
});
onUnmounted(() => {
    clearInterval(interval);
});
const columns: QTableProps['columns'] = [
    { name: 'name', label: 'Name', align: 'left', field: (row: Classroom) => row.name, sortable: true },
    { name: 'buildingName', label: 'Building Name', align: 'left', field: (row: Classroom) => row.buildingName },
    { name: 'capacity', label: 'Capacity', align: 'left', field: (row: Classroom) => row.capacity },
    { name: 'actions', label: 'Actions', align: 'center', field: (row: Classroom) => row.id },
];
</script>
<template>
  <div class="container">
      <div class="add-student">
          <q-btn color="primary" label="Add Classroom" @click="openAddDialog()" />
      </div>
      <div class="student-table">
          <q-table :rows="classrooms" :columns="columns" row-key="name" title="Classrooms" flat bordered>
              <template v-slot:body-cell-actions="props">
                  <q-td key="actions" :props="props">
                      <q-btn size="sm" color="primary" icon="mode_edit" @click="openUpdateDialog(props.row)" />
                  </q-td>
              </template>
          </q-table>
      </div>
      <div>
          <q-dialog v-model="dialog">
              <q-card class="update-dialog">
                  <q-card-section>
                      <div class="text-h6">Edit Teacher</div>
                  </q-card-section>
                  <q-card-section>
                      <q-input v-model="form.name" label="Name" />
                      <q-input v-model="form.buildingName" label="Building Name" />
                      <q-input v-model="form.capacity" label="Capacity" />
                  </q-card-section>
                  <q-card-actions align="right">
                      <q-btn flat label="Cancel" color="primary" v-close-popup />
                      <div v-if="selectedStudentId!==''">
                          <q-btn flat label="Save" color="primary" @click="saveClassroom()" />
                      </div>
                      <div v-else>
                          <q-btn flat label="Add" color="primary" @click="addClassroom()" />
                      </div>

                  </q-card-actions>
              </q-card>
          </q-dialog>
      </div>
  </div>
  </template>

  <style scoped>

  .container {
      margin: 0 auto;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
  }

  .update-dialog {
      width: 100%;
  }

  .add-student {
      margin-bottom: 2rem;
  }
  </style>
