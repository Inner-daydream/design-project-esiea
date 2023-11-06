<script setup lang="ts">
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { QTableProps } from 'quasar';
import { Student, StudentJsonData, AddStudentRequest, SingleSchoolJsonData, School, AllSchoolJsonData} from './models';
import { cpuUsage } from 'process';

const selectedStudentId = ref('');
// somehow this holds the entire school object when I try to only store the id, temporary fix is using the whole object
const selectedSchool = ref();

const dialog = ref(false);
const form = reactive({
    name: '',
    address: '',
    phoneNumber: '',
    schoolID: '',
    lunchCredit : 0,
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

const openUpdateDialog = (row: Student) => {
    getSchools();
    form.name = row.name;
    form.address = row.address;
    form.phoneNumber = row.phoneNumber;
    dialog.value = true;
    selectedStudentId.value = row.id;
};

const openAddDialog = () => {
    getSchools();
    form.name = '';
    form.address = '';
    form.phoneNumber = '';
    dialog.value = true;
    selectedStudentId.value = '';
};

const students = ref<Student[]>([]);
const getStudents = async () => {
    const response = await fetch(process.env.API_URL + '/student');
    if (!response.ok) {
        console.error('Error fetching students');
    }
    const data: StudentJsonData = await response.json();
    for (const student of data.students) {
        const schoolName : string = await getSchoolName(student.schoolID);
        if (schoolName !== undefined) {
            student.schoolName = schoolName;
        } else {
            student.schoolName = 'None';
        }
    }
    students.value = data.students;
};

const updateStudent = async (student: Student) => {
    console.log(JSON.stringify(student));
    const response = await fetch(process.env.API_URL + '/student/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
    });
    if (!response.ok) {
        console.error('Error updating student');
        return;
    }
    await getStudents();
};

const saveStudent = async () => {
    const student: Student = {
        id: selectedStudentId.value,
        name: form.name,
        address: form.address,
        phoneNumber: form.phoneNumber,
        schoolID: selectedSchool.value.id,
        lunchCredit: Number(form.lunchCredit),
    };
    updateStudent(student);
    dialog.value = false;
};

const addStudent = async () => {
    const student: AddStudentRequest = {
        name: form.name,
        address: form.address,
        phoneNumber: form.phoneNumber,
        schoolID: selectedSchool.value.id,
        lunchCredit: Number(form.lunchCredit),
    };
    console.log(JSON.stringify(student));
    const response = await fetch(process.env.API_URL + '/student/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
    });
    if (!response.ok) {
        console.error('Error adding student');
        return;
    }
    await getStudents();
    dialog.value = false;
};

let interval: NodeJS.Timeout;
onMounted(() => {
    getStudents();
    interval = setInterval(getStudents, 5000);
});
onUnmounted(() => {
    clearInterval(interval);
});

const columns: QTableProps['columns'] = [
    { name: 'name', label: 'Name', align: 'left', field: (row: Student) => row.name, sortable: true },
    { name: 'address', label: 'Address', align: 'left', field: (row: Student) => row.address },
    { name: 'phoneNumber', label: 'Phone Number', align: 'left', field: (row: Student) => row.phoneNumber },
    { name: 'schoolName', label: 'School', align: 'left', field: (row: Student) => row.schoolName },
    { name: 'lunchCredit', label: 'Lunch Credit', align: 'left', field: (row: Student) => row.lunchCredit },
    { name: 'actions', label: 'Actions', align: 'center', field: (row: Student) => row.id },
];

</script>

<template>
<div class="container">
    <div class="add-student">
        <q-btn color="primary" label="Add Student" @click="openAddDialog()" />
    </div>
    <div class="student-table">
        <q-table :rows="students" :columns="columns" row-key="name" title="Students" flat bordered>
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
                    <div class="text-h6">Edit Student</div>
                </q-card-section>
                <q-card-section>
                    <q-input v-model="form.name" label="Name" />
                    <q-input v-model="form.address" label="Address" />
                    <q-input v-model="form.phoneNumber" label="Phone Number" />
                    <q-input v-model="form.lunchCredit" label="Lunch Credit" type="number" />
                    <q-select v-model="selectedSchool" :options="schools" label="School" option-label="name" option-value="id"/>
                </q-card-section>
                <q-card-actions align="right">
                    <q-btn flat label="Cancel" color="primary" v-close-popup />
                    <div v-if="selectedStudentId!==''">
                        <q-btn flat label="Save" color="primary" @click="saveStudent()" />
                    </div>
                    <div v-else>
                        <q-btn flat label="Add" color="primary" @click="addStudent()" />
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
