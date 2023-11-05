package com.school.schoolapp.infrastructure.repository.postgre.GradeEvent;

import com.school.schoolapp.domain.abstractions.Event;
import com.school.schoolapp.domain.implementations.*;
import com.school.schoolapp.domain.ports.GradeEventRepository;
import com.school.schoolapp.infrastructure.entities.EventEntity;
import com.school.schoolapp.infrastructure.entities.GradeEventEntity;
import com.school.schoolapp.infrastructure.entities.PersonEntity;
import com.school.schoolapp.infrastructure.repository.postgre.PostgreEventDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostgreGradeEventRepository implements GradeEventRepository {

    private final PostgreGradeEventDataRepository postgreGradeEventDataRepository;
    @Autowired

    public PostgreGradeEventRepository(PostgreGradeEventDataRepository postgreGradeEventDataRepository) {
        this.postgreGradeEventDataRepository = postgreGradeEventDataRepository;
    }



    @Override
    public Optional<GradeEvent> findById(String id) {
        Optional<GradeEventEntity> gradeEventEntity = this.postgreGradeEventDataRepository.findById(id);
        if (gradeEventEntity.isPresent()) {
            EventEntity event = gradeEventEntity.get().getEvent();

            PersonEntity person = gradeEventEntity.get().getPerson();
            GradeEvent gradeEvent = new GradeEvent(new Course(
                    false, //out of my pocket
                    new Teacher(
                            event.getPersonEntity().getName(),
                            event.getPersonEntity().getAddress(),
                            event.getPersonEntity().getPhoneNumber(),0),
                    event.getName(),
                    new Classroom(
                            event.getClassroom().getName(),
                            event.getClassroom().getBuildingName(),
                            event.getCapacity()
                    ),
                    event.getStartDate(),
                    event.getEndDate(),
                    event.getAttendees().stream().map(item ->
                            new Student(item.getName(), item.getAddress(), item.getPhoneNumber())
                    ).toList(),
                    event.getCapacity(),
                    event.isOptional()



            ), new Student(
                    person.getName(),
                    person.getPhoneNumber(),
                    person.getAddress()
            ) );
            gradeEventEntity.get().getGrades().forEach(item -> {
                        gradeEvent.addGrade(item);
                    }
                    );
            return Optional.of(gradeEvent);
        }
        return Optional.empty();
    }

    @Override
    public void save(GradeEvent gradeEvent) {
        GradeEventEntity gradeEventEntity = new GradeEventEntity(gradeEvent);
        postgreGradeEventDataRepository.save(gradeEventEntity);
    }
}
