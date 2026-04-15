
package com.example.task11.controller;

import com.example.task11.entity.Student;
import com.example.task11.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return repo.save(s);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // FILTER by department
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return repo.findByDepartment(dept);
    }

    // FILTER by age
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return repo.findByAgeGreaterThan(age);
    }

    // SORT by name
    @GetMapping("/sort/name")
    public List<Student> sortByName() {
        return repo.findAll(Sort.by("name"));
    }

    // SORT by age desc
    @GetMapping("/sort/age")
    public List<Student> sortByAge() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "age"));
    }

    // PAGINATION
    @GetMapping("/page")
    public Page<Student> getPage(@RequestParam int page, @RequestParam int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
