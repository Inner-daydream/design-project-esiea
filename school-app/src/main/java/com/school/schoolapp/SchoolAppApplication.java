package com.school.schoolapp;

import com.school.schoolapp.domain.implementations.School;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SchoolAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolAppApplication.class, args);
	}
}
