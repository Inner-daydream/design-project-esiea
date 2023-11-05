package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import java.util.UUID;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String phoneNumber, String address, int salary) {
        super(name, phoneNumber, address);
        setSalary(salary);
    }
    public Teacher(String name, String phoneNumber, String address, int salary, UUID schoolID) {
        super(name, phoneNumber, address, schoolID);
        setSalary(salary);
    }

    public Teacher(UUID id, String name, String phoneNumber, String address, int salary, UUID schoolID) {
        super(name, phoneNumber, address, schoolID);
        setSalary(salary);
        this.setId(id);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void giveGrade(IEvent event, IPerson student, float grade) {
        IEvent eventRes = super.getEvent(event);
        Student student1 = (Student)eventRes.getAttendee(student);
        GradeEvent gradeEvent = new GradeEvent((Event)event, (Person)student);
        gradeEvent.addGrade(grade);
        student1.AddGrades(event, grade);
    }
}
