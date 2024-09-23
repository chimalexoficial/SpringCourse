package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("All data deleted :)");
		System.out.println(numRowsDeleted + " rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println(studentId + "deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id: PK
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student... ");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display the list of students
		for(int i = 0; i < theStudents.size(); i++) {
			System.out.println(theStudents.get(i));
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(int i = 0; i < theStudents.size(); i++) {
			System.out.println(theStudents.get(i));
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@mail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student, generated id: " + theId);

		// retrieve student based on id: PK
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent =  studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@mail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@mail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@mail.com");

		// save student objects
		System.out.println("Saving 3 students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@mail.com");

		// save student object
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		// display if saved student
		System.out.println("Saved student. Id is: " + tempStudent.getId());
	}
}
