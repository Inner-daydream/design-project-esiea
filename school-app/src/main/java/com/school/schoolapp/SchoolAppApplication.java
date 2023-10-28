package com.school.schoolapp;
import com.domain.implementations.School;
import com.domain.implementations.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SchoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAppApplication.class, args);
	}
	/*@GetMapping
	public List<Student> hello(){
		return List.of(new Student("student1","student1", "06571271", "my addr",
				new School("school1","name", "addr", "phone")));
	}*/
}
