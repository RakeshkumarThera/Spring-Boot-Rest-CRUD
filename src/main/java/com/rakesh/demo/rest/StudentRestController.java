package com.rakesh.demo.rest;

import com.rakesh.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rakesh", "Thera"));
        theStudents.add(new Student("Reshma", "Thera"));
        theStudents.add(new Student("Ravi", "Thera"));
    }

    //define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint for "/students/{studentid}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }
}
