package com.school.schoolapp.Application.Controllers;

import com.school.schoolapp.Application.Requests.course.CreateCourseRequest;
import com.school.schoolapp.Application.response.course.CreateCourseResponse;
import com.school.schoolapp.Application.response.course.GetAllCourseResponse;
import com.school.schoolapp.domain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final ClassroomService classroomService;

    private final StudentService studentService;

    @Autowired
    public CourseController(CourseService courseService, TeacherService teacherService, ClassroomService classroomService, StudentService studentService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
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
                        this.teacherService.getTeacher(request.getTeacherId())
                        )
        );
        return new CreateCourseResponse(id);
    }
    @GetMapping
    public GetAllCourseResponse getAllCourses(){
        return new GetAllCourseResponse(courseService.getAll());
    }
}
