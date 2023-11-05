package com.school.schoolapp.domain.implementations;

import java.util.UUID;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.Interfaces.IPerson;
import com.school.schoolapp.domain.abstractions.Person;

public class Admin extends Person {
    private int salary;

    public Admin(String name, String phoneNumber, String address, int salary) {
        super(name, phoneNumber, address);
        this.salary = salary;
    }
    public Admin(String name, String phoneNumber, String address, int salary, UUID schoolID) {
        super(name, phoneNumber, address, schoolID);
        this.salary = salary;

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void assignToProgram(Student student, String programName) {
         /*super.getSchool().getProgram(programName).getEvents().forEach(event -> {
             event.addAttendee(student);
         });*/
    }

    public void registerAPerson(IPerson student) {
        // Implémentez la logique pour enregistrer une personne (étudiant) dans le système.

    }

    public void createProgram(String programName) {
        // Implémentez la logique pour créer un nouveau programme avec le nom spécifié.
        //super.getSchool().addProgram(new Program(programName));
    }

    public void addEventToProgram(IEvent event, String programName) {
        // Implémentez la logique pour ajouter un événement à un programme spécifié.
    }


}
