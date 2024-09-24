package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define @PostConstruct to load student data - called only once
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        Student student1 = new Student("Poornima", "Patel");
        Student student2 = new Student("Mario", "Rossi");
        Student student3 = new Student("Mary", "Smith");

        theStudents.add(student1);
        theStudents.add(student2);
        theStudents.add(student3);
    }

    // define endpoint for /students - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check studentId against list size
        if(studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler

}
