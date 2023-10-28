/*
package com.school.schoolapp.config;

import com.school.schoolapp.entity.*;
import com.school.schoolapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner(IAdminRepository adminRepository,
                                        IClassroomRepository classroomRepository,
                                        IStudentRepository studentRepository,
                                        ITeacherRepository teacherRepository,
                                        ISchoolRepository schoolRepository){
        return args -> {

            Admin adm1 = new Admin(
                    "admin1",
                    "06571271",
                    "my addr",
                    new School()
            );
            Admin adm2 =new Admin(
                    "admin2",
                    "06571271",
                    "my addr",
                    new School()
            );
            Classroom class1 = new Classroom(
                    "class1",
                    "building1",
                    50
            );
            Classroom class2 = new Classroom(
                    "class2",
                    "building2",
                    50
            );

            Student stu1 = new Student(
                    "stu1",
                    "06571271",
                    "my addr",
                    null,
                    0
            );
            Student stu2 =new Student(
                    "stu2",
                    "06571271",
                    "my addr",
                    null,
                    0
            );
            Teacher tea1 = new Teacher(
                    "tea1",
                    "06571271",
                    "my addr",
                    null,
                    0
            );

            Teacher tea2 =new Teacher(
                    "tea2",
                    "06571271",
                    "my addr",
                    null,
                    0
            );

            teacherRepository.saveAll(List.of(tea1, tea2));
            studentRepository.saveAll(List.of(stu1, stu2));
            classroomRepository.saveAll(List.of(class1, class2));
            adminRepository.saveAll(List.of(adm1, adm2));

        };
    }
}
*/
