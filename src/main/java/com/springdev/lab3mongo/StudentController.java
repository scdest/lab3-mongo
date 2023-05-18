package com.springdev.lab3mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        student.setId(UUID.fromString(id));
        studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studentRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentRepository.deleteById(UUID.fromString(id));
    }
}
