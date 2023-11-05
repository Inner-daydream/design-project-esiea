package com.school.schoolapp.Application.response.student;

import com.school.schoolapp.domain.implementations.Student;
import java.util.List;
public class GetAllStudentsResponse {
    
    private List<Student> students;

    public GetAllStudentsResponse(List<Student> students) {
        this.students = students;
    }
    public List<Student> getStudents() {
        return this.students;
    }
}
