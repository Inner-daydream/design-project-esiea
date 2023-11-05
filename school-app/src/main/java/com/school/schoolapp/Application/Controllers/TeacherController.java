package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.teacher.CreateTeacherRequest;
import com.school.schoolapp.Application.Requests.teacher.UpdateTeacherRequest;
import com.school.schoolapp.Application.response.CreateTeacherResponse;
import com.school.schoolapp.domain.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public CreateTeacherResponse createTeacher(@RequestBody CreateTeacherRequest request){
        UUID id = teacherService.createTeacher(request.getTeacher());
        return new CreateTeacherResponse(id);
    }

    @PutMapping("/update")
    public void updateTeacher(@RequestBody UpdateTeacherRequest request){
        teacherService.updateTeacher(request.getTeacher());
    }
}
