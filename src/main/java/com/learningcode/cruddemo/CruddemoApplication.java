package com.learningcode.cruddemo;

import com.learningcode.cruddemo.dao.StudentDAO;
import com.learningcode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	// Create Object
	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 new student objects ...");
		Student firstNewStudent = new Student("Hoang", "Thanh A", "thehoang13102001@gmail.com");
		Student secondNewStudent = new Student("Hoang", "Thanh B", "thehoang13102001@gmail.com");
		Student thirdNewStudent = new Student("Hoang", "Thanh C", "thehoang13102001@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(firstNewStudent);
		studentDAO.save(secondNewStudent);
		studentDAO.save(thirdNewStudent);

		System.out.println("Saved all the students!!!");
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

	// read Object
	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Hoang", "Thanh The", "thehoang@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student founded
		System.out.println("Found the student: " + myStudent);

	}


	// query Object
	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		theStudents.forEach(student -> {
			System.out.println(student);
		});
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students by lastName
		List<Student> theStudents = studentDAO.findByLastName("Thanh C");

		// display list of students
		theStudents.forEach(student -> {
			System.out.println(student);
		});
	}

}






