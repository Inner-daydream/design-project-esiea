package com.school.schoolapp.domain.implementations;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;

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
        GradeEvent gradeEvent = new GradeEvent((Event)event, (Person)student);
        gradeEvent.addGrade(grade);
        student1.AddGrades(event, grade);
    }
}
