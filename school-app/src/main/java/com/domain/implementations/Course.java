package com.domain.implementations;

import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;

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

    public Course(boolean isExam, IPerson teacher) {
        this.isExam = isExam;
        Teacher = teacher;
    }
}
