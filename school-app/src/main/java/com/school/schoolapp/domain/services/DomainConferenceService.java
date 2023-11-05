package com.school.schoolapp.domain.services;
import com.school.schoolapp.domain.ports.ConferenceRepository;
import com.school.schoolapp.domain.ports.StudentRepository;
import com.school.schoolapp.domain.implementations.Conference;
import com.school.schoolapp.domain.implementations.Student;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class DomainConferenceService implements ConferenceService{
    private final ConferenceRepository conferenceRepository;
    private final StudentRepository studentRepository;
    public DomainConferenceService(ConferenceRepository conferenceRepository, StudentRepository studentRepository){
        this.conferenceRepository = conferenceRepository;
        this.studentRepository = studentRepository;
    }
    @Override
    public UUID createConference(Conference conference) {
        conferenceRepository.save(conference);
        return conference.getId();
    }

    public List<Student> getStudents(List<String> studentsIDS){
        List<Student> students = new ArrayList<Student>();
        for(String id : studentsIDS){
            students.add(studentRepository.findById(id).get());
        }
        return students;
    }
    @Override
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll().get();
    }

    
}
