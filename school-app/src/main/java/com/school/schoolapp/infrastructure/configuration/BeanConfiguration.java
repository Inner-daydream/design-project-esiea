package com.school.schoolapp.infrastructure.configuration;

import com.school.schoolapp.domain.ports.AdminRepository;
import com.school.schoolapp.domain.ports.ClassroomRepository;
import com.school.schoolapp.domain.ports.PersonRepository;
import com.school.schoolapp.domain.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.school.schoolapp.domain.ports.SchoolRepository;
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
}