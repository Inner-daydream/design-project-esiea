package com.school.schoolapp.infrastructure.configuration;

import com.school.schoolapp.domain.ports.*;
import com.school.schoolapp.domain.services.admin.AdminService;
import com.school.schoolapp.domain.services.admin.DomainAdminService;
import com.school.schoolapp.domain.services.classroom.ClassroomService;
import com.school.schoolapp.domain.services.classroom.DomainClassroomService;
import com.school.schoolapp.domain.services.conference.ConferenceService;
import com.school.schoolapp.domain.services.conference.DomainConferenceService;
import com.school.schoolapp.domain.services.course.CourseService;
import com.school.schoolapp.domain.services.course.DomainCourseService;
import com.school.schoolapp.domain.services.event.DomainEventService;
import com.school.schoolapp.domain.services.event.EventService;
import com.school.schoolapp.domain.services.gradeEvent.DomainGradeEventService;
import com.school.schoolapp.domain.services.gradeEvent.GradeEventService;
import com.school.schoolapp.domain.services.person.DomainPersonService;
import com.school.schoolapp.domain.services.program.DomainProgramService;
import com.school.schoolapp.domain.services.program.PersonService;
import com.school.schoolapp.domain.services.program.ProgramService;
import com.school.schoolapp.domain.services.school.DomainSchoolService;
import com.school.schoolapp.domain.services.school.SchoolService;
import com.school.schoolapp.domain.services.student.DomainStudentService;
import com.school.schoolapp.domain.services.student.StudentService;
import com.school.schoolapp.domain.services.teacher.DomainTeacherService;
import com.school.schoolapp.domain.services.teacher.TeacherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public SchoolService schoolService(final SchoolRepository schoolRepository) {
        return new DomainSchoolService(schoolRepository);
    }

    @Bean
    public ClassroomService classroomService(final ClassroomRepository classroomRepository){
        return new DomainClassroomService(classroomRepository);
    }

    @Bean
    public AdminService adminService(final AdminRepository adminRepository){
        return new DomainAdminService(adminRepository);
    }

    @Bean
    public PersonService personService(final PersonRepository personRepository){
        return new DomainPersonService(personRepository);
    }
    @Bean
    public EventService eventService(final EventRepository eventRepository){
        return new DomainEventService(eventRepository);
    }
    @Bean
    public GradeEventService gradeEventService(final GradeEventRepository gradeEventRepository){
        return new DomainGradeEventService(gradeEventRepository);
    }


    @Bean
    public StudentService studentService(final StudentRepository studentRepository){
        return new DomainStudentService(studentRepository);
    }

    @Bean
    public TeacherService teacherService(final TeacherRepository teacherRepository){
        return new DomainTeacherService(teacherRepository);
    }

    @Bean
    public ProgramService programService(final ProgramRepository programRepository){
        return new DomainProgramService(programRepository);
    }
    @Bean
    public CourseService courseService(final CourseRepository courseRepository){
        return new DomainCourseService(courseRepository);
    }
    @Bean
    public ConferenceService conferenceService(final ConferenceRepository conferenceRepository, final StudentRepository studentRepository){
        return new DomainConferenceService(conferenceRepository, studentRepository);
    }
}