export interface School {
    id: string;
    name: string;
    address: string;
    phoneNumber: string;
}

export interface AllSchoolJsonData {
    schools: School[];
}

export interface SingleSchoolJsonData {
    schools: School;
}

export interface AddSchoolRequest {
    name: string;
    address: string;
    phoneNumber: string;
}

export interface Student {
    id: string;
    name: string;
    address: string;
    schoolID: string;
    lunchCredit: number;
    phoneNumber: string;
    schoolName?: string;
}

export interface StudentJsonData {
    students: Student[];
}
export interface TeacherJsonData {
    teachers: Teacher[];
}
export interface AddStudentRequest {
    name: string;
    address: string;
    schoolID: string;
    lunchCredit: number;
    phoneNumber: string;
}
export interface AddTeacherRequest {
    name: string;
    address: string;
    schoolID: string;
    salary: number;
    phoneNumber: string;
}

export interface Teacher {
    id: string;
    name: string;
    address: string;
    schoolID: string;
    phoneNumber: string;
    schoolName?: string;
    salary: number;
}
