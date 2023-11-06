<script setup lang="ts">
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { QTableProps } from 'quasar';
import { SingleSchoolJsonData, School, AllSchoolJsonData, Teacher, TeacherJsonData, AddTeacherRequest} from './models';
const selectedSchool = ref();
const selectedStudentId = ref('');
const dialog = ref(false);
const form = reactive({
    name: '',
    address: '',
    phoneNumber: '',
    schoolID: '',
    salary : 0,
});

const getSchoolName = async (schoolId: string) => {
    const response = await fetch(process.env.API_URL + '/school/' + schoolId);
    if (!response.ok) {
        console.error('Error fetching school');
    }
    const data: SingleSchoolJsonData = await response.json();
    return data.schools.name;
};
const schools = ref<School[]>([]);
const getSchools = async () => {
    const response = await fetch(process.env.API_URL + '/school');
    if (!response.ok) {
        console.error('Error fetching schools');
    }
    const data: AllSchoolJsonData = await response.json();
    schools.value = data.schools;
};
const openUpdateDialog = (row: Teacher) => {
    getSchools();
    form.name = row.name;
    form.address = row.address;
    form.phoneNumber = row.phoneNumber;
    form.salary = row.salary;
    dialog.value = true;
    selectedStudentId.value = row.id;
};
const openAddDialog = () => {
    getSchools();
    form.name = '';
    form.address = '';
    form.phoneNumber = '';
    form.salary = 0;
    dialog.value = true;
    selectedStudentId.value = '';
};
const teachers = ref<Teacher[]>([]);
const getTeachers = async () => {
    const response = await fetch(process.env.API_URL + '/teacher');
    if (!response.ok) {
        console.error('Error fetching teachers');
    }
    const data: TeacherJsonData = await response.json();
    for(const teacher of data.teachers){
        const schoolName:string = await getSchoolName(teacher.schoolID);
        if (schoolName !== undefined) {
            teacher.schoolName  = schoolName;
        } else {
          teacher.schoolName = 'None';
        }
    }
    teachers.value = data.teachers;
};

const updateTeacher = async (teacher: Teacher) => {
  const response = await fetch(process.env.API_URL + "/teacher/update", {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(teacher)
  })
  if(!response.ok){
    console.error('Error updating teacher')
  }
}

const saveTeacher = async () => {
    const teacher: Teacher = {
        id: selectedStudentId.value,
        name: form.name,
        address: form.address,
        phoneNumber: form.phoneNumber,
        schoolID: selectedSchool.value.id,
        salary: form.salary
    };
    updateTeacher(teacher);
    dialog.value = false;
};

const addTeacher = async () => {
  const teacher: AddTeacherRequest = {
    name: form.name,
    address:form.address,
    phoneNumber: form.phoneNumber,
    schoolID: selectedSchool.value.id,
    salary: Number(form.salary)
  }
  const response = await fetch(process.env.API_URL + '/teacher/create', {
    method:'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(teacher)
  })
  if (!response.ok) {
      console.error('Error adding teacher');
      return;
  }
  await getTeachers();
  dialog.value = false;
}
let interval: NodeJS.Timeout;
onMounted(async () => {
  getTeachers();
  interval = setInterval(getTeachers, 5000);
});
onUnmounted(() => {
    clearInterval(interval);
});
const columns: QTableProps['columns'] = [
    { name: 'name', label: 'Name', align: 'left', field: (row: Teacher) => row.name, sortable: true },
    { name: 'address', label: 'Address', align: 'left', field: (row: Teacher) => row.address },
    { name: 'phoneNumber', label: 'Phone Number', align: 'left', field: (row: Teacher) => row.phoneNumber },
    { name: 'schoolName', label: 'School', align: 'left', field: (row: Teacher) => row.schoolName },
    { name: 'salary', label: 'Salary', align: 'left', field: (row: Teacher) => row.salary },
    { name: 'actions', label: 'Actions', align: 'center', field: (row: Teacher) => row.id },
];
</script>
<template>
  <div class="container">
      <div class="add-student">
          <q-btn color="primary" label="Add Teacher" @click="openAddDialog()" />
      </div>
      <div class="student-table">
          <q-table :rows="teachers" :columns="columns" row-key="name" title="Students" flat bordered>
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
                      <q-input v-model="form.address" label="Address" />
                      <q-input v-model="form.phoneNumber" label="Phone Number" />
                      <q-input v-model="form.salary" label="Salary" type="number" />
                      <q-select v-model="selectedSchool" :options="schools" label="School" option-label="name" option-value="id"/>
                  </q-card-section>
                  <q-card-actions align="right">
                      <q-btn flat label="Cancel" color="primary" v-close-popup />
                      <div v-if="selectedStudentId!==''">
                          <q-btn flat label="Save" color="primary" @click="saveTeacher()" />
                      </div>
                      <div v-else>
                          <q-btn flat label="Add" color="primary" @click="addTeacher()" />
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
