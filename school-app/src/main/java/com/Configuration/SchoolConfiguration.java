/*package com.Configuration;

import com.domain.implementations.School;
import com.infrastructure.persistance.SchoolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.infrastructure.persistance"})
public class SchoolConfiguration {
    @Bean
    CommandLineRunner command(SchoolRepository repository){
        return args -> {
            School sc = new School("name", "10 rue de la latte" ,"013812812");
            repository.save(sc);
        };
    }
}*/
