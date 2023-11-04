package com.domain.implementations;

import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Event;
import com.domain.abstractions.Person;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class Course extends Event {
    private boolean isExam;
    @OneToOne
    private Person Teacher;

    public boolean isExam() {
        return isExam;
    }
    //public Person getTeacher() {
        //return Teacher;
    //}
    public IPerson SetTeacher(IPerson teacher){
        return Teacher = (Person) teacher;
    }

    public Course(boolean isExam, IPerson teacher) {
        this.isExam = isExam;
        Teacher = (Person) teacher;
    }
}
