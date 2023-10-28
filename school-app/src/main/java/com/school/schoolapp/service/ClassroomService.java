package com.school.schoolapp.service;

import com.school.schoolapp.entity.Classroom;
import com.school.schoolapp.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    private final IClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(IClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

}
