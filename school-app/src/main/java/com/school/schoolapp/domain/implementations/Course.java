package com.school.schoolapp.domain.implementations;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;


public class Course extends Event {
    private boolean isExam;
    private Person Teacher;

    public boolean isExam() {
        return isExam;
    }
    
    public IPerson SetTeacher(IPerson teacher){
        return Teacher = (Person) teacher;
    }

    public Course(boolean isExam, IPerson teacher, String name, Classroom classroom, Date startDate, Date endDate, List<Student> students, int capacity, boolean isOptional) {
        super(name, classroom, startDate, endDate, students, capacity, isOptional);
        this.isExam = isExam;
        Teacher = (Person) teacher;
    }
    public Course(boolean isExam, IPerson teacher, String name, Classroom classroom, Date startDate, Date endDate, List<Student> students, int capacity, boolean isOptional, UUID id) {
        super(name, classroom, startDate, endDate, students, capacity, isOptional);
        this.isExam = isExam;
        Teacher = (Person) teacher;
        super.setId(id);
    }



    @Override
    public Person getTeacher() throws Exception {
        return Teacher;
    }

    ;
    // @Override
    // public Person getTeacher() throws Exception {
    //     return this.Teacher;
    // }

}
