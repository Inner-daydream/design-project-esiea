package com.school.schoolapp.Application.Requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.implementations.Classroom;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Course;
import com.school.schoolapp.domain.implementations.Student;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class CreateCourseRequest {
    @NotNull
    private String name;
    @NotNull
    private String classroomID;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private List<String> studentsIDs;
    @NotNull
    private int capacity;
    @NotNull
    private boolean isOptional;
    @NotNull
    private boolean isExam;
    @NotNull
    private String teacherId;

    @JsonCreator
    public CreateCourseRequest(@JsonProperty("name") String name, @JsonProperty("classroomID") String classroomID, @JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate, @JsonProperty("studentsIDs") List<String> students, @JsonProperty("capacity") int capacity, @JsonProperty("isOptional") boolean isOptional,
                               @JsonProperty("isExam") boolean isExam,
                               @JsonProperty("teacherId") String teacherId) {
        this.name = name;
        this.classroomID = classroomID;
        this.studentsIDs = students;
        this.startDate = new Date(Long.parseLong(startDate) * 1000);
        this.endDate = new Date(Long.parseLong(endDate) * 1000);
        this.capacity = capacity;
        this.isOptional = isOptional;
        this.isExam = isExam;
        this.teacherId = teacherId;
    }
    public Course getCourse(Classroom classroom, List<Student> students, IPerson teacher){
        Course course = new Course(
                isExam,
                teacher,
                name,
                classroom,
                startDate,
                endDate,
                students,
                capacity,
                isOptional
        );
        return course;

    }
    public List<String> getStudentsIDs() {
        return studentsIDs;
    }
    public String getClassroomID() {
        return classroomID;
    }
    public Conference getConference(List<Student> students, IPerson speaker, Classroom classroom) {
        return new Conference(name, classroom, startDate, endDate, students, capacity, isOptional, speaker);
    }

    public String getTeacherId() {
        return teacherId;
    }
}
