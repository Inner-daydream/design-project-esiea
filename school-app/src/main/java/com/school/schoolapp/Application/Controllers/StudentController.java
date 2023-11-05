package com.school.schoolapp.Application.Controllers;
import com.school.schoolapp.Application.Requests.CreateStudentRequest;
import com.school.schoolapp.Application.response.CreateStudentResponse;
import com.school.schoolapp.domain.services.PersonService;
import com.school.schoolapp.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService student;
    private final PersonService personService;

    @Autowired
    public StudentController(StudentService student, PersonService personService) {
        this.student = student;
        this.personService = personService;
    }

    @PostMapping("/create")
    public CreateStudentResponse createStudent(@RequestBody CreateStudentRequest request){
        UUID id = student.createStudent(request.getStudent());
        return new CreateStudentResponse(id);
    }
}
