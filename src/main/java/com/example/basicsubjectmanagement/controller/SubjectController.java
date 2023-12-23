package com.example.basicsubjectmanagement.controller;

import com.example.basicsubjectmanagement.exception.ResourceNotFoundException;
import com.example.basicsubjectmanagement.model.Subject;
import com.example.basicsubjectmanagement.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject) {
        return subjectService.getSubjectById(id).map(subject -> {
            subject.setTitle(updatedSubject.getTitle());
            subject.setDescription(updatedSubject.getDescription());
            return subjectService.saveSubject(subject);
        }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }
}
