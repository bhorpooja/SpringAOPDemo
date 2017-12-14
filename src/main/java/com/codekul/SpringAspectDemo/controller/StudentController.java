package com.codekul.SpringAspectDemo.controller;

import com.codekul.SpringAspectDemo.domain.Student;
import com.codekul.SpringAspectDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/getList")
    public List<Student> getList(){
        List<Student> list=studentRepo.findAll();
        return list;
    }

    @PostMapping("updateStudent/{name}/{city}")
    public Student updateStudent(@PathVariable String name,@PathVariable String city){
        Student student=studentRepo.findByName(name);
//        System.out.println(student.toString());
        student.setCity(city);
        studentRepo.save(student);
        return student;
    }

    @GetMapping("/division/{a}/{b}")
    public Integer div(@PathVariable Integer a,@PathVariable Integer b){
        Integer c=a/b;
        return c;

    }
}
