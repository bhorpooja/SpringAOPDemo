package com.codekul.SpringAspectDemo.controller;

import com.codekul.SpringAspectDemo.domain.Student;
import com.codekul.SpringAspectDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by pooja on 12/12/17.
 */

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        studentRepo.save(student);
        return "Student Saved Successfully..";
    }

    @GetMapping("/getStudent/{name}")
    public Student getStudent(@PathVariable String name){
        Student student=studentRepo.findByName(name);
//        System.out.println(student.toString());
        return student;
    }

    @PostMapping("updateStudent/{name}/{city}")
    public String updateStudent(@PathVariable String name,@PathVariable String city){
        Student student=studentRepo.findByName(name);
        student.setCity(city);
        studentRepo.save(student);
        return "Student Updated";
    }
}
