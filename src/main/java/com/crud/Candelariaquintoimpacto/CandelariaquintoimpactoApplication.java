package com.crud.Candelariaquintoimpacto;

import com.crud.Candelariaquintoimpacto.models.*;
import com.crud.Candelariaquintoimpacto.models.enums.TurnEnum;
import com.crud.Candelariaquintoimpacto.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CandelariaquintoimpactoApplication{


	public static void main(String[] args) {
		SpringApplication.run(CandelariaquintoimpactoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData (StudentRepository studentRepository, CourseRepository courseRepository, TeacherRepository teacherRepository, AdminRepository adminRepository, StudentCourseRepository studentCourseRepository) {
		return (args) -> {

				Admin admin = Admin.builder()
						.name("admin")
						.surname("istrador")
						.build();

				List<Course> courses = new ArrayList<>();
				Teacher teacher1 = Teacher.builder()
						.name("John")
						.surname("Williams")
						.courses(courses)
						.build();

				Teacher teacher2 = Teacher.builder()
						.name("Ashley")
						.surname("Davies")
						.courses(courses)
						.build();

				Teacher teacher3 = Teacher.builder()
						.name("Adam")
						.surname("James")
						.courses(courses)
						.build();


				Student student1 = Student.builder()
						.name("Oliver")
						.surname("Johnson")
						.age(21)
						.build();

				Student student2 = Student.builder()
						.name("Michael")
						.surname("Brown")
						.age(28)
						.build();

				Student student3 = Student.builder()
						.name("Harry")
						.surname("Smith")
						.age(28)
						.build();

				Course math = Course.builder()
						.name("Math")
						.description("one curse of math")
						.timetable("8:00")
						.turn(TurnEnum.Morning)
						.teacher(teacher1)
						.build();

				Course physics = Course.builder()
						.name("Physics")
						.description("one curse of physics")
						.timetable("11:00")
						.turn(TurnEnum.Morning)
						.teacher(teacher1)
						.build();

				Course french = Course.builder()
						.name("French")
						.description("one curse of french")
						.timetable("14:00")
						.turn(TurnEnum.Afternoon)
						.teacher(teacher2)
						.build();

				Course philosophy = Course.builder()
						.name("Philosophy")
						.description("one curse of philosophy")
						.timetable("19:00")
						.turn(TurnEnum.Evening)
						.teacher(teacher3)
						.build();


				StudentCourse studentcourse1 = StudentCourse.builder()
						.course(math)
						.student(student1)
						.build();

				StudentCourse studentcourse2 = StudentCourse.builder()
						.course(physics)
						.student(student1)
						.build();

				StudentCourse studentcourse3 = StudentCourse.builder()
						.course(french)
						.student(student2)
						.build();

				StudentCourse studentcourse4 = StudentCourse.builder()
						.course(math)
						.student(student3)
						.build();


				adminRepository.save(admin);
				teacherRepository.save(teacher1);
				teacherRepository.save(teacher2);
				teacherRepository.save(teacher3);

				studentRepository.save(student1);
				studentRepository.save(student2);
				studentRepository.save(student3);

				courseRepository.save(math);
				courseRepository.save(physics);
				courseRepository.save(french);
				courseRepository.save(philosophy);


				studentCourseRepository.save(studentcourse1);
				studentCourseRepository.save(studentcourse2);
				studentCourseRepository.save(studentcourse3);
				studentCourseRepository.save(studentcourse4);

			};

		};
	}

