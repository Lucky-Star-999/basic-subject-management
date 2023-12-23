package com.example.basicsubjectmanagement.controller;

import com.example.basicsubjectmanagement.exception.ResourceNotFoundException;
import com.example.basicsubjectmanagement.model.Student;
import com.example.basicsubjectmanagement.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Student Controller", description = "Student controller")
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "getAllStudents", description = "Get all students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "getStudentById", description = "Get student by ID")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @PostMapping
    @Operation(summary = "createStudent", description = "Create a student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    @Operation(summary = "updateStudent", description = "Update a student")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.getStudentById(id).map(student -> {
            student.setFullName(updatedStudent.getFullName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhone(updatedStudent.getPhone());
            student.setMajor(updatedStudent.getMajor());
            return studentService.saveStudent(student);
        }).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deleteStudent", description = "Delete a student by ID")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
