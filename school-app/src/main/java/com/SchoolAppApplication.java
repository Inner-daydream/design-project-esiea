package com;

import com.domain.implementations.School;
import com.infrastructure.persistance.SchoolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("my.package.base.*")
@EntityScan("my.package.base.*")
public class SchoolAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolAppApplication.class, args);
	}
	@Bean
	CommandLineRunner command(SchoolRepository repository){
		return args -> {
			School sc = new School("name", "10 rue de la latte" ,"013812812");

			repository.save(sc);
		};
	}
}
