package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.CreateCourseRequest;
import com.school.schoolapp.Application.response.CreateCourseResponse;
import com.school.schoolapp.domain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    private final PersonService personService;
    private final ClassroomService classroomService;

    private final StudentService studentService;

    @Autowired
    public CourseController(CourseService courseService, PersonService personService, ClassroomService classroomService, StudentService studentService) {
        this.courseService = courseService;
        this.personService = personService;
        this.classroomService = classroomService;
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public CreateCourseResponse createCours(@RequestBody CreateCourseRequest request){
        int i=0;
        UUID id = courseService.createCourse(
                request.getCourse(
                        this.classroomService.getClassroom(request.getClassroomID()),
                        this.studentService.getStudents(request.getStudentsIDs()),
                        this.personService.getPerson(request.getTeacherId())
                        )
        );
        return new CreateCourseResponse(id);
    }
}
