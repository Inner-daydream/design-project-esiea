package com.school.schoolapp.Application.response.student;

import com.school.schoolapp.domain.implementations.Student;
public class GetStudentResponse {
    
    private Student student;

    public GetStudentResponse(Student student) {
        this.student = student;
    }
    public Student getStudents() {
        return this.student;
    }
}
