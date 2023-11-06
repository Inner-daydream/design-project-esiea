<script setup lang="ts">
import { onMounted, ref, onUnmounted, reactive } from 'vue';
import { QTableProps } from 'quasar';
import { School, AllSchoolJsonData, AddSchoolRequest} from './models';


const dialog = ref(false);
const form = reactive({
    name: '',
    address: '',
    phoneNumber: '',
});
const selectedSchoolId = ref('');

const openUpdateDialog = (row: School) => {
    form.name = row.name;
    form.address = row.address;
    form.phoneNumber = row.phoneNumber;
    dialog.value = true;
    selectedSchoolId.value = row.id;
};

const openAddDialog = () => {
    form.name = '';
    form.address = '';
    form.phoneNumber = '';
    dialog.value = true;
    selectedSchoolId.value = '';
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

const updateSchool = async (school: School) => {
    const response = await fetch(process.env.API_URL + '/school/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(school),
    });
    if (!response.ok) {
        console.error('Error updating school');
        return;
    }
    await getSchools();
};

const saveSchool = async () => {
    const school: School = {
        id: selectedSchoolId.value,
        name: form.name,
        address: form.address,
        phoneNumber: form.phoneNumber,
    };
    updateSchool(school);
    dialog.value = false;
};

const addSchool = async () => {
    const school: AddSchoolRequest = {
        name: form.name,
        address: form.address,
        phoneNumber: form.phoneNumber,
    };
    const response = await fetch(process.env.API_URL + '/school/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(school),
    });
    if (!response.ok) {
        console.error('Error adding school');
        return;
    }
    await getSchools();
    dialog.value = false;
};

let interval: NodeJS.Timeout;
onMounted(() => {
    getSchools();
    interval = setInterval(getSchools, 5000);
});
onUnmounted(() => {
    clearInterval(interval);
});

const columns: QTableProps['columns'] = [
    { name: 'name', label: 'Name', align: 'left', field: (row: School) => row.name, sortable: true },
    { name: 'address', label: 'Address', align: 'left', field: (row: School) => row.address },
    { name: 'phoneNumber', label: 'Phone Number', align: 'left', field: (row: School) => row.phoneNumber },
    { name: 'actions', label: 'Actions', align: 'center', field: (row: School) => row.id },
];

</script>

<template>
<div class="container">
    <div class="add-school">
        <q-btn color="primary" label="Add School" @click="openAddDialog()" />
    </div>
    <div class="school-table">
        <q-table :rows="schools" :columns="columns" row-key="name" title="Schools" flat bordered>
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
                    <div class="text-h6">Edit School</div>
                </q-card-section>
                <q-card-section>
                    <q-input v-model="form.name" label="Name" />
                    <q-input v-model="form.address" label="Address" />
                    <q-input v-model="form.phoneNumber" label="Phone Number" />
                </q-card-section>
                <q-card-actions align="right">
                    <q-btn flat label="Cancel" color="primary" v-close-popup />
                    <div v-if="selectedSchoolId!==''">
                        <q-btn flat label="Save" color="primary" @click="saveSchool()" />
                    </div>
                    <div v-else>
                        <q-btn flat label="Add" color="primary" @click="addSchool()" />
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

.add-school {
    margin-bottom: 2rem;
}
</style>
