package com.learningcode.cruddemo;

import com.learningcode.cruddemo.dao.StudentDAO;
import com.learningcode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student aNewStudent = new Student("Hoang", "Thanh The", "thehoang13102001@gmail.com");

		// save the student object
		System.out.println("Saving the student to the database ...");
		studentDAO.save(aNewStudent);

		// display id of the saved student
		System.out.println("Saved student. Generate id: " + aNewStudent.getId());
	}
}






