package com.example.basicsubjectmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student extends PersonBase {
    private String major;

    @ManyToMany
    @JoinTable(
            name = "student_subject_relation",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;
}
