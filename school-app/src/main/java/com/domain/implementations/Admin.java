package com.domain.implementations;

import com.domain.Interfaces.IEvent;
import com.domain.Interfaces.IPerson;
import com.domain.abstractions.Person;

public class Admin extends Person {
    public Admin(String name, String phoneNumber, String address, School school) {
        super(name, phoneNumber, address, school);
    }

    public void assignToProgram(Student student, String programName) {
        super.getSchool().getProgram(programName).getEvents().forEach(event -> {
            event.addAttendee(student);
        });
    }

    public void registerAPerson(IPerson student) {
        // Implémentez la logique pour enregistrer une personne (étudiant) dans le système.
        
    }

    public void createProgram(String programName) {
        // Implémentez la logique pour créer un nouveau programme avec le nom spécifié.
    }

    public void addEventToProgram(IEvent event, String programName) {
        // Implémentez la logique pour ajouter un événement à un programme spécifié.
    }


}
