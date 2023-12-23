package com.example.basicsubjectmanagement.controller;

import com.example.basicsubjectmanagement.exception.ResourceNotFoundException;
import com.example.basicsubjectmanagement.model.Subject;
import com.example.basicsubjectmanagement.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Subject Controller", description = "Subject controller")
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    @Operation(summary = "getAllSubjects", description = "Get all subjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    @Operation(summary = "getSubjectById", description = "Get subject by ID")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    @PostMapping
    @Operation(summary = "createSubject", description = "Create a subject")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @PutMapping("/{id}")
    @Operation(summary = "updateSubject", description = "Update a subject")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject) {
        return subjectService.getSubjectById(id).map(subject -> {
            subject.setTitle(updatedSubject.getTitle());
            subject.setDescription(updatedSubject.getDescription());
            return subjectService.saveSubject(subject);
        }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deleteSubject", description = "Delete a subject by ID")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
