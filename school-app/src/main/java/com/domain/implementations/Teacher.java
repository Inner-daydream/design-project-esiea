package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Person;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String phoneNumber, String address, School school, int salary) throws Exception {
        super(name, phoneNumber, address, school);
        setSalary(salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws Exception {
        if (salary < 0){
            throw new Exception("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public void giveGrade(IEvent event, IPerson student, float grade) {
        IEvent eventRes = super.getEvent(event);
        Student student1 = (Student)eventRes.getAttendee(student);
        GradeEvent gradeEvent = new GradeEvent(event, student);
        gradeEvent.addGrade(grade);
        student1.AddGrades(event, grade);
    }
}
