package com.school.schoolapp.infrastructure.repository.postgre;
import java.util.Optional;
import java.util.UUID;

import com.school.schoolapp.domain.Interfaces.IEvent;
import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.abstractions.Person;
import com.school.schoolapp.domain.implementations.Student;
import com.school.schoolapp.domain.ports.EventRepository;
import com.school.schoolapp.infrastructure.entities.EventEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostgreEventRepository implements EventRepository {
    private final PostgreEventDataRepository postgreEventDataRepository;
    @Autowired
    public PostgreEventRepository(PostgreEventDataRepository postgreEventDataRepository) {
        this.postgreEventDataRepository = postgreEventDataRepository;
    }

    @Override
    public void save(IEvent event) {
        EventEntity eventEntity = new EventEntity(event);
        this.postgreEventDataRepository.save(eventEntity);
    }

    // @Override
    // public IEvent findById(String id) {
    //     EventEntity res = this.postgreEventDataRepository.findById(id).orElseThrow();
    //     return new Event(
    //             res.getName(),
    //             res.getClassroom().toClassroom(),
    //             res.getStartDate(),
    //             res.getEndDate(),
    //             res.getAttendees().stream().map(item ->
    //                     new Student(item.getName(), item.getAddress(), item.getPhoneNumber())
    //             ).toList(),
    //             res.getCapacity(),
    //             res.isOptional()
    //     );
    //     // {
    //     //     @Override
    //     //     public Person getTeacher() throws Exception {
    //     //         throw new Exception("is not teacher");
    //     //     }
    //     // };
    // }
}
