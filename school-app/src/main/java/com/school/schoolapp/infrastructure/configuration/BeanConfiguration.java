package com.school.schoolapp.infrastructure.configuration;

import com.school.schoolapp.domain.services.DomainSchoolService;
import com.school.schoolapp.domain.services.SchoolService;
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
}