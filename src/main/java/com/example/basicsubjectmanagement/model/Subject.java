package com.example.basicsubjectmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToOne(mappedBy = "subject")
    private Teacher teacher;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
}
