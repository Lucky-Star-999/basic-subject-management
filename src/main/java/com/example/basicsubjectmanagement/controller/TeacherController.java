package com.example.basicsubjectmanagement.controller;

import com.example.basicsubjectmanagement.exception.ResourceNotFoundException;
import com.example.basicsubjectmanagement.model.Teacher;
import com.example.basicsubjectmanagement.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Teacher Controller", description = "Teacher controller")
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    @Operation(summary = "getAllTeachers", description = "Get all teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "getTeacherById", description = "Get teacher by ID")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }

    @PostMapping
    @Operation(summary = "createTeacher", description = "Create a teacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/{id}")
    @Operation(summary = "updateTeacher", description = "Update a teacher")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        return teacherService.getTeacherById(id).map(teacher -> {
            teacher.setFullName(updatedTeacher.getFullName());
            teacher.setEmail(updatedTeacher.getEmail());
            teacher.setPhone(updatedTeacher.getPhone());
            teacher.setDepartment(updatedTeacher.getDepartment());
            return teacherService.saveTeacher(teacher);
        }).orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deleteTeacher", description = "Delete a teacher by ID")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
