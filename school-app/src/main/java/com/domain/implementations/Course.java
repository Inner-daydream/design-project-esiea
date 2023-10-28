package com.domain.implementations;

import com.domain.Interfaces.IClassroom;
import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;

import java.util.Date;
import java.util.List;

public class Course extends Event {
    private boolean isExam;
    private IPerson Teacher;

    public boolean isExam() {
        return isExam;
    }
    public IPerson getTeacher() {
        return Teacher;
    }
    public IPerson SetTeacher(IPerson teacher){
        return Teacher = teacher;
    }

    public Course(String id, String name, IClassroom classroom, Date startDate, Date endDate, List<IPerson> students, int capacity, boolean isOptional, boolean isExam, IPerson teacher) {
        super(id, name, classroom, startDate, endDate, students, capacity, isOptional);
        this.isExam = isExam;
        Teacher = teacher;
    }
}
