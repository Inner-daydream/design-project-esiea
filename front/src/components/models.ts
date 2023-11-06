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
export interface AddStudentRequest {
    name: string;
    address: string;
    schoolID: string;
    lunchCredit: number;
    phoneNumber: string;
}

