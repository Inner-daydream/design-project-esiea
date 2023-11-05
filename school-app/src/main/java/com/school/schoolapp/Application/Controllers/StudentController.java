package com.school.schoolapp.Application.Controllers;
import com.school.schoolapp.Application.Requests.student.CreateStudentRequest;
import com.school.schoolapp.Application.Requests.student.UpdateStudentRequest;
import com.school.schoolapp.Application.response.student.CreateStudentResponse;
import com.school.schoolapp.Application.response.student.GetAllStudentsResponse;
import com.school.schoolapp.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService student;

    @Autowired
    public StudentController(StudentService student) {
        this.student = student;
    }

    @PostMapping("/create")
    public CreateStudentResponse createStudent(@RequestBody CreateStudentRequest request){
        UUID id = student.createStudent(request.getStudent());
        return new CreateStudentResponse(id);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody UpdateStudentRequest request){
        student.updateStudent(request.getStudent());
    }
    @GetMapping
    public GetAllStudentsResponse getStudent(){
        return new GetAllStudentsResponse(student.getAllStudents());
    }
    

}
