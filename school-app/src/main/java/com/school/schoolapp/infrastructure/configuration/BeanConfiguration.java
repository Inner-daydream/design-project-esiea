package com.school.schoolapp.infrastructure.configuration;

import com.school.schoolapp.domain.ports.*;
import com.school.schoolapp.domain.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
    public StudentService studentService(final StudentRepository studentRepository){
        return new DomainStudentService(studentRepository);
    }

    @Bean
    public TeacherService teacherService(final TeacherRepository teacherRepository){
        return new DomainTeacherService(teacherRepository);
    }
}